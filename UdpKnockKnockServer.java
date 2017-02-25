import java.net.DatagramSocket;
import java.net.DatagramPacket;

public class UdpKnockKnockServer 
{
	public static final int MAX_LEN = 1024;
	public static void main (String[] args) throws Exception
	{
		if (args.length == 0)
		{
			System.err.println("No port provided.");
			System.exit(0);
		}
		
		int port = Integer.parseInt(args[0]);
		DatagramSocket sock = new DatagramSocket(port);
		
		byte[] buf = new byte[MAX_LEN];
		DatagramPacket dmail = new DatagramPacket(buf, buf.length);
		
		while(true)
		{
			sock.receive(dmail);
			System.out.println(new String(dmail.getData(), 0, dmail.getLength()));
			
			String togo = "Who's there?";
			System.out.println(togo);
			DatagramPacket msg = new DatagramPacket(togo.getBytes(), togo.length(), dmail.getAddress(), dmail.getPort());
			
			sock.send(msg);
			
			sock.receive(dmail);
			System.out.println(new String(dmail.getData(), 0, dmail.getLength()));
			
			togo = "You know who?";
			System.out.println(togo);
			msg = new DatagramPacket(togo.getBytes(), togo.length(), dmail.getAddress(), dmail.getPort());
			
			sock.send(msg);
			
			sock.receive(dmail);
			System.out.println(new String(dmail.getData(), 0, dmail.getLength()));
		}
	}
}

