package practice;

public class MaxIndex {
    public static void main(String[] args) {
        System.out.println(helper(2,6));
    }

    private static int helper(int steps, int badelement) {

        int ans = helper2(steps,badelement,0,1);
        return ans;
    }

    private static int helper2(int steps, int badelement, int i, int j) {

        if(steps==0)
            return i;
        if(i+j==badelement)
           return helper2(steps-1,badelement,i,j+1);
        else
           return Math.max(helper2(steps-1,badelement,i,j+1),helper2(steps-1,badelement,i+j,j+1));
    }
}
