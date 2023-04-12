package com.maman12;

/**
 * This class represents a Date object
 *
 * @author Michael Brover
 */

public class Date {

    private int _day;
    private int _month;
    private int _year;

    //Constructors

    /**
     * If the given date is valid - creates a new Date object, otherwise creates the date 1/1/2000
     *
     * @param day   the day of the month.
     * @param month the month of the year.
     * @param year  the year.
     */
    public Date(int day, int month, int year) {
        if (checkDateValidity(day, month, year)) {
            _day = day;
            _month = month;
            _year = year;
        } else {
            _day = 1;
            _month = 1;
            _year = 2000;
        }
    }

    /**
     * Copy constructor for Dates.
     *
     * @param other The date from which to construct the new object.
     */
    public Date(Date other) {
        this._day = other._day;
        this._month = other._month;
        this._year = other._year;
    }

    //Get methods

    /**
     * Gets the day.
     *
     * @return the day.
     */
    public int getDay() {
        return _day;
    }

    /**
     * Gets the month.
     *
     * @return the month.
     */
    public int getMonth() {
        return _month;
    }

    /**
     * Gets the year.
     *
     * @return the year.
     */
    public int getYear() {
        return _year;
    }

    //Set methods

    /**
     * Set the day (only if date remains valid)
     * the day of the month will not be changed.
     *
     * @param dayToSet the new day of the month.
     */
    public void setDay(int dayToSet) {
        if (checkDateValidity(dayToSet, _month, _year)) {
            _day = dayToSet;
        }
    }

    /**
     * Set the month (only if date remains valid).
     * the month of the year will not be changed.
     *
     * @param monthToSet the new month of the year.
     */
    public void setMonth(int monthToSet) {
        if (checkDateValidity(_day, monthToSet, _year)) {
            _month = monthToSet;
        }
    }

    /**
     * Set the year (only if date remains valid).
     * the year will not be changed.
     *
     * @param yearToSet the new year.
     */
    public void setYear(int yearToSet) {
        if (checkDateValidity(_day, _month, yearToSet)) {
            _year = yearToSet;
        }
    }

    //equals method

    /**
     * Check if two dates are the same.
     *
     * @param other the date to compare to this date.
     * @return true if the dates are equal, false otherwise.
     */

    public boolean equals(Date other) {
        return _day == other._day && _month == other._month && _year == other._year;
    }

    //before method

    /**
     * Check if this date is before the other date.
     *
     * @param other the date to compare to this date.
     * @return true if this date is before the other date, false otherwise.
     */
    public boolean before(Date other) {
        if (_year < other._year) {
            return true;
        }
        if (_year == other._year && _month < other._month) {
            return true;
        }
        if (_year == other._year && _month == other._month && _day < other._day) {
            return true;
        }
        return false;
    }

    //after method

    /**
     * Check if this date is after the other date.
     *
     * @param other the date to compare to this date.
     * @return true if this date is after the other date, false otherwise.
     */

    public boolean after(Date other) {
        return other.before(this);
    }

    //difference method

    /**
     * Calculates the difference in days between this date and other date.
     *
     * @param other the date to compare to this date.
     * @return the difference between the two dates in days.
     */
    public int difference(Date other) {
        return Math.abs(calculateDate(_day, _month, _year) - calculateDate(other._day, other._month, other._year));
    }

    //toString method

    /**
     * Returns a String that represents this date.
     *
     * @return a string representation of the date.
     */

    @Override
    public String toString() {
        String day = _day < 10 ? "0" + _day : "" + _day;
        String month = _month < 10 ? "0" + _month : "" + _month;
        return day + "/" + month + "/" + _year;
    }

    //tomorrow method

    /**
     * Calculate the date of tomorrow.
     *
     * @return a new Date object that represents the next day.
     */

    public Date tomorrow() {
        int day = _day;
        int month = _month;
        int year = _year;
        if (day == 31 && month == 12) {
            day = 1;
            month = 1;
            year++;
        } else if (day == 31 && (month == 4 || month == 6 || month == 9 || month == 11)) {
            day = 1;
            month++;
        } else if (day == 28 && month == 2) { //Ignoring leap years.
            day = 1;
            month++;
        } else if (day == 30 && month == 2) {
            day = 1;
            month++;
        } else {
            day++;
        }
        return new Date(day, month, year);
    }
    private boolean checkDateValidity(int day, int month, int year) {
        if (year < 1000 || year > 2023) { // Assuming that valid dates are between 1000 and 2023,
            // but we could change it to 9999.
            return false;
        }
        if (month < 0 || month > 12) {
            return false;
        }
        if (day < 0 || day > 31) {
            return false;
        }
        if (month == 2 && day > 28) { //Ignoring leap years(29 days in February in a leap year).
            return false;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return day <= 30; // We know that _day is not negative, so we don't need to check it
        }
        return true;
    }
    private int calculateDate(int day, int month, int year) {
        if (month < 3) {
            year--;
            month = month + 12;
        }
        return 365 * year + year / 4 - year / 100 + year / 400 + ((month + 1) * 306) / 10 + (day - 62);
    }
}
