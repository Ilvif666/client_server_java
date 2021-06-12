package collection;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Класс Worker, объектами которого заполняется коллекция
 */

public class Worker implements Serializable {

    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDateTime creationDateTime; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float salary; //Значение поля должно быть больше 0
    private Position position; // Поле не может быть null
    private Status status; // Поле может быть null
    private Person person; // Поле может быть null

    /**
     * Конструктор класса
     *
     * @param name        имя
     * @param coordinates координаты
     * @param salary      зарплата
     * @param position    позиция
     * @param status      статус
     * @param person      личность
     */
    public Worker(String name, Coordinates coordinates, Float salary, Position position, Status status, Person person) {
        this.creationDateTime = LocalDateTime.now();
        setId();
        setName(name);
        setCoordinates(coordinates);
        setSalary(salary);
        setPosition(position);
        setStatus(status);
        setPerson(person);
    }

    public Worker() {

    }

    /**
     * @return id Worker
     */
    public long getId() {
        return id;
    }

    /**
     * устанавливает случайный Id
     */
    public void setId() {

        this.id = (long) (Math.random() * 10000);
    }

    /**
     * @param name имя Worker
     * @throws NullPointerException если имя не указано при вводе
     */
    public void setName(String name) throws NullPointerException {
        if (name != null && !name.isEmpty())
            this.name = name;
        else throw new NullPointerException();
    }

    /**
     * @param position должность Worker
     * @throws NullPointerException если должность не указана при вводе
     */
    public void setPosition(Position position) throws NullPointerException {
        if (position != null)
            this.position = position;
        else throw new NullPointerException();
    }

    /**
     * @param coordinates координаты Worker
     * @throws NullPointerException если координаты не указаны при вводе
     */
    public void setCoordinates(Coordinates coordinates) throws NullPointerException {
        if (coordinates != null)
            this.coordinates = coordinates;
        else throw new NullPointerException();
    }

    /**
     * @return зарплата Worker
     */
    public Float getSalary() {
        return salary;
    }

    /**
     * @param salary зарплата Worker
     */
    public void setSalary(Float salary) throws NullPointerException {
        if (salary != null && salary > 0)
            this.salary = salary;
        else throw new NullPointerException();
    }

    /**
     * @param status статус занятости Worker
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @param person личность worker
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * @return имя
     */
    public String getName() {
        return name;
    }

    /**
     * @return координаты
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * @return должность
     */
    public Position getPosition() {
        return position;
    }

    /**
     * @return статус трудоустройства
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @return главу
     */
    public Person getPerson() {
        return person;
    }

    /**
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        return "Рабочий\n{id = " + id +
                "\nимя: '" + name + '\'' +
                "\nкоординаты " + coordinates +
                "\nдата и время создания: " + creationDateTime +
                "\nзарплата: " + salary +
                "\nдолжность: " + position +
                "\nсостояние трудоустройства: " + status +
                "\nличность: " + person +
                "}\n";
    }

}