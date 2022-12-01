
//Write a program for error detection code using CRC-CCITT
import java.util.Scanner;
public class Crc
{
	static int data[],cs[];
	static int g[]={1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1};
	static int n,i,e,c,pos;
	static int N=17;

	static void xor()
	{
		for(c=0;c<N;c++)
			cs[c]=((cs[c]==g[c])? 0:1);
	}

	static void crc()
	{
		for(i=0;i<N;i++)
			cs[i]=data[i];
		do
		{
			if(cs[0]==1)
				xor();
			for(c=0;c<N-1;c++)
				cs[c]=cs[c+1];
			cs[c]=data[i++];
		}while(i<=n+N-1);
	}

	public static void main(String[] args)
	{
		cs=new int[100];
		Scanner br=new Scanner(System.in);
		System.out.println("Enter no.of Databits:");
		n=br.nextInt();
		data=new int[100];
		System.out.println("Enter the data bits:");
		for(i=0;i<n;i++)
			data[i]=br.nextInt();
		System.out.println("\n\n CRC Divisor:");
		for(i=0;i<N;i++)
			System.out.print(g[i]);
		for(i=n;i<n+N-1;i++)
			data[i]=0;
		System.out.println("\n\nModified Data:");
		for(i=0;i<n+N-1;i++)
			System.out.print(data[i]);
		crc();
		System.out.println("\n\nCRC checksum:");
		for(i=0;i<N-1;i++)
			System.out.print(cs[i]);
		for(i=n;i<n+N-1;i++)
			data[i]=cs[i-n];
		System.out.println("\n\nFinal Codeword:");
		for(i=0;i<n+N-1;i++)
			System.out.print(data[i]);
		System.out.println("\n\nTest error detection 0(yes) 1(no)?:");
		e=br.nextInt();
		if(e==0)
		{
			System.out.println("Enter positon where error is to inserted:");
			pos=br.nextInt();
			data[pos]=(data[pos]==0)?1:0;
			System.out.println("\nErroneous data");
			for(i=0;i<n+N-1;i++)
				System.out.print(data[i]);
		}
		crc();
		System.out.println("\n\nReceiver Checksum:");
		for(i=0;i<N;i++)
			System.out.print(cs[i]);
		for(i=0;i<N-1;i++)
		{
			if(cs[i]!=0)
			{
				System.out.println("\n\nERROR is Received");
				System.exit(0);
			}
		}
		System.out.println("\nNo Error in Received codeword");
	}
}
