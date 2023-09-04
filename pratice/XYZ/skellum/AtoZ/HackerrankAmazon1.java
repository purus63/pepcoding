package XYZ.skellum.AtoZ;

import java.util.*;

public class HackerrankAmazon1 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("zld 93 12");
        list.add("fp kindle book");
        list.add("10a echo show");
        list.add("17g 12 256");
        list.add("ab1 kindle book");
        list.add("125 echo dot gen");

        //sortOrder(list);
        System.out.println(sortOrder(list));

    }
   static Comparator<String> comp = new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            int res=s1.substring(s1.indexOf(' ')+1).compareTo(s2.substring(s2.indexOf(' ')+1));
            if(res==0)
                return s1.substring(0,s1.indexOf(' ')).compareTo(s2.substring(0,s2.indexOf(' ')));
            return  res;
        }
    };

    private static List<String> sortOrder(List<String> list) {

        //Collections.sort(list,comp);
        List<String> ans = new ArrayList<>();
        for(String str:list)
        {
            if(str.charAt(str.indexOf(' ')+1)<'a')
            {
                ans.add(str);
            }
        }
        Collections.sort(list,comp);
        List<String> ans2 = new ArrayList<>();
        for(String str:list)
        {
            if(str.charAt(str.indexOf(' ')+1)>='a')
            {
                ans2.add(str);
            }
        }
        for(String str:ans)
        {
            ans2.add(str);
        }
        return ans2;
    }
}
