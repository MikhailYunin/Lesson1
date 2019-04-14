package lesson12.messageApp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MessageServer {
    private int port;

    public MessageServer(int port){
        this.port = port;
    }



    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server started...");
            while (true){
                Socket socket = serverSocket.accept();
                getMessage(socket);
//                new Message("server", "сообщение получено");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void sentMessage(Socket socket) {
        String name = "Server";
        String messageText = "сообщение отправлено";
        Message message = new Message(name, messageText);

        try (ObjectOutputStream out= new ObjectOutputStream(socket.getOutputStream())){

                out.writeObject(message);
                out.flush();
            } catch (IOException e1) {
            e1.printStackTrace();
        }
    }






    private void getMessage(Socket socket) throws IOException, ClassNotFoundException {
        try (ObjectInputStream objIn = new ObjectInputStream(socket.getInputStream())){
            Object obj = objIn.readObject();
            printMessage((Message) obj);
        }
    }

    private void printMessage(Message message){
        System.out.println("получено сообщение: " +
                message.getMessageText() + " от " + message.getSender());
    }

    public static void main(String[] args) {
        int port = 8090;
        MessageServer messageServer = new MessageServer(port);
        try {
            messageServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}