package commands;

import collection.WorkerCollection;


/**
 * Класс команды Head - выводит первый элемент коллекции
 */
public class Head extends AbstractCommand {
    /**
     * @param workerCollection - коллекция с работниками
     */
    @Override
    public String execute(WorkerCollection workerCollection) {
        return (workerCollection.getCollection().getFirst().toString());
    }
}
