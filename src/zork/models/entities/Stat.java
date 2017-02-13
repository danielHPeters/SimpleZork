/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zork.models.entities;

/**
 *
 * @author d.peters
 */
public class Stat {
    
    /**
     * 
     */
    private double value;
    
    /**
     * 
     */
    private double minValue;
    
    /**
     * 
     */
    private double maxValue;
    
    public Stat(double value, double minValue, double maxValue){
        this.value = value;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    /**
     * 
     * @return 
     */
    public double getValue() {
        return value;
    }
    
    /**
     * 
     * @param add 
     */
    public void increase(double add){
        if (this.value + add > this.maxValue){
            this.value += add;
        }
    }
    
    /**
     * 
     * @param subtract 
     */
    public void decrease(double subtract){
        this.value -= subtract;
    }
    
}
