/*
 * Copyright (C) 2017 Daniel
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package zork.models.entities.base;

/**
 *
 * Container object for player stat
 *
 * @author d.peters
 */
public class Stat {

    /**
     * Current value of the object
     */
    private double value;

    /**
     * Current minimum value of the object
     */
    private double minValue;

    /**
     * Current maximum value of the object
     */
    private double maxValue;

    /**
     *
     * @param value
     * @param minValue
     * @param maxValue
     */
    public Stat(double value, double minValue, double maxValue) {
        this.value = value;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    /**
     * Get the current value of this object
     *
     * @return the current value
     */
    public double getValue() {
        return value;
    }

    /**
     * Increase the current value of this object
     *
     * @param add
     */
    public void increase(double add) {
        if (this.value + add > this.maxValue) {
            this.value += add;
        }
    }

    /**
     * Decrease the current value of this object
     *
     * @param subtract
     */
    public void decrease(double subtract) {

        // Check because armor could make damage negative (which would heal char)
        if (subtract > 0) {
            this.value -= subtract;
        }
    }

}
