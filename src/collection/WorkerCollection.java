/**
 * Коллекция типа LinkedList класса Worker
 */
package collection;

import com.thoughtworks.xstream.XStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class WorkerCollection {

    /** Коллекция с работниками */
    private LinkedList<Worker> workers = new LinkedList<Worker>();

    /** Дата создания коллекции */
    private Date date;

    public WorkerCollection() {
    }

    /**
     * Чтение коллекции из файла
     * @param fileName - файл, в котором хранится коллекция
     * @throws IOException
     */
    public void createCollection(String fileName) throws IOException {
        this.date = new Date();
        try (Scanner scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name())) {
            XStream xs = new XStream();
            String content = scanner.useDelimiter("\\A").next();
            scanner.close();
            this.workers = new LinkedList<Worker>();
            LinkedList<Worker> temp = (LinkedList<Worker>) xs.fromXML(content);
            if (!temp.isEmpty()) for (Worker each : temp) this.workers.addLast(each);

            else System.out.println("Не удалось загрузить коллекцию. В файле отсутствует необходимая структура");
        } catch (FileNotFoundException e) {
            System.out.println("Неверное имя файла. Попробуйте ввести ещё раз.");
            System.exit(-1);
        } catch (Exception e) {
            System.out.println("Произошла ошибка");
        }
    }

    /**
     *
     * @return коллекция LinkedList класса Worker
     */
    public LinkedList<Worker> getCollection() {
        return this.workers;
    }

    /**
     * @return дата инициализации коллекции
     */
    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Тип коллекции: " + workers.getClass() +
                "\nДата инициализации: " + getDate() +
                "\nКоличество элементов: " + workers.size();
    }

}
