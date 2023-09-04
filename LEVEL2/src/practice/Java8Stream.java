package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Stream {
    public static void main(String[] args) {

        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        al.add(6);
        al.add(7);
        al.add(8);
        //System.out.println(al.stream().filter(i->i%2==1).collect(Collectors.toList()).stream().map(i->i*i).collect(Collectors.toList()).stream().mapToInt(i->i).sum());
        System.out.print(al.stream().filter(i->i%2==1).collect(Collectors.toList()).stream().map(i->i*i).collect(Collectors.toList()).stream().mapToInt(i->i).sum());
    }
}
