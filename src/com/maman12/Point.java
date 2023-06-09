package com.maman12;

/**
 * Point - This class represents 2 dimensional point. Coordinates cannot be negative.
 *  @author Michael Brover
 */
public class Point {
    private int _x;
    private int _y;

    //Static variables
    private static final int DEFAULT_VALUE = 0; //The default value for the coordinates.
    private static final int DIVIDER = 2; //The divider for the distance between two points.

    //Constructors

    /**
     * Constructs a point.
     *
     * @param x the x coordinate.
     * @param y the y coordinate.
     */
    public Point(int x, int y) {

        _x = x < DEFAULT_VALUE ? DEFAULT_VALUE : x; //Since x and y cannot be negative, if they are, they will be set to 0.
        _y = y < DEFAULT_VALUE ? DEFAULT_VALUE : y; //Since x and y cannot be negative, if they are, they will be set to 0.
    }

    /**
     * Copy constructor for Points.
     *
     * @param other The point from which to construct the new object.
     */
    public Point(Point other) {
        this._x = other._x; //Copy the x coordinate.
        this._y = other._y; //Copy the y coordinate.
    }

    //Get methods

    /**
     * Returns the x coordinate of the point.
     *
     * @return the x coordinate of the point.
     */
    public int getX() {
        return _x;
    }


    /**
     * Returns the y coordinate of the point.
     *
     * @return the y coordinate of the point.
     */
    public int getY() {
        return _y;
    }

    //Set methods

    /**
     * Changes the y coordinate of the point, if the value is below zero,
     * the x coordinate will not be changed.
     *
     * @param num the new x coordinate of the point.
     */
    public void setX(int num) {
        if (num > DEFAULT_VALUE) {  //If the value is below zero, the x coordinate will not be changed.
            this._x = num;
        }

    }


    /**
     * Changes the y coordinate of the point, if the value is below zero,
     * the y coordinate will not be changed.
     *
     * @param num the new y coordinate of the point.
     */

    public void setY(int num) {
        if (num > DEFAULT_VALUE) { //If the value is below zero, the y coordinate will not be changed.
            this._y = num;
        }
    }

    //toString method

    /**
     * Returns a string representation of the point.
     *
     * @return a string representation of the point.
     */

    @Override
    public String toString() {
        return "(" + _x + "," + _y + ")";
    }

    //equals method

    /**
     * Check if the received point is equal to this point.
     *
     * @param other the point to check.
     * @return true if the points are equal, false otherwise.
     */
    public boolean equals(Point other) {
        return this._x == other._x && this._y == other._y;
    }

    //isAbove method

    /**
     * Check if this point is above a received point.
     *
     * @param other the point to check.
     * @return true if this point is above the received point, false otherwise.
     */

    public boolean isAbove(Point other) {
        return this._y > other._y; //For a point to be above another point, its y coordinate must be bigger.
    }

    //isUnder method

    /**
     * Check if this point is under a received point.
     *
     * @param other the point to check.
     * @return true if this point is under the received point, false otherwise.
     */

    public boolean isUnder(Point other) {
        return other.isAbove(this); //If this point is under the received point, the received point is above this point.
    }

    //isLeft method

    /**
     * Check if this point is left of a received point.
     *
     * @param other the point to check.
     * @return true if this point is left of the received point, false otherwise.
     */

    public boolean isLeft(Point other) {
        return this._x < other._x; //For a point to be left of another point, its x coordinate must be smaller.
    }

    //isRight method

    /**
     * Check if this point is right of a received point.
     *
     * @param other the point to check.
     * @return true if this point is right of the received point, false otherwise.
     */

    public boolean isRight(Point other) {
        return other.isLeft(this); //If this point is right of the received point, the received point is left of this point.
    }

    //move method

    /**
     * Move the x coordinate deltaX and the y coordinate deltaY.
     * If the new coordinates are not in the first quadrant the point should not be moved.
     *
     * @param deltaX the change in x.
     * @param deltaY the change in y.
     */

    public void move(int deltaX, int deltaY) {
        int newX = this._x + deltaX; //Creating a temporary variable for the new x coordinate.
        int newY = this._y + deltaY; //Creating a temporary variable for the new y coordinate.
        if (newX >= DEFAULT_VALUE && newY >= DEFAULT_VALUE) { //Checking if the new coordinates are in the first quadrant. if not, the point will not be moved.
            this._x = newX;
            this._y = newY;
        }
    }

    //middle method

    /**
     * Return a new point in between this point and the received point.
     *
     * @param other the point to check.
     * @return the middle point between this point and the received point.
     */
    public Point middle(Point other) {
        int x = (this._x + other._x) / DIVIDER; //Calculating the middle x coordinate(DIVIDER = 2).
        int y = (this._y + other._y) / DIVIDER; //Calculating the middle y coordinate(DIVIDER = 2).
        return new Point(x, y);
    }

    //distance method

    /**
     * Returns the distance between this point and the received point.
     *
     * @param other the point to check.
     * @return the distance between this point and the received point.
     */
    public double distance(Point other) {
        int xGap = this._x - other._x; //Calculating the gap between the x coordinates.
        int yGap = this._y - other._y; //Calculating the gap between the y coordinates.
        return Math.sqrt((xGap * xGap) + (yGap * yGap)); //Calculating the distance between the points.
    }

}
