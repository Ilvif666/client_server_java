/**
 * Класс команды add_if_max
 * Добавляет новый элемент в коллекцию, если его поле salary превышает значение наибольшего элемента коллекции
 */

package commands;

import collection.Worker;
import collection.WorkerCollection;

public class AddIfMax extends AbstractCommand {

    private Worker worker;

    public AddIfMax(Worker worker) {
        this.worker = worker;
    }

    /**
     * @param workerCollection - коллекция с работниками
     * @throws NumberFormatException
     */
    @Override
    public String execute(WorkerCollection workerCollection) throws NumberFormatException {
        float max = 0;
        if (workerCollection.getCollection().size() > 0) {
            for (Worker each : workerCollection.getCollection()) {
                if (each.getSalary() > max) {
                    max = each.getSalary();
                }
            }
        }
        workerCollection.getCollection().add(this.worker);
        if (workerCollection.getCollection().getLast().getSalary() < max) {
            workerCollection.getCollection().remove(workerCollection.getCollection().getLast());
            return ("Элемент не добавлен, так как не является максимальным");
        } else return ("Элемент добавлен в коллекцию");
    }
}
