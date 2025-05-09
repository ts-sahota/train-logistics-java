
/*
CS 1027B – Assignment 2
Name: Tanya Sahota
Student Number: 251446953
Email: tsahot@uwo.ca
Created: February 19, 2025
*/

public class TrainCar {
	// Initialize private instance variables for weight and freight of TrainCar
    private int weight;
    private String freight;

    // Constructor to initialize each of the instance variables with the corresponding parameter values
    public TrainCar(int weight, String freight) {
        this.weight = weight;
        this.freight = freight;
    }
    // Getter to get weight of TrainCar
    public int getWeight() {
        return weight;
    }
    
    // Getter to get freight of TrainCar
    public String getFreight() {
        return freight;
    }

    // Setter to set weight of TrainCar
    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    // Setter to set freight of TrainCar
    public void setFreight(String freight) {
        this.freight = freight;
    }
    
    // Return string representing TrainCar in format <freight, weight>
    public String toString() {
        return "<" + freight + ", " + weight + ">";
    }
    
    // Determine whether this TrainCar can connect to another by checking if they have the same freight type or weight
    public boolean canConnect(TrainCar other) {
        return this.freight.equals(other.freight) || this.weight == other.weight;
    }
    
    // Determine whether this TrainCar and another are identical by checking if the freight type and weight of both TrainCar objects match
    public boolean equals(TrainCar other) {
        if (this.getClass() != other.getClass()) {
            return false;
        }
        return this.freight.equals(other.freight) && this.weight == other.weight;
    }
}



