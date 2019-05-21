import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    public static void main(String[] args) {

        final int port = 4444;
        System.out.println("Starting Server...");

        try {
            ServerSocket server = new ServerSocket(port);
            while (true){
                //Accept incoming connections
                Socket client = server.accept();
                ServerThread handler = new ServerThread(client);
                new Thread(handler).run();
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
