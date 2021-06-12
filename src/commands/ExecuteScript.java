/**
 * Класс команды execute_script, запускает исполняемый скрипт
 */
package commands;

import collection.WorkerCollection;
import java.io.FileNotFoundException;

public class ExecuteScript extends AbstractCommand {

    private AbstractCommand[] commands;

    public ExecuteScript(AbstractCommand[] commands) {
        this.commands = commands;
    }

    /**
     *
     * @param workerCollection - коллекция с работниками
     * @throws FileNotFoundException
     */
    @Override
    public String execute(WorkerCollection workerCollection) throws FileNotFoundException {
        String results[] = new String[this.commands.length];
        for (int i = 0; i < this.commands.length; i++) {
            results[i] = this.commands[i].execute(workerCollection);
        }
        String result = String.join(",", results);
        return result;
    }
}
