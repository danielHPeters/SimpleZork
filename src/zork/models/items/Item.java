/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.models.items;

/**
 *
 * @author d.peters
 */
public class Item {

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

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    

}
