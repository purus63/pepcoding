package Arrays;

public class Leetcode925 {
    public static void main(String[] args) {
        System.out.println(isLongPressedName("alex","aaleex"));
    }
    public static boolean isLongPressedName(String name, String typed) {

        if(name.length()>typed.length())
            return false;
        int ptr1=0;
        int ptr2=0;
        while(ptr1<name.length() && ptr2<typed.length())
        {
            char a= name.charAt(ptr1);
            char b= typed.charAt(ptr2);
            if(a!=b)
                return false;
            while(ptr1<name.length() && ptr2<typed.length() &&
                    name.charAt(ptr1)==typed.charAt(ptr2))
            {
                a=name.charAt(ptr1);
                ptr1++;
                ptr2++;
            }
            while(ptr2<typed.length() && typed.charAt(ptr2)==a)
                ptr2++;
        }

        if(ptr1!=name.length())
            return false;
        return true;
    }

}
