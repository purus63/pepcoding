package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MorganStanley {
    public static void main(String[] args) {

        List<Integer> al = new ArrayList<>();
        al.add(5);
        al.add(9);
        al.add(19);
        al.add(10);
       // al.add(5);

        System.out.println(cardPackets(al));
    }

    private static int cardPackets(List<Integer> al) {
        int cnt=0;
        for (int i=0;i<al.size();i++)
        {
            if(al.get(i)%2!=0)
                cnt++;
        }
        return cnt;
    }


}
