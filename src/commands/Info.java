package commands;

import collection.WorkerCollection;

public class Info extends AbstractCommand {

    @Override
    public String execute(WorkerCollection workerCollection) {
        try {
            return workerCollection.toString();
        } catch (NullPointerException e) {
            return ("Коллекция пуста");
        }
    }
}
