package collection;

import java.io.Serializable;

/**
 * Класс Location
 */
public class Location implements Serializable {
    private Integer x; //Поле не может быть null
    private double y;
    private double z;

    /**
     * @param x x
     * @param y y
     * @param z z
     */
    public Location(Integer x, double y, double z) {
        setX(x);
        setY(y);
        setZ(z);
    }

    /**
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        return "(x,y,z)=(" + x + "," + y + "," + z + ")";
    }

    /**
     * @param x параметр сеттера координаты x
     */
    public void setX(Integer x) {
        this.x = x;
    }

    /**
     * @return координату x
     */
    public Integer getX() {
        return x;
    }

    /**
     * @param y параметр сеттера координаты y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return координату y
     */
    public double getY() {
        return y;
    }

    /**
     * @param z параметр сеттера координаты z
     */
    public void setZ(double z) {
        this.z = z;
    }

    /**
     * @return координату y
     */
    public double getZ() {
        return z;
    }
}