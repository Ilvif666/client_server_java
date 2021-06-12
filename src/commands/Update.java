/**
 * Класс обновляет значение элемента коллекции, id которого равен заданному
 */

package commands;

import collection.Worker;
import collection.WorkerCollection;

public class Update extends AbstractCommand {

    private Worker worker;
    private int id;

    public Update(Worker worker, int id) {
        this.worker = worker;
        this.id = id;
    }

    /**
     * @throws NumberFormatException
     */
    @Override
    public String execute(WorkerCollection workerCollection) throws NumberFormatException {
        String output = "";
        int counter = 0;
        int size = workerCollection.getCollection().size();
        for (int i = 0; i < size; i++) {
            if (workerCollection.getCollection().get(i).getId() == this.id) {
                ReadElement read = new ReadElement();
                workerCollection.getCollection().remove(i);
                workerCollection.getCollection().add(this.worker);
                output = "Элемент коллекции обновлен";
            } else {
                counter += 1;
            }
        }
        if (counter == size) {
            output = "Такой элемент не найден";
        }
        return output;
    }
}
