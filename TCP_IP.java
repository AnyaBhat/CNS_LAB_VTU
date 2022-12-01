//Client server programming using TCP/IP socket

//Server Program 

import java.io.*;   										 //for input and output stream
import java.net.*;										 //for network application

public class Server
{
	public static void main(String[] args)throws Exception
	{
		ServerSocket sersock=new ServerSocket(4000);                                      //Welcoming socket 
		System.out.println("Server Ready for Connection");
		
		Socket sock=sersock.accept();
		System.out.println("Connection Established");

		InputStream istream=sock.getInputStream();      				 //reading an input through the socket  
		BufferedReader fread= new BufferedReader(new InputStreamReader(istream));	 //filereader
		String fname=fread.readLine();
		BufferedReader cread=new BufferedReader(new FileReader(fname));			 //Content reader

		OutputStream ostream=sock.getOutputStream();
		PrintWriter pwrite=new PrintWriter(ostream,true);
		String str;
		while ((str= cread.readLine())!=null)
			pwrite.println(str);
		System.out.println("Content of the file is sent");

		sock.close();
		sersock.close();
		pwrite.close();
		
	}
} 

//Seperate files

// Client Program
import java.io.*;
import java.net.*;

public class Client
{
	public static void main(String[] args) throws Exception
	{
		Socket sock=new Socket("127.0.0.1",4000);				//Local IP address,port number
		System.out.println("Enter the file name:");
		BufferedReader keyRead=new BufferedReader(new InputStreamReader(System.in));
		String fname=keyRead.readLine();

		OutputStream ostream=sock.getOutputStream();
		PrintWriter pwrite =new PrintWriter(ostream,true);
		pwrite.println(fname);
		System.out.println("Content of the file");
		InputStream istream=sock.getInputStream();
		BufferedReader sockread=new BufferedReader(new InputStreamReader(istream));
		String str;
		while((str=sockread.readLine())!=null)
			System.out.println(str);
		pwrite.close();
		sockread.close();
		keyRead.close();
		
	}
}


//Sample.txt
/* Hello Everyone,
Welcome to Canara Engineering College
With diverse branches and friendly faculty we promise quality eduction at a resonable price .*/
