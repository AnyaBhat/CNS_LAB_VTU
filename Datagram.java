// datagram socket prog client server

import java.net.*;
import java.util.*;
 
public class server 
{
	public static void main(String[] args) throws Exception
	{
		DatagramSocket ds= new DatagramSocket();					// creating datagram socket
		System.out.println("Enter the message and press enter:");
		//Only a single line msg  
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		InetAddress ip=InetAddress.getByName("127.0.0.1");
		DatagramPacket dp= new DatagramPacket(str.getBytes(),str.length(),ip,21);	//21-port number 
		ds.send(dp);
		ds.close();			
	}
}


//Seperate files 


// datagram socket prog client server

import java.net.*;
import java.util.*;
 
public class client
{
	public static void main(String[] args) throws Exception
	{
		DatagramSocket sock= new DatagramSocket(21);					
		System.out.println("Message from server:");
		byte[] buf=new byte[1024];
		DatagramPacket dp= new DatagramPacket(buf,1024);
		sock.receive(dp);
		String str=new String(dp.getData(),0,dp.getLength());
		System.out.println(str);
		sock.close();
		
	}
}
