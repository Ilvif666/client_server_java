/**
 * Класс команды print_unique_salary
 * Выводит уникальные значения поля salary всех элементов в коллекции
 */
package commands;

import collection.Worker;
import collection.WorkerCollection;
import java.util.HashSet;

public class PrintUniqueSalary extends AbstractCommand {

    @Override
    public String execute(WorkerCollection workerCollection) {
        String result = "Список пуст";
        try {
            if (workerCollection.getCollection().size() > 0) {
                HashSet<Float> salarySet = new HashSet<>(workerCollection.getCollection().size());
                for (Worker each : workerCollection.getCollection()) {
                    salarySet.add(each.getSalary());
                }
                result = ("Уникальные значения salary: ") + salarySet.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
