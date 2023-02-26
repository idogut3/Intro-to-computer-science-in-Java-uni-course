/**
 * @author Ido Gutman
 * @authorID 329200216
 * @description: <p>
 * This is the Class of the flight object.
 * </p>
 */

import java.util.Objects;

public class Flight {
    private String _origin; //The city which the plane takes off from;
    private String _destination; //Destination of the flight (which city);

    private Time1 _departure; //The time which the flight takes off;
    private int _flightDuration; //Flight duration in minutes;

    private int _noOfPassengers; //Number of travelers on the plane;
    private final int MAX_CAPACITY = 250; //Max capacity of travelers;
    private boolean _isFull; //Is the plane full;

    private int _price; //Price of flight per traveler;

    public Flight(String origin, String destination, int hour, int minute, int flightDuration, int numOfTravelers, int price) { //Constructor
        this._origin = origin;
        this._destination = destination;
        this._departure = new Time1(hour, minute);

        if (MAX_CAPACITY <= numOfTravelers) {
            this._noOfPassengers = MAX_CAPACITY;
            this._isFull = true;
        } else if (numOfTravelers <= 0) {
            this._noOfPassengers = 0;
            this._isFull = false;
        } else {
            this._noOfPassengers = numOfTravelers;
            this._isFull = false;
        }
        if (flightDuration <= 0) {
            this._flightDuration = 0;
        } else {
            this._flightDuration = flightDuration;
        }
        if (price <= 0) {
            this._price = 0;
        } else {
            this._price = price;
        }
    }

    public Flight(Flight other) { //Copy constructor
        this._origin = other._origin;
        this._destination = other._destination;
        this._departure = new Time1(other._departure.getHour(), other._departure.getMinute());
        this._flightDuration = other._flightDuration;
        this._noOfPassengers = other._noOfPassengers;
        this._isFull = other._isFull;
        this._price = other._price;
    }

    public String getOrigin() { //Returns origin;
        return this._origin;
    }

    public String getDestination() { //Returns destination;
        return this._destination;
    }

    public Time1 getDeparture() { //Returns departure;
        return new Time1(this._departure);
    }

    public int getFlightDuration() { //Returns flight duration;
        return this._flightDuration;
    }

    public int getNoOfPassengers() { //Returns num of passengers;
        return this._noOfPassengers;
    }

    public boolean getIsFull() { //Returns true if the flight is full otherwise returns false;
        return this._isFull;
    }

    public int getPrice() { //Returns price;
        return this._price;
    }

    public void setDestination(String dest) { //Sets new destination to the flight;
        this._destination = dest;
    }

    public void setOrigin(String origin) { //Sets new origin to the flight;
        this._origin = origin;
    }

    public void setDeparture(Time1 departureTime) { //Sets new departure time to the flight;
        this._departure = new Time1(departureTime);
    }

    public void setFlightDuration(int durTimeMinutes) { //Sets new flight duration; if the new flight duration is lower than 0 doesn't;
        if (durTimeMinutes >= 0) {
            this._flightDuration = durTimeMinutes;
        }
    }

    public void setNoOfPassengers(int noOfPass) { //Sets new num of passengers; if the new num of passengers is lower than 0 or higher than the max capacity doesn't change;
        if (noOfPass >= 0 && noOfPass <= MAX_CAPACITY) {
            this._noOfPassengers = noOfPass;
        }
    }

    public void setPrice(int price) { //Sets new price per person to the flight; if price is lower than 0 doesn't;
        if (price >= 0) {
            this._price = price;
        }
    }

    @Override
    public String toString() { //Return a string representation of this flight;
        if (this.getIsFull()) {
            return "Flight from " + this.getOrigin() + " to " + this.getDestination() + " departs at " + getDeparture() + ".Flight is full.";
        }
        return "Flight from " + this.getOrigin() + " to " + this.getDestination() + " departs at " + getDeparture() + ".Flight is not full.";
    }

    public boolean equals(Flight other) { //Returns true if origin, destination, departure time is equal to other origin, destination, departure time;
        if (Objects.equals(this._origin, other._origin) && Objects.equals(this._destination, other._destination) && this.getDeparture().equals(other.getDeparture())) {
            return true;
        }
        return false;
    }

    public Time1 getArrivalTime() { // Returns the arrival time of the flight;
        return this.getDeparture().addMinutes(this.getFlightDuration());
    }

    public boolean addPassengers(int num) { //Adds passengers to the flight if there is enough space; returns true if added otherwise returns false;
        if (num + this.getNoOfPassengers() <= MAX_CAPACITY) {
            this.setNoOfPassengers(num + this.getNoOfPassengers());
            if (MAX_CAPACITY == this.getNoOfPassengers()) {
                this._isFull = true;
            }
            return true;
        }
        return false;
    }

    public boolean isCheaper(Flight other) { //Returns true if this flight is cheaper than the received flight;
        if (this.getPrice() < other.getPrice()) {
            return true;
        }
        return false;
    }

    public int totalPrice() { //Returns the total price of the flight;
        return this.getPrice() * this.getNoOfPassengers();
    }

    public boolean landsEarlier(Flight other) { //Returns true if this flight arrives before the received flight;
        if (this.getArrivalTime().before(other.getArrivalTime())) {
            return true;
        }
        return false;
    }

}
