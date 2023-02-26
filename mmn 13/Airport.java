/**
 * @author Ido Gutman
 * @authorID 329200216
 * @description: <p>
 * This is the Class of the Airport.
 * </p>
 */
public class Airport {
    int _noOfFlights;
    String _city;
    final int MAX_FLIGHTS = 200;
    Flight[] _flightsSchedule;

    public Airport(String city) {
        this._flightsSchedule = new Flight[this.MAX_FLIGHTS];
        this._noOfFlights = 0;
        this._city = city;
    }

    public boolean addFlight(Flight f1) { //Adds a flight to the flight schedule
        if ((f1.getDestination().equals(this._city)) || f1.getOrigin().equals(this._city) && this._noOfFlights < this.MAX_FLIGHTS) { //Can add to the flight lists
            this._flightsSchedule[this._noOfFlights] = new Flight(f1);
            this._noOfFlights += 1;
            return true;
        }

        return false;
    }

    public boolean removeFlight(Flight f) { //removes a flight from the flight schedule
        for (int i = 0; i < _noOfFlights; i++) {
            if (_flightsSchedule[i].equals(f)) {
                _flightsSchedule[i] = _flightsSchedule[_noOfFlights - 1];
                _flightsSchedule[_noOfFlights - 1] = null;
                _noOfFlights--;
                return true;
            }
        }
        return false;
    }

    public Time1 firstFlightFromOrigin(String place) { //returns the flight that departs at the earliest time from a certain location
        Time1 time = null;
        for (int i = 0; i < _noOfFlights; i++) {
            if (time == null && this._flightsSchedule[i].getOrigin().equals(place)) {
                time = this._flightsSchedule[i].getDeparture();
            } else if (this._flightsSchedule[i].getOrigin().equals(place)) {
                if (this._flightsSchedule[i].getDeparture().before(time)) {
                    time = this._flightsSchedule[i].getDeparture();
                }
            }
        }
        return time;
    }

    public int howManyFullFlights() { //returns how many full flights depart from/to the airport
        int fullFlights = 0;
        for (int i = 0; i < _noOfFlights; i++) {
            if (this._flightsSchedule[i].getIsFull()) {
                fullFlights += 1;
            }
        }
        return fullFlights;
    }

    public int howManyFlightsBetween(String place) { //returns how many flights depart from/to 2 specific locations
        int flightsBetween = 0;
        for (int i = 0; i < this._noOfFlights; i++) {
            if ((this._flightsSchedule[i].getOrigin().equals(place) && this._flightsSchedule[i].getDestination().equals(this._city))
                    || (this._flightsSchedule[i].getOrigin().equals(this._city) && this._flightsSchedule[i].getDestination().equals(place))) {
                flightsBetween += 1;
            }
        }
        return flightsBetween;
    }

    public Flight mostExpensiveTicket() { //returns the flight in the airport with the most expensive ticket
        if (this._noOfFlights == 0) {
            return null;
        }
        int mostExpTick = this._flightsSchedule[0].getPrice();
        Flight mostExpFlight = new Flight(this._flightsSchedule[0]);
        for (int i = 1; i < this._noOfFlights; i++) {
            if (mostExpTick < this._flightsSchedule[i].getPrice()) {
                mostExpTick = this._flightsSchedule[i].getPrice();
                mostExpFlight = new Flight(this._flightsSchedule[i]);
            }
        }
        return mostExpFlight;
    }

    public Flight longestFlight() { //returns the flight in the airport with the longest duration of flying
        if (this._noOfFlights == 0) {
            return null;
        }
        int longestDur = this._flightsSchedule[0].getFlightDuration();
        Flight longestFlightDur = new Flight(this._flightsSchedule[0]);
        for (int i = 1; i < this._noOfFlights; i++) {
            if (longestDur < this._flightsSchedule[i].getFlightDuration()) {
                longestDur = this._flightsSchedule[i].getFlightDuration();
                longestFlightDur = new Flight(this._flightsSchedule[i]);
            }
        }
        return longestFlightDur;
    }

    public String mostPopularDestination() { //returns the most popular destination in the airport/the location that the maximum amount of flights land at
        if (_noOfFlights < 1) return null;
        int count = 1, tempCount;
        String popular = _flightsSchedule[0].getDestination();
        String temp = null;
        for (int i = 0; i < (_noOfFlights - 1); i++) {
            temp = _flightsSchedule[i].getDestination();
            tempCount = 0;
            for (int j = 1; j < _noOfFlights; j++) {
                if (temp.equals(_flightsSchedule[j].getDestination()))
                    tempCount++;
                if (tempCount > count) {
                    popular = temp;
                    count = tempCount;
                }
            }
        }
        return popular;
    }

    public String toString() { //returns a String representation of the airport's flights
        if (this._noOfFlights == 0) {
            return null;
        }
        String ret = "The flights for airport " + this._city + " today are:";
        for (int i = 0; i < this._noOfFlights; i++) {
            ret += "\n" + this._flightsSchedule[i];
        }
        return ret;
    }


}
