package Client;


import java.io.ByteArrayInputStream;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


import java.awt.image.BufferedImage;


import javax.imageio.ImageIO;





public class ClientSocket {

    private static ClientSocket instance = null;
    
    public static boolean correctIP = false;

    private Integer port = 4907;

    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    private ClientSocket (String serverIp) {
        try {
            socket = new Socket(serverIp, port);
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());
            correctIP = true;
        } catch (IOException e) {
            System.out.println("Failed connection.");
        }

    }

    public static ClientSocket getInstance (String serverIp) {
        if (instance == null) {
            instance = new ClientSocket(serverIp);
        }
        return instance;
    }

    public static ClientSocket getInstance() {
        return instance;
    }
    
    public void sendMessage(String message) {
        try {
            outputStream.writeUTF(message);
        } catch (IOException e) {

        }
    }
    
   
    public String getMessage() {
        try {
            return inputStream.readUTF();
        } catch (IOException e) {
            return null;
        }
    }
    
    public BufferedImage getImage() {
        try {
            byte[] bytes = new byte[1024 * 1024];
            int count = 0;
            do {
		count+= socket.getInputStream().read(bytes, count, bytes.length - count);
                
            } while(!(count > 4 && bytes[count - 2] == (byte) -1 && bytes[count - 1] == (byte) -39));
            
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(bytes));
            
            return image;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}