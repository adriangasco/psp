package serpis.psp;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class TCPServer {

	public static void main(String[] args) throws UnknownHostException, IOException {
		pingPong();
		//HolaMundo
	}
		
	public static void pingPong() throws IOException {
		
		int port = 10001;
		ServerSocket serverSocket = new ServerSocket(port);
		Socket socket = serverSocket.accept();
		Scanner scanner = new Scanner(socket.getInputStream());
        String line = scanner.nextLine();	
        
        //envio a TCPClient
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        Socket socket2 = new Socket(inetAddress, port);
        OutputStream outputStream = socket2.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream, true);
		printWriter.println("Linea "+line+line.toUpperCase());
		
		
		//cierre
		socket.close();
		socket2.close();
		printWriter.close();
		serverSocket.close();
	}

}
