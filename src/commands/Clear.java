/**
 * Класс команды clean, которая очищает коллекцию
 */

package commands;
import collection.WorkerCollection;

public class Clear extends AbstractCommand {
    /**
     * @param workerCollection - коллекция с работниками
     */
    @Override
    public String execute(WorkerCollection workerCollection) {
        workerCollection.getCollection().clear();
        return "Коллекция очищена";
    }
}
