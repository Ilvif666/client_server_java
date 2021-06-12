package commands;

import collection.Worker;
import collection.WorkerCollection;

/**
 * Класс команды add
 * Добавляет новый элемент в коллекцию
 */
public class Add extends AbstractCommand {

    private Worker worker;

    public Add(Worker worker) {
        this.worker = worker;
    }

    @Override
    public String execute(WorkerCollection workerCollection) {
        workerCollection.getCollection().add(worker);
        return "Новый элемент добавлен в коллекцию";
    }
}
