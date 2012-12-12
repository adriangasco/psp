	import java.io.IOException;
	import java.net.*;
	
	public class UDPServer {
		//private static DatagramSocket datagrama;
		//private static DatagramPacket datagramSocket;
		
	/**
	* @param args
	* @throws IOException
	*/
		public static void main(String [] args) throws IOException {
			byte[] buf = new byte[2048];
			int port = 10001;


			DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);

			InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
	
			DatagramSocket datagramSocket = new DatagramSocket(port, inetAddress);

			while(true) {

				datagramSocket.receive(datagramPacket);
	
				String data = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
				System.out.println("El mensaje es:" + data + "El puerto es:" + datagramPacket.getPort() + 
						  "La dirección ip es:" + datagramPacket.getAddress());
				System.out.printf("length=%d", datagramPacket.getLength());
				
				data = data + data.toLowerCase();
				byte[] bufData = data.getBytes();
				for (int index=0 ; index < data.length(); index++){
					buf[index] = bufData[index];
					datagramPacket.setLength(bufData.length);
				}

				datagramSocket.send(datagramPacket);
				
				

			}
	       }
	}