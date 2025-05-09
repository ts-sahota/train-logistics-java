/*
CS 1027B – Assignment 2
Name: Tanya Sahota
Student Number: 251446953
Email: tsahot@uwo.ca
Created: February 23, 2025
*/

public class Train {
	// Initialize private instance variables for locomotive and caboose of TrainCar
    private DoubleNode<TrainCar> locomotive;
    private DoubleNode<TrainCar> caboose;

    // Constructor to Initialize both instance variables as null
    public Train() {
        this.locomotive = null;
        this.caboose = null;
    }

    // Gets the locomotive 
    public DoubleNode<TrainCar> getLocomotive() {
        return locomotive;
    }

    // Gets the caboose
    public DoubleNode<TrainCar> getCaboose() {
        return caboose;
    }

    // Add given car to train
    public void addCar(TrainCar car) throws TrainException { // Throws exception if car cannot be added
        DoubleNode<TrainCar> newNode = new DoubleNode<>(car);
        
        // If train is empty, locomotive and caboose are set to be added to new car
        if (locomotive == null) {
            locomotive = newNode;
            caboose = newNode;
            return;
        }
        
        // Add new car to end of TrainCar
        if (caboose.getElement().canConnect(car)) {
            caboose.setNext(newNode);
            newNode.setPrevious(caboose);
            caboose = newNode;
            return;
        }
        
        // Find a different place to add car to TrainCar if it cannot be added to the end
        DoubleNode<TrainCar> current = caboose;
        while (current.getPrevious() != null) {
            if (current.getPrevious().getElement().canConnect(car) && car.canConnect(current.getElement())) {
                newNode.setNext(current);
                newNode.setPrevious(current.getPrevious());
                current.getPrevious().setNext(newNode);
                current.setPrevious(newNode);
                return;
            }
            current = current.getPrevious();
        }
        
        // If no place is found to add the car, throw an exception
        throw new TrainException("Car could not be added");
    }

    // Try to add given car to the TrainCar
    public boolean tryAddCar(TrainCar car) {
    	
    	// If an exception occurs, return false, otherwise, return true
        try {
            addCar(car);
            return true;
        } catch (TrainException e) {
            return false;
        }
    }

    // Remove given car from TrainCar
    public void removeCar(TrainCar car) {
        DoubleNode<TrainCar> current = locomotive;
        
        // Loop through TrainCar to find car
        while (current != null) {
            if (current.getElement().equals(car)) {
            	
            	// Determine whether the TrainCar only has one car, set caboose and locomotive to null to remove
                if (current == locomotive && current == caboose) {
                    locomotive = null;
                    caboose = null;
                }
                
                // Determine whether the car is the locomotive
                else if (current == locomotive) {
                    locomotive = locomotive.getNext();
                    locomotive.setPrevious(null);
                }
                
                // Determine whether the car is the caboose
                else if (current == caboose) {
                    caboose = caboose.getPrevious();
                    caboose.setNext(null);
                }
                
                // Determine whether the car is in the middle of the train
                else {
                    if (!current.getPrevious().getElement().canConnect(current.getNext().getElement())) {
                        throw new TrainException("Car could not be removed");
                    }
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());
                }
                return;
            }
            current = current.getNext();
        }
        
        // Throw an exception if the car is not found in the TrainCar
        throw new TrainException("Car not found in train");
    }

    // Try to remove given car from this TrainCar using removeCar()
    public boolean tryRemoveCar(TrainCar car) {
    	
    	// If an exception is thrown, return false, otherwise, return true
        try {
            removeCar(car);
            return true;
        } catch (TrainException e) {
            return false;
        }
    }

    // String representation of train
    public String toString() {
    	
    	// If TrainCar is empty, state that 
        if (locomotive == null) {
            return "The train is empty.";
        }
        
        // Otherwise, list the TrainCars in order
        DoubleNode<TrainCar> current = locomotive;
        String output = current.getElement().toString();
        current = current.getNext();
        while (current != null) {
            output += ", " + current.getElement().toString();
            current = current.getNext();
        }
        return output;
    }
}




