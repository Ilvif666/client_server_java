/**
 * Класс неизвестной команды
 */

package commands;

import collection.WorkerCollection;

public class UnknownCommand extends AbstractCommand {

    @Override
    public String execute(WorkerCollection workerCollection) {
        return "Команда не найдена";
    }
}
