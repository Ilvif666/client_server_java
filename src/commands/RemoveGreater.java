/**
 * Класс команды remove_greater
 * Удаляет из коллекции элементы, поле Salary которых больше указанного
 */

package commands;

import collection.WorkerCollection;

public class RemoveGreater extends AbstractCommand {

    private float salary;

    /**
     * @param salary значение поля Salary, элементы с которым больше - будут удалены
     */
    public RemoveGreater(float salary) {
        this.salary = salary;
    }

    @Override
    public String execute(WorkerCollection workerCollection) throws NumberFormatException {
        int size = workerCollection.getCollection().size();
        String output = "";
        workerCollection.getCollection().removeIf(worker -> worker.getSalary() > this.salary);
        output = "Элементы больше заданного удалены";
        if (workerCollection.getCollection().size() == size) {
            output = "Такие элементы не найдены";
        }
        return output;
    }
}
