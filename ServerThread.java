import java.io.*;
import java.net.Socket;

//A class representing a connection with a client
public class ServerThread implements Runnable{

    private Socket client;

    public ServerThread(Socket client){
        this.client = client;
    }

    @Override
    public void run(){
        try {
            InputStream input = client.getInputStream();
            String filename = "";
            char c;
            //Read the filename one character at a time until you find the null byte
            while ((c = (char)input.read()) != '\0')
                filename+= c;

            File file = new File(filename);
            //If the file exists delete it and overwrite it
            if(file.exists())
                file.delete();

            //Create a file with the same filename
            FileOutputStream output = new FileOutputStream(filename);
            byte[] buffer = new byte[1024];
            //Get the file contents from the client and write them in the file
            while (input.read(buffer) > 0){
                output.write(buffer);
            }
            System.out.println("Received file " + filename);
            client.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
