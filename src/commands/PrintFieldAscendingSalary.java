/**
 * Класс команды print_field_ascending_salary
 * Выводит значения поля salary всех элементов в порядке возрастания
 */

package commands;

import collection.Worker;
import collection.WorkerCollection;

import java.util.Comparator;

public class PrintFieldAscendingSalary extends AbstractCommand {

    @Override
    public String execute(WorkerCollection workerCollection) {
        String result = "Список пуст";
        try {
            if (workerCollection.getCollection().size() > 0) {
                WorkerCollection temp = workerCollection;
                temp.getCollection().sort(salaryAscendingComparator);
                String[] results = new String[temp.getCollection().size()];
                for (int i = 0; i < temp.getCollection().size(); i++) {
                    results[i] = temp.getCollection().get(i).getSalary().toString();
                }
                result = String.join("; ", results);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Компаратор для сравнения по возрастанию по полю Salary
     */
    public static Comparator<Worker> salaryAscendingComparator = (foo, bar) -> (int) (foo.getSalary() - bar.getSalary());

}
