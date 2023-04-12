package com.maman12;

/**
 * Represents a city. City is represented by its name, the date it was established, center, central station, number of residents(non negative) and number of neighborhoods(positive).
 */

public class City {
    private String _cityName;
    private Date _dateEstablished;
    private Point _cityCenter;
    private Point _centralStation;
    private long _numOfResidents;
    private int _numOfNeighborhoods;

    //Constructors

    public City(String cityName, int dayEstablished, int monthEstablished, int yearEstablished, int centerX, int centerY, int stationX, int stationY, long numOfResidents, int numOfNeighborhoods) {
        _cityName = cityName;
        _dateEstablished = new Date(dayEstablished, monthEstablished, yearEstablished);
        _cityCenter = new Point(centerX, centerY);
        _centralStation = new Point(stationX, stationY);
        _numOfResidents = numOfResidents < 0 ? 0 : numOfResidents;
        _numOfNeighborhoods = numOfNeighborhoods <= 0 ? 1 : numOfNeighborhoods;
    }

    public City(City other) {
        _cityName = other._cityName;
        _dateEstablished = new Date(other._dateEstablished);
        _cityCenter = new Point(other._cityCenter);
        _centralStation = new Point(other._centralStation);
        _numOfResidents = other._numOfResidents;
        _numOfNeighborhoods = other._numOfNeighborhoods;
    }

    //get methods

    /**
     * Returns the city's name.
     *
     * @return the city name.
     */
    public String getCityName() {
        return _cityName;
    }

    /**
     * Returns a Date object that represents the city's established Date.
     *
     * @return the date established.
     */

    public Date getDateEstablished() {
        return _dateEstablished;
    }

    /**
     * Returns a Point object representing the city's center.
     *
     * @return the city center.
     */

    public Point getCityCenter() {
        return _cityCenter;
    }

    /**
     * Returns a Point object representing the city's central station.
     *
     * @return the central station.
     */

    public Point getCentralStation() {
        return _centralStation;
    }

    /**
     * Returns the number of residents in this city.
     *
     * @return the number of residents.
     */

    public long getNumOfResidents() {
        return _numOfResidents;
    }

    /**
     * Returns the number of neighborhoods in this city.
     *
     * @return the number of neighborhoods.
     */

    public int getNumOfNeighborhoods() {
        return _numOfNeighborhoods;
    }

    //set methods

    /**
     * Changes the city's name.
     *
     * @param cityName the new city name.
     */

    public void setCityName(String cityName) {
        _cityName = cityName;
    }


    /**
     * Changes the city's center.
     *
     * @param dateEst the new city established date.
     */
    public void setDateEstablished(Date dateEst) {
        _dateEstablished = new Date(dateEst);
    }

    /**
     * Changes the city's center location.
     *
     * @param cityCenter the new city center.
     */

    public void setCityCenter(Point cityCenter) {
        _cityCenter = new Point(cityCenter);
    }

    /**
     * Changes the city's central station location.
     *
     * @param centralStation the new central station.
     */

    public void setCentralStation(Point centralStation) {
        _centralStation = new Point(centralStation);
    }

    /**
     * Changes the city's number of residents.
     *
     * @param numOfResidents the new number of residents.
     */

    public void setNumOfResidents(long numOfResidents) {
        _numOfResidents = numOfResidents < 0 ? 0 : numOfResidents;
    }

    /**
     * Changes the city's number of neighborhoods.
     *
     * @param numOfNeighborhoods the new number of neighborhoods.
     */

    public void setNumOfNeighborhoods(int numOfNeighborhoods) {
        _numOfNeighborhoods = numOfNeighborhoods <= 0 ? 1 : numOfNeighborhoods;
    }

    //toString method

    /**
     * Returns a string representation of this city.
     *
     * @return a string representation of this city.
     */

    @Override
    public String toString() {
        return "City name: " + _cityName + "\n"
                + "Date established: " + _dateEstablished.toString()
                + "\n" + "City center: " + _cityCenter.toString()
                + "\n" + "Central station: " + _centralStation.toString()
                + "\n" + "Number of residents: " + _numOfResidents
                + "\n" + "Number of neighborhoods: " + _numOfNeighborhoods;
    }

    //equals method

    /**
     * Check if two cities are the same (checking all six instance variables)
     *
     * @param other the other city.
     * @return true if this city is equal to the other city, false otherwise.
     */

    public boolean equals(City other) {
        return _cityName.equals(other._cityName)
                && _dateEstablished.equals(other._dateEstablished)
                && _cityCenter.equals(other._cityCenter)
                && _centralStation.equals(other._centralStation)
                && _numOfResidents == other._numOfResidents
                && _numOfNeighborhoods == other._numOfNeighborhoods;
    }

    //addResidents method

    /**
     * Add or subtract residents to this city.
     *
     * @param residentsUpdate the number of residents to add.
     */

    public boolean addResidents(long residentsUpdate) {
        long newNumOfResidents = _numOfResidents + residentsUpdate;
        if (newNumOfResidents < 0) {
            _numOfResidents = 0;
            return false;
        } else {
            _numOfResidents = newNumOfResidents;
            return true;
        }

    }

    //moveCentralStation method

    /**
     * Move the central station location.
     *
     * @param deltaX the new central station location's x value.
     * @param deltaY the new central station location's y value.
     */

    public void moveCentralStation(int deltaX, int deltaY) {
        _centralStation.move(deltaX, deltaY);
    }

    //distanceBetweenCenterAndStation method

    /**
     * Returns the distance between the city's center and the central station.
     *
     * @return the distance between the city's center and the central station.
     */

    public double distanceBetweenCenterAndStation() {
        return _cityCenter.distance(_centralStation);
    }

    //newCity method

    /**
     * Returns a new city with a new name,
     * established date which is a day after this city and a City center location dX and dY away from this city,
     * with 0 residents and 1 neighborhood.
     *
     * @param newCityName the new city's name.
     * @param dX          delta x.
     * @param dY          delta y.
     * @return aa new city with a new name,
     * * established date which is a day after this city and a City center location dX and dY away from this city,
     * * with 0 residents and 1 neighborhood.
     */

    public City newCity(String newCityName, int dX, int dY) {
        Point newCityCenter = new Point(_cityCenter);
        Point newCityStation = new Point(_centralStation);
        newCityCenter.move(dX, dY);
        newCityStation.move(dX, dY);
        Date newCityDate = new Date(_dateEstablished).tomorrow();
        long newCityResidents = 0;
        int newCityNeighborhoods = 1;
        return new City(newCityName, newCityDate.getDay(), newCityDate.getMonth(),
                newCityDate.getYear(), newCityCenter.getX(), newCityCenter.getY(),
                newCityStation.getX(), newCityStation.getY(), newCityResidents,
                newCityNeighborhoods);
    }

    // cityEstablishedBetweenDates method

    /**
     * Check if the city establish date is between two given dates (including these dates).
     *
     * @param date1 the first date.
     * @param date2 the second date.
     * @return true if this city was established between the two given dates.
     */

    public boolean cityEstablishedBetweenDates(Date date1, Date date2) {
        int date1DaysValue = calculateDate(date1.getDay(), date1.getMonth(), date1.getYear());
        int date2DaysValue = calculateDate(date2.getDay(), date2.getMonth(), date2.getYear());
        int BiggestDate = Math.max(date1DaysValue, date2DaysValue);
        int SmallestDate = Math.min(date1DaysValue, date2DaysValue);
        int cityEstablishedDaysValue = calculateDate(_dateEstablished.getDay(), _dateEstablished.getMonth(), _dateEstablished.getYear());
        return cityEstablishedDaysValue >= SmallestDate && cityEstablishedDaysValue <= BiggestDate;
    }


    //establishedDateDiff method

    /**
     * This method calculates the difference in days between the establishment date of this city and the city given as a parameter.
     *
     * @param other the given city.
     * @return the difference between the city's established date and a given date.
     */

    public int establishmentDateDiff(City other) {
        return _dateEstablished.difference(other._dateEstablished);
    }

    private int calculateDate(int day, int month, int year) {
        if (month < 3) {
            year--;
            month = month + 12;
        }
        return 365 * year + year / 4 - year / 100 + year / 400 + ((month + 1) * 306) / 10 + (day - 62);
    }

}

