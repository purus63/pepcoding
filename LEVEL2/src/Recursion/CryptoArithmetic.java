package Recursion;

import java.util.HashMap;
import java.util.Scanner;

public class CryptoArithmetic {

        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            String s1 = scn.nextLine();
            String s2 = scn.nextLine();
            String s3 = scn.nextLine();

            HashMap<Character, Integer> charIntMap = new HashMap<>();
            String unique = "";
            for (int i = 0; i < s1.length(); i++) {
                if (!charIntMap.containsKey(s1.charAt(i))) {
                    charIntMap.put(s1.charAt(i), -1);
                    unique += s1.charAt(i);
                }
            }

            for (int i = 0; i < s2.length(); i++) {
                if (!charIntMap.containsKey(s2.charAt(i))) {
                    charIntMap.put(s2.charAt(i), -1);
                    unique += s2.charAt(i);
                }
            }

            for (int i = 0; i < s3.length(); i++) {
                if (!charIntMap.containsKey(s3.charAt(i))) {
                    charIntMap.put(s3.charAt(i), -1);
                    unique += s3.charAt(i);
                }
            }

            boolean[] usedNumbers = new boolean[10];
            solution(unique, 0, charIntMap, usedNumbers, s1, s2, s3);
        }


        public static void solution(String unique, int idx,
                                    HashMap<Character, Integer> charIntMap, boolean[] usedNumbers,
                                    String s1, String s2, String s3) {
            if(idx==unique.length())
            {
                int num1=getnumval(s1,charIntMap);
                int num2=getnumval(s2,charIntMap);
                int num3=getnumval(s3,charIntMap);

                if(num1+num2==num3)
                {
                    for(char ch='a';ch<'z';ch++)
                    {
                        if(charIntMap.containsKey(ch))
                        {
                            System.out.print(ch+"-"+charIntMap.get(ch)+" ");
                        }
                    }
                    System.out.println();
                }
                return;
            }
            char ch =unique.charAt(idx);
            for(int i=0;i<=9;i++)
            {
                if(!usedNumbers[i]) {
                        charIntMap.put(ch,i);
                        usedNumbers[i]=true;
                        solution(unique,idx+1,charIntMap,usedNumbers,s1,s2,s3);
                        charIntMap.put(ch,-1);
                        usedNumbers[i]=false;
                }
            }
        }

    private static int getnumval(String str,HashMap<Character, Integer> charIntMap) {

            int val=0;
            for(int i=0;i<str.length();i++)
            {
                val=charIntMap.get(str.charAt(i))+10*val;
            }
            return val;
        }

}
