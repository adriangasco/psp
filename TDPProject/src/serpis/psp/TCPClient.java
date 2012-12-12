package serpis.psp;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class TCPClient {
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		pingPong();
		//HolaMundo
	}
		
	public static void pingPong() throws IOException  {
		
		InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
		int port = 10001;
		Socket socket = new Socket(inetAddress, port );
		
		OutputStream outputStream = socket.getOutputStream();
		PrintWriter printWriter = new PrintWriter(outputStream, true);
		printWriter.println("Hola desde TCPClient");
		
		//Datos TCPServer
		ServerSocket serverSocket = new ServerSocket(port);
		Socket socket2 = serverSocket.accept();
		Scanner scanner = new Scanner (socket2.getInputStream());
		String line = scanner.nextLine();
		
		System.out.println(line);
		
		printWriter.close();
		serverSocket.close();
		socket.close();	
		socket2.close();
	}

	}
