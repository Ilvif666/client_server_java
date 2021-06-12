/**
 * Класс команды show
 * выводит в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
 */

package commands;

import collection.WorkerCollection;

public class Show extends AbstractCommand {

    @Override
    public String execute(WorkerCollection workerCollection) {
        if (workerCollection.getCollection().size() != 0) {
            return String.valueOf(workerCollection.getCollection());
        } else {
            return "Коллекция пуста";
        }
    }
}
