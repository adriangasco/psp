
import java.io.IOException;
import java.net.*;
import java.util.*;		


	public class UDPClient {
		
		public static void fillByteArray(byte[] buf, String data){
			
			byte[] bufData=data.getBytes();
			for(int i=0; i<bufData.length;i++){
				buf[i]=bufData[i];
			}
		}
	/**
	* @param args
	* @throws IOException
	* @throws InterruptedException
	*/

		public static void main(String [] args) throws IOException, InterruptedException {
			InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
			int port = 10001;
	
			DatagramSocket datagramSocket = new DatagramSocket();
			byte[] bufReceive = new byte[2048];
			DatagramPacket datagramPacketReceive = new DatagramPacket(bufReceive,bufReceive.length);

			while (true) {
				String text = "hola desde UDPClient" + " " + new Date();
				byte [] bufSend = text.getBytes();
				DatagramPacket datagramPacketSend = new DatagramPacket(bufSend , bufSend.length , inetAddress, port);

				datagramSocket.send(datagramPacketSend);

				datagramSocket.receive(datagramPacketReceive);
			
				String data = new String(datagramPacketReceive.getData(), 0 ,datagramPacketReceive.getLength());
				System.out.printf("Receive Data='%s' ", data);

				Thread.sleep(5000); //una pausa de 5 segundos (5000 milisegundos)

			}
		}
	}
