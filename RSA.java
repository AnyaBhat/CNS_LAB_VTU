//RSA Algorithm

import java.util.*;
import java.io.*;

public class RSA
{
	static int mult(int x,int y,int n)
	{
		int j,k=1;
		for(j=1;j<=y;j++)
		k=(k*x)%n;
		return (int)k;
 	}
	public static void main(String[] args)throws Exception
	{
		Scanner sc= new Scanner(System.in);
		InputStreamReader r=new InputStreamReader(System.in); 	//Read a String-input stream reader 
		BufferedReader br=new BufferedReader(r);	//Stores the read string into buffered reader
		
		int p,q,e,d=0,i,n,Z;
		String msg1;
		int pt[]=new int[100];
		int ct[]=new int[100];

		System.out.println("Enter two large prime numbers:");
		p=sc.nextInt();
		q=sc.nextInt();
		n=p*q;
		Z=(p-1)*(q-1);
		System.out.println("Select e value:");
		e=sc.nextInt();
		System.out.println("Enter a msg:");
		msg1=br.readLine();
		char msg[]=msg1.toCharArray(); 	//converting string to character array
		for( i=0;i<msg.length;i++)
			pt[i]=msg[i];
		for(d=0;d<Z;++d)
		{		
			if((e*d)%Z==1)
				break;
		}
		System.out.println("p="+p+"\t,q="+q+"\t,n="+n+"\t,Z="+Z+"\t,e="+e+"\t,d="+d);
		System.out.println("Ciphertext:");
		for(i=0;i<msg.length;i++)
			ct[i]=mult(pt[i],e,n);
		for(i=0;i<msg.length;i++)		//Display Ciphertext
			System.out.print(ct[i]+"\t");
		System.out.println("\nPlain text:");
		for(i=0;i<msg.length;i++)
			pt[i]=mult(ct[i],d,n);
		for(i=0;i<msg.length;i++)
			System.out.print((char)pt[i]+"\t");	
