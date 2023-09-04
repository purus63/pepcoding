package Faang;

public class Test {
    public static void main(String[] args) {

        String str="abbadefd";
        char ch[] = new char[26];

        for(int i=0;i<str.length();i++)
        {
            int x = str.charAt(i)-'a';
            ch[x]++;
        }
        for(int i=0;i<str.length();i++)
        {
            int x=str.charAt(i)-'a';
            if(ch[x]==1)
            {
                System.out.println(str.charAt(i));
                break;
            }
        }
    }

}
