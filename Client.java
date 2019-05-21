import java.net.Socket;

public class Client {

    public static void main(String args[]) {

        final int serverPort = 4444;
        if(args.length < 2)
        {
            System.err.println("Wrong parameters");
            System.err.println("Usage: java -jar client.jar server_ip filepath1 filepath2 ...");
            System.exit(1);
        }
        //Take the first argument and store it as the server's IP address
        String serverIp = args[0];
        for (int i = 1; i<args.length; i++) {
            try {
                Socket server = new Socket(serverIp, serverPort);
                //Start a new thread for each file to be sent
                ClientThread connection = new ClientThread(server, args[i]);
                new Thread(connection).start();
            }catch (Exception ex){
                System.err.println("Could not find Server. Is the server running at port 4444?");
            }
        }
    }
}
