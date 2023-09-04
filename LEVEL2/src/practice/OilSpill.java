package practice;


import java.util.Scanner;

public class OilSpill {
    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        int t=sc.nextInt();
        int n=0;
        while(t-->0)
        {
            n=sc.nextInt();
            int container[]= new int[n];
            for(int i=0;i<n;i++)
                container[i]=sc.nextInt();
            int oil[]=new int[n];
            for(int i=0;i<n;i++)
                oil[i]=sc.nextInt();
            int spill=0;
            int total=oil[0];
            int temp=0;
            for(int i=1;i<n;i++)
            {
                if(oil[i]+oil[i-1]>container[i])
                    spill+=oil[i]+oil[i-1]-container[i];
                oil[i]=Math.min(container[i],oil[i]+oil[i-1]);
                total=oil[i];
            }
            System.out.println(total+" "+spill);
        }


    }
}

