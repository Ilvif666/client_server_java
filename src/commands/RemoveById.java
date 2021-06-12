/**
 * Класс команды remove_by_id
 * Удаляет из коллекции элементы, поле id которых равно указанному
 */

package commands;

import collection.WorkerCollection;

public class RemoveById extends AbstractCommand {

    private long id;

    /**
     *
     * @param id элемент которого необходимо удалить
     */
    public RemoveById(int id) {
        this.id = id;
    }

    @Override
    public String execute(WorkerCollection workerCollection) throws NumberFormatException {
        int counter = 0;
        int size = workerCollection.getCollection().size();
        String output = "";

        for (int i = 0; i < size; i++) {
            if (workerCollection.getCollection().get(i).getId() == (this.id)) {
                workerCollection.getCollection().remove(i);
                output = "Элемент удален";
            } else {
                counter += 1;
            }
        }
        if (counter == size) {
            output = "Элемент с таким ID не найден";
        }
        return output;
    }
}
