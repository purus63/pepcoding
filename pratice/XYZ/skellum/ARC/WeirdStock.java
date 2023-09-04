package XYZ.skellum.ARC;

public class WeirdStock {
    public static void main(String[] args) {
        System.out.println(findMinDays(3,7));
    }

    private static int findMinDays(int n, int m) {

       int res=0;
       while(n<m)
       {
           m=(m%2==1)?m+1:m/2;
           res++;
       }
       return res+(n-m);
    }
}
