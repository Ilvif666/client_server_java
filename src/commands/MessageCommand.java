/**
 * Класс сообщения-команды
 * Выводит сообщение
 */
package commands;

import collection.WorkerCollection;

public class MessageCommand extends AbstractCommand {

    private String message;

    public MessageCommand(String message) {
        this.message = message;
    }

    @Override
    public String execute(WorkerCollection workerCollection) {
        return this.message;
    }
}
