import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientThread implements Runnable{

    private Socket server;
    private String filepath;

    public ClientThread(Socket server, String filepath){
        this.server = server;
        this.filepath = filepath;
    }

    @Override
    public void run() {
        try {

            File file = new File(filepath);
            if (file.exists() && file.canRead()) {
                FileInputStream fileStream = new FileInputStream(filepath);
                OutputStream output = server.getOutputStream();
                //Get the filename instead of the full path
                String filename = file.getName();
                byte[] buffer = new byte[1024];
                byte[] name = filename.getBytes();
                //Send the filename and then a null byte so the server knows when to stop reading
                output.write(name);
                output.write('\0');
                //Send the file contents
                while (fileStream.read(buffer) > 0) {
                    output.write(buffer);
                }
                System.out.println(filename + " has been sent");
            }
            server.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
