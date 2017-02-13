/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.models.items;

import zork.interfaces.IUseable;

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
    

}
