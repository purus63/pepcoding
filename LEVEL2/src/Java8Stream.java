import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Stream {

    public static void main(String[] args) {

        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(6);
        al.add(54);
        al.add(25);
        al.add(45);
        for(int i=0;i<10;i++)
        {
            al.add((int)(Math.random()*1000));
        }

        List<Integer> l1= al.stream().map(i->i*1).collect(Collectors.toList());
        System.out.println(l1);

        l1 = al.stream().filter(i->i%2==0).collect(Collectors.toList());
        System.out.println(l1);

         //l1= al.stream().sorted().collect(Collectors.toList());
        //l3.stream().forEach(System.out::print);
        System.out.println(l1);

        System.out.println(al.stream().filter(i->i%2==0).count());
        System.out.println(al.stream().max((i1,i2)->-i1.compareTo(i2)).get());


    }
}
