import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class UdpKnockKnockClient
{
	public static final int MAX_LEN = 1024;
	public static void main (String[] args) throws Exception
	{
		if (args.length < 2)
		{
			System.err.println("args.length");
			System.exit(0);
		}
		
		DatagramSocket sock = new DatagramSocket();
		
		byte[] buf = new byte[MAX_LEN];
		DatagramPacket dmail = new DatagramPacket(buf, buf.length);
		
		InetAddress server = InetAddress.getByName(args[0]);
		int port = Integer.parseInt(args[1]);
		
		String msg = "Knock, knock.";
		System.out.println(msg);
		DatagramPacket togo = new DatagramPacket(msg.getBytes(), msg.length(), server, port);
		
		sock.send(togo);
		sock.receive(dmail);
		System.out.println(new String(dmail.getData(), 0, dmail.getLength()));
		
		msg = "You know.";
		System.out.println(msg);
		togo = new DatagramPacket(msg.getBytes(), msg.length(), server, port);
		
		sock.send(togo);
		sock.receive(dmail);
		System.out.println(new String(dmail.getData(), 0, dmail.getLength()));
		
		msg = "Avada Kedavra!";
		System.out.println(msg);
		togo = new DatagramPacket(msg.getBytes(), msg.length(), server, port);
		
		sock.send(togo);
	}
}

