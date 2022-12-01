//Bellmanford Algoritm
import java.util.Scanner;
public class DVT
{
	public static void main(String[] args)
	{
		int nodes,i,j,k;
		int cost[][]=new int[2020][2020];
		int dist[][]=new int[2020][2020];
		int from[][]=new int[2020][2020];

		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the no. of nodes:");
		nodes=sc.nextInt();
		System.out.println("Enter the cost of the martix:");
		for(i=1;i<=nodes;i++)  
		{
			for(j=1;j<=nodes;j++)
			{
				cost[i][j]=sc.nextInt();
				dist[i][j]=cost[i][j];
				from[i][j]=j;
			}
		}

		//using bellmanford algo
		for(i=1;i<=nodes;i++)
		{
			for(j=1;j<=nodes;j++)
			{
				for(k=1;k<=nodes;k++)
				{
					if(dist[i][j]>dist[i][k]+dist[k][j])
					{
						dist[i][j]=dist[i][k]+dist[k][j];
						from[i][j]=k;
					}
				}
			}
		}
		for(i=1;i<=nodes;i++)
		{
			System.out.println("From router node"+i+":");
			System.out.println("destination \t nexthop \t distance");
			for(j=1;j<=nodes;j++)
			{
				System.out.println(j+"\t\t "+from[i][j]+"\t\t "+dist[i][j]);
			}
		}
	}
}
