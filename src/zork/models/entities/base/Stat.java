package zork.models.entities.base;

/**
 * Container object for player stat.
 *
 * @author d.peters
 */
public class Stat {
  /**
   * Current value of the object.
   */
  private double value;

  /**
   * Current minimum value of the object.
   */
  private double minValue;

  /**
   * Current maximum value of the object.
   */
  private double maxValue;

  /**
   * Default constructor.
   *
   * @param value    initial value
   * @param minValue minimum value
   * @param maxValue maximum value
   */
  public Stat(double value, double minValue, double maxValue) {
    this.value = value;
    this.minValue = minValue;
    this.maxValue = maxValue;
  }

  /**
   * Get the current value of this object.
   *
   * @return the current value
   */
  public double getValue() {
    return value;
  }

  /**
   * Increase the current value of this object.
   *
   * @param add added amount
   */
  public void increase(double add) {
    if (this.value + add > this.maxValue) {
      this.value += add;
    }
  }

  /**
   * Decrease the current value of this object.
   *
   * @param subtract reduced amount
   */
  public void decrease(double subtract) {
    // Check because armor could make damage negative (which would heal char)
    if (subtract > 0) {
      value -= subtract;
    }
  }
}
