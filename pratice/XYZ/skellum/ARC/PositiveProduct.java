package XYZ.skellum.ARC;

import java.util.ArrayList;

public class PositiveProduct {

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);al.add(-2);al.add(-3);al.add(4);al.add(-1);al.add(-1);al.add(-1);al.add(-1);al.add(-3);
        System.out.println(maxLength(al));
    }

    private static int maxLength(ArrayList<Integer> al) {
        int odd=0;
        int lidx=0;
        int ridx=al.size()-1;
        for(int a:al)
        {
            if(a<0)
                odd++;
        }
        if(odd%2==0)
            return al.size();

        while(lidx<ridx)
        {
            if(al.get(lidx)<0 && al.get(ridx)<0)
                break;
            else if(al.get(lidx)<0)
                ridx--;
            else if(al.get(ridx)<0)
                lidx++;
            else
            {
                lidx++;
                ridx--;
            }
        }
        return (al.size()-(lidx+1)>(ridx)?al.size()-(lidx+1):ridx);
    }
}
