package io;
/**
 * Класс обработки и вызова  команд
 */

import commands.*;
import exceptions.NoArgumentException;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CreateObject {

    /**
     * @param inputCommand ввод клиента
     * @return команда для выполнение
     * @throws IOException
     * @throws NullPointerException
     */
    public AbstractCommand commandChoice(String inputCommand) throws IOException, NullPointerException {
        String[] line = inputCommand.trim().toLowerCase().split(" ", 2);
        ReadElement newWorker = new ReadElement();

        switch (line[0]) {
            case "help":
                return new Help();

            case "info":
                return new Info();

            case "show":
                return new Show();

            case "add":
                return new Add(newWorker.readElement());

            case "update":
                try {
                    if (line.length < 2) throw new NoArgumentException();
                    int id = Integer.parseInt(line[1]);
                    return new Update(newWorker.readElement(), id);
                } catch (NoArgumentException | NumberFormatException e) {
                    return new MessageCommand("Введи значение id");
                }

            case "remove_by_id":
                try {
                    if (line.length < 2) throw new NoArgumentException();
                    int id = Integer.parseInt(line[1]);
                    return new RemoveById(id);
                } catch (NoArgumentException | NumberFormatException e) {
                    return new MessageCommand("Введи значение id");
                }

            case "head":
                return new Head();


            case "clear":
                return new Clear();

            case "execute_script":
                try {
                    if (line.length < 2) throw new NoArgumentException();

                    FileRead fileRead = new FileRead();
                    fileRead.FileInput(line[1]);
                    String[] file = fileRead.getFile(line[1]).split("\n");
                    AbstractCommand[] commands = new AbstractCommand[file.length];
                    for (int i = 0; i < file.length; i++) {
                        commands[i] = commandChoice(file[i]);
                    }
                    return new ExecuteScript(commands);

                } catch (NoArgumentException e) {
                    return new MessageCommand("Файл не указан");
                } catch (FileNotFoundException e) {
                    return new MessageCommand("Файл не найден");
                }

            case "add_if_max":
                return new AddIfMax(newWorker.readElement());


            case "remove_greater":
                try {
                    if (line.length < 2) throw new NoArgumentException();
                    float salary = Float.parseFloat(line[1]);
                    return new RemoveGreater(salary);
                } catch (NumberFormatException | NoArgumentException e) {
                    return new MessageCommand("Введи значение salary");
                }

            case "print_unique_salary":
                return new PrintUniqueSalary();

            case "print_descending":
                return new PrintDescending();

            case "print_field_ascending_salary":
                return new PrintFieldAscendingSalary();

            case "exit":
                return new Exit();

            default:
                return new UnknownCommand();
        }
    }
}




