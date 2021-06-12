package collection;

import java.io.Serializable;

/**
 * Класс Coordinates
 */
public class Coordinates implements Serializable {
    private double x;
    private float y;

    /**
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        return "(x,y)=(" + x + "," + y + ")";
    }

    /**
     * Конструктор
     *
     * @param x координата x
     * @param y координата y
     */
    public Coordinates(double x, float y) {
        setX(x);
        setY(y);
    }

    /**
     * @param x параметр сеттера координаты x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return координату x
     */
    public double getX() {
        return x;
    }

    /**
     * @param y параметр сеттера координаты y
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * @return координату y
     */
    public float getY() {
        return y;
    }
}