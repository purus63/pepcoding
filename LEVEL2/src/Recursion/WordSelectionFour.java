package Recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class WordSelectionFour {

    public static void combination(String ustr,int cc,HashMap<Character,Integer>hmap,String asf,int k) {

        if (asf.length() == k) {


            System.out.println(asf);
            return;
        }

        if (cc == ustr.length()) {
            return;
        }

        char ch = ustr.charAt(cc);
        int freq = hmap.get(ch);

        // YES
        for (int i = freq; i > 0; i--) {
            if (i + asf.length() <= k) {
                String str = "";
                for (int j = 0; j < i; j++) {
                    str += ch;
                }
                combination(ustr, cc + 1, hmap, asf + str, k);
            }

            //No
            combination(ustr, cc + 1, hmap, asf, k);

        }
    }
        public static void main (String[]args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());

            HashMap<Character, Integer> unique = new HashMap<>();
            String ustr = "";
            for (char ch : str.toCharArray()) {
                if (unique.containsKey(ch) == false) {
                    unique.put(ch, 1);
                    ustr += ch;
                } else {
                    unique.put(ch, unique.get(ch) + 1);
                }
            }
            combination(ustr, 0, unique, "", k);
        }
    }