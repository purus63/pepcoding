package practice;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        int arr[]={0,0,0,0,0,0,1,0};
        System.out.println(helper(arr));
    }

       static int helper(int arr[])
        {
            int ans=0;
            int lastidx=0;
            int cont_seq_cnt=0;
            for(int i=0;i<arr.length;i++)
            {
                if(i>0 && arr[i]==1 && arr[i]==arr[i-1])
                {
                    cont_seq_cnt++;
                    if(cont_seq_cnt>ans)
                    {
                        ans=cont_seq_cnt;
                        lastidx=i;
                    }
                }
                else if(arr[i]==1) {
                    cont_seq_cnt = 1;
                    if (cont_seq_cnt > ans) {
                        ans = cont_seq_cnt;
                        lastidx = i;
                    }
                }
                else
                    continue;
            }
            return lastidx-ans;
        }


    }


