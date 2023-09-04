package Recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class QueensCombinations2dAs2dBoxChooses {

    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){

        if(tq==row)
        {
            if(qpsf==tq)
            {
                System.out.println(asf);
            }
            return;
        }
        if(col+1<tq)
        {
            //yes
            queensCombinations(qpsf+1,tq,row,col+1,asf+"q");
            //no
            queensCombinations(qpsf,tq,row,col+1,asf+"-");
        }
        else{
            //last index in row
            //yes
            queensCombinations(qpsf+1,tq,row+1,0,asf+"q\n");
            //no
            queensCombinations(qpsf,tq,row+1,0,asf+"-\n");
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        queensCombinations(0, n, 0, 0, "");
    }
}
