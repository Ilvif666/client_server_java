/**
 * Класс валидации вводимых данных и последующего создания элементов коллекции
 */

package commands;

import collection.*;
import io.TerminalRead;

import java.util.InputMismatchException;

public class ReadElement {

    public static String[] arguments = null;

    /**
     * @return worker - новый элемент коллекции
     * @throws InputMismatchException
     * @throws NumberFormatException
     */
    public Worker readElement() throws InputMismatchException, NumberFormatException {
        Worker worker;
        TerminalRead input = new TerminalRead();
        String[] arguments = new String[12];
        arguments[0] = InputValidation("Введите имя:", false, input);
        arguments[1] = InputValidation("Введите координату x(double):", -Double.MAX_VALUE, Double.MAX_VALUE, input);
        arguments[2] = InputValidation("Введите координату y(float):", -Float.MAX_VALUE, Float.MAX_VALUE, input);
        arguments[3] = InputValidation("Введите значение зарплаты(вещественное число больше нуля):", 0.0f, Float.MAX_VALUE, input);
        arguments[4] = "";
        while (!arguments[4].equals("DIRECTOR") && !arguments[4].equals("ENGINEER") && !arguments[4].equals("HEAD_OF_DEPARTMENT") && !arguments[4].equals("BAKER") && !arguments[4].equals("MANAGER_OF_CLEANING")) {
            arguments[4] = InputValidation("Выберите позицию {DIRECTOR, ENGINEER, HEAD_OF_DEPARTMENT, BAKER, MANAGER_OF_CLEANING}", false, input);
        }
        arguments[5] = "maybenull";
        while (!(arguments[5].equals("")) && !arguments[5].equals("HIRED") && !arguments[5].equals("RECOMMENDED_FOR_PROMOTION") && !arguments[5].equals("PROBATION")) {
            arguments[5] = InputValidation("Выберите состояние трудоустройства {HIRED, RECOMMENDED_FOR_PROMOTION, PROBATION}", true, input);
        }
        arguments[6] = InputValidation("Введите номер паспорта", true, input);
        arguments[7] = "maybenull";
        while (!(arguments[7].equals("")) && !arguments[7].equals("RED") && !arguments[7].equals("BLACK") && !arguments[7].equals("BLUE") && !arguments[7].equals("WHITE") && !arguments[7].equals("BROWN")) {
            arguments[7] = InputValidation("Выберите цвет {RED, BLACK, BLUE, WHITE, BROWN}", true, input);
        }
        arguments[8] = "maybenull";
        while (!(arguments[8].equals("")) && !arguments[8].equals("SPAIN") && !arguments[8].equals("ITALY") && !arguments[8].equals("NORTH_KOREA")) {
            arguments[8] = InputValidation("Выберите национальность {SPAIN, ITALY, NORTH_KOREA}", true, input);
        }
        arguments[9] = InputValidation("Введите Х локации", Integer.MIN_VALUE, Integer.MAX_VALUE, false, input);
        arguments[10] = InputValidation("Введите Y локации", Integer.MIN_VALUE, Integer.MAX_VALUE, true, input);
        arguments[11] = InputValidation("Введите Z локации", Integer.MIN_VALUE, Integer.MAX_VALUE, true, input);
        return TransformArguments(arguments);
    }


    /**
     * Валидация вводимых данных
     *
     * @param message   полученное сообщение
     * @param maybenull может ли поле быть null
     * @return Корректное значение поля
     */
    static String InputValidation(String message, Boolean maybenull, TerminalRead input) {
        String line = "";
        try {
            do {
                System.out.println(message);
                line = input.getNextInput().trim();
            } while (!maybenull && line.isEmpty());
        } catch (NullPointerException ignored) {
        } catch (Exception e) {
            System.out.print("Введены неверные данные. ");
        }
        if (line.equals("\n") || line.equals("")) line = "";
        return line;
    }

    /**
     * Валидация вводимых данных
     *
     * @param message полученное сообщение
     * @param min     левая граница диапазона
     * @param max     правая граница диапазона
     * @return Корректное значение поля
     */
    static String InputValidation(String message, double min, double max, TerminalRead input) {
        String line = "";
        try {
            do {
                System.out.println(message);
                line = input.getNextInput().trim();
                if ((Integer.parseInt(line) > max || Integer.parseInt(line) < min)) {
                    System.out.print("Значение вне диапазона. ");
                    line = InputValidation(message, min, max, input);
                }
                Integer.parseInt(line);
            } while (line.isEmpty());
            return line;
        } catch (Exception e) {
            System.out.print("Введены неверные данные.");
            return InputValidation(message, min, max, input);
        }
    }

    /**
     * Валидация вводимых данных
     *
     * @param message полученное сообщение
     * @param min     левая граница диапазона
     * @param max     правая граница диапазона
     * @return Корректное значение поля
     */
    static String InputValidation(String message, long min, long max, TerminalRead input) {
        String line = "";
        try {
            do {
                System.out.println(message);
                line = input.getNextInput().trim();
                if ((Long.parseLong(line) > max || Long.parseLong(line) < min)) {
                    System.out.print("Значение вне диапазона.");
                    line = InputValidation(message, min, max, input);
                }
                Long.parseLong(line);
            } while (line.isEmpty());
            return line;
        } catch (Exception e) {
            System.out.print("Введены неверные данные.");
            return InputValidation(message, min, max, input);
        }
    }

    /**
     * Валидация вводимых данных
     *
     * @param message   полученное сообщение
     * @param min       левая граница диапазона
     * @param max       правая граница диапазона
     * @param maybenull может ли поле быть null
     * @return Корректное значение поля
     */
    static String InputValidation(String message, int min, int max, Boolean maybenull, TerminalRead input) {
        String line = "";
        try {
            do {
                System.out.println(message);
                line = input.getNextInput().trim();
                if ((Long.parseLong(line) > max || Long.parseLong(line) < min)) {
                    System.out.print("Значение вне диапазона.");
                    line = InputValidation(message, min, max, input);
                }
                Long.parseLong(line);
            } while (!maybenull && line.isEmpty());
            return line;
        } catch (Exception e) {
            System.out.print("Введены неверные данные.");
            return InputValidation(message, min, max, input);
        }
    }

    /**
     * Валидация вводимых данных
     *
     * @param message полученное сообщение
     * @param min     левая граница диапазона
     * @param max     правая граница диапазона
     * @param input   объект класса TerminalRead
     * @return Корректное значение поля
     */
    static String InputValidation(String message, float min, float max, TerminalRead input) {
        String line = "";
        try {
            do {
                System.out.println(message);
                line = input.getNextInput().trim();
                if ((Float.parseFloat(line) > max || Float.parseFloat(line) <= min)) {
                    System.out.print("Значение вне диапазона. ");
                    line = InputValidation(message, (float) min, (float) max, input);
                }
                Float.parseFloat(line);
            } while (line.isEmpty());
            return line;
        } catch (Exception e) {
            System.out.print("Введены неверные данные.");
            return InputValidation(message, (float) min, (float) max, input);
        }
    }

    /**
     * Создаёт элемент коллекции с указанными полями
     * @param arguments поля элемента коллекции
     * @return сформированный элемент коллекции
     */
    static Worker TransformArguments(String[] arguments) {
        try {
            String name = arguments[0];
            Coordinates coordinates = new Coordinates(Double.parseDouble(arguments[1]), Float.parseFloat(arguments[2]));
            Float salary = Float.parseFloat(arguments[3]);
            Position position = Position.valueOf(arguments[4]);
            Status status = arguments[5].isEmpty() ? null : Status.valueOf(arguments[5]);
            String passportID = arguments[6];
            Color color = arguments[7].isEmpty() ? null : Color.valueOf(arguments[7]);
            Country nationality = arguments[8].isEmpty() ? null : Country.valueOf(arguments[8]);
            Location location = new Location(Integer.parseInt(arguments[9]), Double.parseDouble(arguments[10]), Double.parseDouble(arguments[11]));
            Person person = new Person(passportID, color, nationality, location);
            return new Worker(name, coordinates, salary, position, status, person);
        } catch (Exception e) {
            System.out.println("Не удалось добавить объект, некоторые данные введены неверно!");
            e.printStackTrace();
            return null;
        }

    }
}
