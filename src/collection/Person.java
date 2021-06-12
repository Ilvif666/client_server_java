package collection;

import java.io.Serializable;

/**
 * Класс Person
 */
public class Person implements Serializable {
    private String passportID; //Длина строки не должна быть больше 42, Поле может быть null
    private Color eyeColor; //Поле может быть null
    private Country nationality; //Поле может быть null
    private Location location; //Поле может быть null

    /**
     * @param passportID  номер паспорта
     * @param eyeColor    цвет глаз
     * @param nationality национальность
     * @param location    локация
     * @throws Exception при передаче null
     */
    public Person(String passportID, Color eyeColor, Country nationality, Location location) throws Exception {
        setPassportID(passportID);
        setEyeColor(eyeColor);
        setNationality(nationality);
        setLocation(location);
    }

    /**
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        return "{" +
                "\nномер паспорта=: '" + passportID + '\'' +
                "\nцвет глаз: '" + eyeColor + '\'' +
                "\nнациональность: '" + nationality + '\'' +
                "\nлокация: '" + location + '\'' +
                '}';
    }

    /**
     * @param passportID параметр сеттера номера паспорта
     */

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    /**
     * @return номер паспорта
     */
    public String getPassportID() {
        return passportID;
    }

    /**
     * @param eyeColor параметр сеттера цвета глаз
     */
    public void setEyeColor(Color eyeColor) {
        this.eyeColor = eyeColor;
    }

    /**
     * @return цвет глаз
     */
    public Color getEyeColor() {
        return eyeColor;
    }

    /**
     * @param nationality параметр сеттера национальности
     */
    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    /**
     * @return национальность
     */
    public Country getNationality() {
        return nationality;
    }

    /**
     * @param location параметр сеттера локации
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * @return цвет глаз
     */
    public Location getLocation() {
        return location;
    }
}