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
package zork.models.items;

import zork.interfaces.IUseable;
import zork.models.entities.Player;

/**
 *
 * @author d.peters
 */
public class Item {

    private final IUseable action;
    
    /**
     *
     */
    private String name;

    /**
     *
     */
    private String description;

    /**
     *
     */
    private double price;

    /**
     *
     * @param name
     * @param description
     * @param price
     */
    public Item(String name, String description, double price) {

        this.name = name;
        this.description = description;
        this.price = price;
        this.action = null;

    }
    
    public Item(String name, String description, double price, IUseable action) {
        
        this.name = name;
        this.description = description;
        this.price = price;
        this.action = action;
    }

    /**
     * 
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return 
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return 
     */
    public double getPrice() {
        return price;
    }

    /**
     * 
     * @param price 
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
    /**
     * 
     */
    public void use() {
        
        if (this.action == null){
            System.out.println("You cannot use the " + this.name + ".");
        } else {
            this.action.use();
        }
        
    }
    
    public void use(Player player){
        if (this.action == null){
            System.out.println("You cannot use the " + this.name + ".");
        } else {
            this.action.use(player);
        }
    }
    

}
