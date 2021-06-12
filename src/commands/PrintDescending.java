/**
 * Класс команды print_descending
 * Выводит элементы коллекции в порядке убывания
 */
package commands;

import collection.Worker;
import collection.WorkerCollection;

import java.util.Comparator;
import java.util.LinkedList;

public class PrintDescending extends AbstractCommand {

    @Override
    public String execute(WorkerCollection workerCollection) {
        String result = "Список пуст";
        try {
            if (workerCollection.getCollection().size() > 0) {
                LinkedList<Worker> temp = new LinkedList<Worker>(workerCollection.getCollection());
                temp.sort(salaryComparator);
                result =  temp.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * Компаратор для сравнения по убыванию по полю Salary
     */
    public static Comparator<Worker> salaryComparator = (bar, foo) -> (int) (foo.getSalary() - bar.getSalary());
}
