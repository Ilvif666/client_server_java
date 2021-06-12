/**
 * Класс команды exit
 * Завершить работу клиента с сохранением в файл на стороне сервера
 */

package commands;

import collection.WorkerCollection;
import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;


public class Exit extends AbstractCommand {
    /**
     * @param workerCollection - коллекция с работниками
     * @throws FileNotFoundException
     */
    @Override
    public String execute(WorkerCollection workerCollection) throws FileNotFoundException {
        try {
            XStream xs = new XStream();
            String xmlOutput = xs.toXML(workerCollection.getCollection());
            String xmlFile = "collection.xml";
            File file = new File(xmlFile);
            FileWriter writer = new FileWriter(file);
            writer.write(xmlOutput);
            writer.flush();
            writer.close();
            System.out.println("Коллекция успешно сохранена");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Завершение работы, сохранение коллекции";
    }
}
