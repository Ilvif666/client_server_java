/**
 * Главный класс клиента
 */

import commands.AbstractCommand;
import commands.Exit;
import io.CommunicationClient;
import io.CreateObject;
import io.TerminalRead;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class Client {
    static int port = 8080;
    static String host = "localhost";

    public static void main(String[] args) throws IOException {

        try {
            //int port = Integer.parseInt(args[0]);
            //String host = args[1];

            DatagramSocket socket = new DatagramSocket();
            TerminalRead terminalRead = new TerminalRead();
            CreateObject createObject = new CreateObject();
            AbstractCommand command = new AbstractCommand();
            CommunicationClient communicationClient = new CommunicationClient(host, port, socket);

            System.out.println("Напиши help");
            while (true) {
                socket.setSoTimeout(1000);
                command = createObject.commandChoice(terminalRead.getNextInput());
                communicationClient.sendCommand(command);
                communicationClient.receiveMessage();
                if (command instanceof Exit) {
                    socket.close();
                    break;
                }
            }
        } catch (SocketTimeoutException e) {
            System.out.println("Сервер упал");
        } catch (StackOverflowError e) {
            System.out.println("Клиент упал");
        } catch (UnknownHostException e) {
            System.out.println("Хост не найден");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Неверно указан порт");
        }
    }
}
