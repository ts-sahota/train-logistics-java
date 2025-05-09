/*
CS 1027B – Assignment 2
Name: Tanya Sahota
Student Number: 251446953
Email: tsahot@uwo.ca
Created: February 21, 2025
*/

// Reefer class is inherited from TrainCar
public class Reefer extends TrainCar {
	// Initialize private instance variable for temperature of reefer
    private int temp; 

    // Constructor to initialize each of the instance variables with the corresponding parameter values
    public Reefer(int weight, int temp, String freight) {
        super(weight, freight);
        this.temp = temp;
    }

    // Gets the temperature of the reefer and returns it
    public int getTemp() {
        return temp;
    }

    // Sets a new temperature of the reefer 
    public void setTemp(int temp) {
        this.temp = temp;
    }

    // Return string representing the reefer in format <freight, weight, tempC>
    public String toString() {
        return "<" + super.getFreight() + ", " + super.getWeight() + ", " + temp + "C>";
    }

    // Determine if this reefer can connect to another
    public boolean canConnect(TrainCar other) {
        if (super.canConnect(other)) { // Determine if the car can connect based on freight type or weight
            return true;
        }
        if (other instanceof Reefer) { // Determine if other TrainCar is a reefer
            Reefer otherReefer = (Reefer) other;
            return Math.abs(this.temp - otherReefer.temp) <= 5;// Determine if temperature difference between reefers is <= 5 
        }
        return false; // Cannot connect if neither condition is met
    }

    // Determine if this reefer is identical to another TrainCar
    public boolean equals(TrainCar other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Reefer)) { // Otherwise, determine if both are reefers
            return false;
        }
        Reefer otherReefer = (Reefer) other;
        return super.equals(otherReefer) && this.temp == otherReefer.temp; // Determine if both reefers have same temperature and compares weight and freight type 
    }
}



