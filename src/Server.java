/**
 * Главный класс сервера
 */

import collection.WorkerCollection;
import commands.AbstractCommand;
import io.CommunicationServer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.DatagramSocket;;

public class Server {
    static int port = 8080;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        disableAccessWarnings();
        DatagramSocket socket = null;
        try {
            String fileName = "collection.xml";
            //String fileName = args[0];
            socket = new DatagramSocket(port);
            CommunicationServer communication = new CommunicationServer(socket);
            //int port = Integer.parseInt(args[0]);
            WorkerCollection workerCollection = new WorkerCollection();
            workerCollection.createCollection(fileName);
            System.out.println("Чтение коллекции из файла");

            while (true) {
                AbstractCommand command = communication.receiveCommand();
                System.out.println("Сервер получил команду: " + communication.getCurrentCommand());
                String data = command.execute(workerCollection);
                communication.sendMessage(data);
                System.out.println("Ответ отправлен клиенту");
            }
        } catch (NumberFormatException e) {
            System.out.println("Неверно указан порт");
        } catch (FileNotFoundException e) {
            System.out.println("Не найден файл с коллекцией");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Порт не указан");
        } finally {
            socket.close();
        }
    }

    /**
     * фикс WARNING: An illegal reflective access operation has occurred
     * source:https://stackoverflow.com/questions/46454995/how-to-hide-warning-illegal-reflective-access-in-java-9-without-jvm-argument
     */
    @SuppressWarnings("unchecked")
    public static void disableAccessWarnings() {
        try {
            Class unsafeClass = Class.forName("sun.misc.Unsafe");
            Field field = unsafeClass.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Object unsafe = field.get(null);

            Method putObjectVolatile = unsafeClass.getDeclaredMethod("putObjectVolatile", Object.class, long.class, Object.class);
            Method staticFieldOffset = unsafeClass.getDeclaredMethod("staticFieldOffset", Field.class);

            Class loggerClass = Class.forName("jdk.internal.module.IllegalAccessLogger");
            Field loggerField = loggerClass.getDeclaredField("logger");
            Long offset = (Long) staticFieldOffset.invoke(unsafe, loggerField);
            putObjectVolatile.invoke(unsafe, loggerClass, offset, null);
        } catch (Exception ignored) {
        }
    }
}


