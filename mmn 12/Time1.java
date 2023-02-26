/**
 * @author Ido Gutman
 * @authorID 329200216
 * @description: <p>
 * This is the Class of the Time1 object.
 * </p>
 */

public class Time1 {
    private int _hour;
    private int _minute;


    public Time1(int h, int m) { //Constructor
        if (h < 0 || h > 24) {
            this._hour = 0;
        } else {
            this._hour = h;
        }
        if (m < 0 || m > 60) {
            this._minute = 0;
        } else {
            this._minute = m;
        }
    }

    public Time1(Time1 other) { //Copy constructor
        this._hour = other._hour;
        this._minute = other._minute;
    }

    public int getMinute() { //Returns the minute of the time;
        return _minute;
    }

    public int getHour() { //Returns the hour of the time;
        return _hour;
    }

    public void setMin(int num) { //Changes the minute of the time. If an illegal number is received minute will be unchanged.
        if (num >= 0 && num < 60) {
            this._minute = num;
        }
    }

    public void setHour(int num) { //Changes the hour of the time. If an illegal number is received hour will be unchanged;
        if (num >= 0 && num < 24) {
            this._hour = num;
        }
    }

    public String toString() { //Return a string representation of this Time1;
        String hour = _hour + "";
        String minute = _minute + "";
        if (_hour < 10) {
            hour = "0" + hour;
        }
        if (_minute < 10) {
            minute = "0" + minute;
        }
        return hour + ":" + minute;
    }

    public int minFromMidnight() { //Return the amount of minutes since midnight;
        int minutes = _minute;
        minutes += _hour * 60;
        return minutes;
    }

    public boolean equals(Time1 t2) { ////Returns true if the received time is equal to this time otherwise returns false;
        if (this.getMinute() == t2.getMinute() && this.getHour() == t2.getHour()) {
            return true;
        }
        return false;
    }

    public boolean before(Time1 other) { //Returns true if this time is before the other time; otherwise returns false;
        if ((this.getHour() < other.getHour()) || (this.getHour() == other.getHour() && this.getMinute() < other.getMinute())) {
            return true;
        }
        return false;
    }

    public boolean after(Time1 other) { //Returns true if this time is after other time; otherwise returns false
        if (other.before(this)) {
            return true;
        }
        return false;
    }

    public int difference(Time1 other) { //Calculates the difference (in minutes) between two times returns it;
        int diff = this.getMinute() - other.getMinute();
        diff += (this.getHour() - other.getHour()) * 60;
        return diff;
    }


    public Time1 addMinutes(int num) { //Copy current object and add requested minutes to new object;
        int minutes = this.minFromMidnight() + num;
        int hours = minutes / 60;
        minutes = minutes % 60;
        if (minutes < 0) {
            minutes = 60 + minutes;
            hours = hours - 1;
        }
        if (hours >= 24) {
            hours = hours % 24;
        } else if (hours < 0) {
            hours = hours % 24;
            hours = 24 + hours;
        }
        return new Time1(hours, minutes);
    }
}
