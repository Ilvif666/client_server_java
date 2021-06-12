package io;
/**
 * Класс для общения сервера с клиентом
 */

import commands.AbstractCommand;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class CommunicationServer {

    private DatagramSocket socket;
    private InetSocketAddress address;
    private int port;
    private InetAddress clientAddress;
    private AbstractCommand command;

    public CommunicationServer(DatagramSocket socket) throws IOException {
        this.socket = socket;
    }

    /**
     * Получение данных от клиента
     * @return команда, которую отправил клиент
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public AbstractCommand receiveCommand() throws IOException, ClassNotFoundException {

        byte[] incomingData = new byte[5000];
        DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
        this.socket.receive(incomingPacket);
        this.clientAddress = incomingPacket.getAddress();
        this.port = incomingPacket.getPort();

        byte[] data = incomingPacket.getData();
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ObjectInputStream is = new ObjectInputStream(in);
        AbstractCommand command = (AbstractCommand) is.readObject();
        in.close();
        is.close();
        this.command = command;
        return command;
    }

    public AbstractCommand getCurrentCommand() {
        return this.command;
    }

    /**
     * Отправка данных клиенту
     * @param msg - сообщение, которое отправляется клиенту
     * @throws IOException
     */
    public void sendMessage(String msg) throws IOException {
        byte[] replyByte = msg.getBytes();
        DatagramPacket replyPacket = new DatagramPacket(replyByte, replyByte.length, this.clientAddress, this.port);
        this.socket.send(replyPacket);
    }

}

