package zork.models.entities.base;

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
    
    /**
     * 
     * @param value
     * @param minValue
     * @param maxValue 
     */
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
        
        // Check because armor could make damage negative (which would heal char)
        if (subtract > 0){
            this.value -= subtract;
        }
    }
    
}
