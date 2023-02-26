/**
 * @author Ido Gutman
 * @authorID 329200216
 * @description: <p>
 * This is the Class of the Time2 object.
 * </p>
 */

public class Time2 {
    private int _minFromMid;

    public Time2(int h, int m) { //Constructor
        if (h < 0 || h > 24) {
            this._minFromMid = 0;
        } else {
            this._minFromMid = 60 * h;
        }
        if (m >= 0 && m < 60) {
            this._minFromMid += m;
        }
    }

    public Time2(Time2 other) { //Copy constructor
        this._minFromMid = other._minFromMid;
    }

    public int getMinute() { //Returns the minute of the time;
        return this._minFromMid % 60;
    }

    public int getHour() { //Returns the hour of the time;
        return this._minFromMid / 60;
    }

    public void setMinute(int num) { //Changes the minute of the time. If an illegal number is received minute will be unchanged.
        if (num >= 0 && num < 60) {
            this._minFromMid = this.getHour() * 60 + num;
        }
    }

    public void setHour(int num) { //Changes the hour of the time. If an illegal number is received hour will be unchanged;
        if (num >= 0 && num < 24) {
            this._minFromMid = this.getMinute() + num * 60;
        }
    }

    public int minFromMidnight() { //Return the amount of minutes since midnight;
        return this._minFromMid;
    }

    public boolean equals(Time2 other) { //Returns true if the received time is equal to this time otherwise returns false;
        if (this._minFromMid == other._minFromMid) {
            return true;
        }
        return false;
    }

    public boolean before(Time2 other) { //Returns true if this time is before the other time; otherwise returns false;
        if (this.getHour() < other.getHour() || (this.getHour() == other.getHour() && this.getMinute() < other.getMinute())) {
            return true;
        }
        return false;
    }

    public boolean after(Time2 other) { //Returns true if this time is after other time; otherwise returns false
        if (other.before(this)) {
            return true;
        }
        return false;
    }

    public int difference(Time2 other) { //Calculates the difference (in minutes) between two times returns it;
        return this.minFromMidnight() - other.minFromMidnight();
    }

    public String toString() { //Return a string representation of this Time2;
        String hour = this.getHour() + "";
        String minute = this.getMinute() + "";
        if (this.getHour() < 10) {
            hour = "0" + hour;
        }
        if (this.getMinute() < 10) {
            minute = "0" + minute;
        }
        return hour + ":" + minute;
    }

    public Time2 addMinutes(int num) { //Copy current object and add requested minutes to new object;
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
        return new Time2(hours, minutes);
    }

}
