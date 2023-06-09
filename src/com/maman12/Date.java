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

    //Static variables

    private static final int DEFAULT_YEAR = 2000; //The default year for the date.
    private static final int DEFAULT_MONTH = 1; //The default month for the date.
    private static final int DEFAULT_DAY = 1; //The default day for the date.

    private static final int MIN_YEAR = 1000; //The minimum year for the date.
    private static final int MAX_YEAR = 9999; //The maximum year for the date.

    private static final int MIN_DAY = 1; //The minimum day for the date.
    private static final int DAY_28 = 28; //The number of days in February in a non-leap year.
    private static final int DAY_30 = 30; //The number of days in April, June, September and November.
    private static final int DAY_31 = 31; //The number of days in January, March, May, July, August, October and December.

    private static final int MONTH_1 = 1; //The number of the first month.
    private static final int MONTH_2 = 2; //The number of the second month.
    private static final int MONTH_3 = 3; //The number of the third month.
    private static final int MONTH_4 = 4; //The number of the fourth month.
    private static final int MONTH_5 = 5; //The number of the fifth month.
    private static final int MONTH_6 = 6; //The number of the sixth month.
    private static final int MONTH_7 = 7; //The number of the seventh month.
    private static final int MONTH_8 = 8; //The number of the eighth month.
    private static final int MONTH_9 = 9; //The number of the ninth month.
    private static final int MONTH_10 = 10; //The number of the tenth month.
    private static final int MONTH_11 = 11; //The number of the eleventh month.
    private static final int MONTH_12 = 12; //The number of the twelfth month.

    private static final int TEN = 10; //The number 10 to check if the day is a double-digit.
    //Constructors

    /**
     * If the given date is valid - creates a new Date object, otherwise creates the date 1/1/2000
     *
     * @param day   the day of the month.
     * @param month the month of the year.
     * @param year  the year.
     */
    public Date(int day, int month, int year) {
        if (checkDateValidity(day, month, year)) { //Calling the checkDateValidity method to check if the date is valid.
            _day = day;
            _month = month;
            _year = year;
        } else { //If the date is not valid, the date will be set to 1/1/2000.
            _day = DEFAULT_DAY;
            _month = DEFAULT_MONTH;
            _year = DEFAULT_YEAR;
        }
    }

    /**
     * Copy constructor for Dates.
     *
     * @param other The date from which to construct the new object.
     */
    public Date(Date other) {
        this._day = other._day;//Copy the day.
        this._month = other._month;//Copy the month.
        this._year = other._year;//Copy the year.
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
        if (checkDateValidity(dayToSet, _month, _year)) { //Calling the checkDateValidity method to check
            // if the date is valid with the new day. If not, the day will not be changed.
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
        if (checkDateValidity(_day, monthToSet, _year)) { //Calling the checkDateValidity method to check
            // if the date is valid with the new month. If not, the month will not be changed.
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
        if (checkDateValidity(_day, _month, yearToSet)) { //Calling the checkDateValidity method to check
            // if the date is valid with the new year. If not, the year will not be changed.
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
        //Check if the day, month and year are the same. And return true if they are.
    }

    //before method

    /**
     * Check if this date is before the other date.
     *
     * @param other the date to compare to this date.
     * @return true if this date is before the other date, false otherwise.
     */
    public boolean before(Date other) {
        if (_year < other._year) { //Check if the year is smaller than the other year. return true if it is.
            return true;
        }
        if (_year == other._year && _month < other._month) { //Check if the year is the same,
            // and the month is smaller than the other month. return true if it is.
            return true;
        }
        if (_year == other._year && _month == other._month && _day < other._day) { //Check if the year and month are the same,
            // and the day is smaller than the other day. return true if it is.
            return true;
        }
        return false;// If all the conditions are not met, return false.
    }

    //after method

    /**
     * Check if this date is after the other date.
     *
     * @param other the date to compare to this date.
     * @return true if this date is after the other date, false otherwise.
     */

    public boolean after(Date other) {
        return other.before(this); //Check if the other date is before this date. return true if it is.
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
        //Calculate the difference between the two dates and return the absolute value of the result.
    }

    //toString method

    /**
     * Returns a String that represents this date.
     *
     * @return a string representation of the date.
     */

    @Override
    public String toString() {
        String day = _day < TEN ? "0" + _day : "" + _day;
        String month = _month < TEN ? "0" + _month : "" + _month;
        return day + "/" + month + "/" + _year;
    }

    //tomorrow method

    /**
     * Calculate the date of tomorrow.
     *
     * @return a new Date object that represents the next day.
     */

    public Date tomorrow() {
        int day = _day; //Creating a temporary variables for the day.
        int month = _month;//Creating a temporary variables for the month.
        int year = _year;//Creating a temporary variables for the year.
        if (day == DAY_31 && month == MONTH_12) { //Check if the day is the last day of the year.
            day = MIN_DAY; //If it is, set the day to 1.
            month = MONTH_1; //Set the month to 1.
            year++;//Increase the year by 1.
        } else if (day == DAY_31 && (month ==  MONTH_1 || month == MONTH_3 || month == MONTH_5 || month == MONTH_7 || month == MONTH_8 || month == MONTH_10)) {
            day = MIN_DAY;//If the day is the last day of a month with 31 days, set the day to 1.
            month++;//Increase the month by 1.
        } else if (day == DAY_28 && month == MONTH_2) { //Ignoring leap years.
            day = MIN_DAY;//If the day is the last day of February, set the day to 1.
            month++; //Increase the month by 1.
        } else if (day == DAY_30 && (month == MONTH_4 || month == MONTH_6 || month == MONTH_9 || month == MONTH_11)) {
            day = MIN_DAY;//If the day is the last day of a month with 30 days, set the day to 1.
            month++;//Increase the month by 1.
        } else {
            day++;//If the day is not the last day of the month, increase the day by 1.
        }
        return new Date(day, month, year);
    }
    private boolean checkDateValidity(int day, int month, int year) { //Method to check if the date is valid.
        if (year < MIN_YEAR || year > MAX_YEAR) { // Assuming that valid dates are between 1000 and 9999,
            return false;
        }
        if (month < MONTH_1 || month > MONTH_12) { // Assuming that valid months are between 1 and 12,
            return false;
        }
        if (day < MIN_DAY || day > DAY_31) { // Assuming that valid days are between 1 and 31,
            return false;
        }
        if (month == MONTH_2 && day > DAY_28) { //Ignoring leap years(29 days in February in a leap year).
            return false;
        }
        if (month == MONTH_4 || month == MONTH_6 || month == MONTH_9 || month == MONTH_11) { //Months with 30 days.
            return day <= DAY_30; // We know that _day is not negative, so we don't need to check it
        }
        return true;
    }
    private int calculateDate(int day, int month, int year) { //Included method to calculate days value of a given date.
        //Kept the original numbers and did not create constants for them.
        if (month < 3) {
            year--;
            month = month + 12;
        }
        return 365 * year + year / 4 - year / 100 + year / 400 + ((month + 1) * 306) / 10 + (day - 62);
    }
}
