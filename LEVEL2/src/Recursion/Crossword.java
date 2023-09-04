package Recursion;


import java.io.*;
import java.util.*;

public class Crossword {

    public static boolean canPlaceHorizontal(char[][] arr,int i,int j,String str){

        if(j-1>=0 && arr[i][j-1]!='+')
        {return false;}

        if(j+str.length()<arr[0].length && arr[i][j+str.length()]!='+')
        {
            return false;
        }

        for(int jj=0;jj<str.length();jj++)
        {
            if(j+jj>=arr[0].length)
            {return false;}
            if(arr[i][j+jj]!='-' && arr[i][j+jj]!=str.charAt(jj))
                return false;
        }
        return true;
    }

    public static boolean canPlaceVertical(char[][] arr,int i,int j,String str){

        if(i-1>=0 && arr[i-1][j]!='+')
        {return false;}

        if(i+str.length()<arr.length && arr[i+str.length()][j]!='+')
        {
            return false;
        }

        for(int ii=0;ii<str.length();ii++)
        {
            if(i+ii>=arr.length)
            {return false;}

            if(arr[i+ii][j]!='-' && arr[i+ii][j]!=str.charAt(ii))
                return false;
        }
        return true;
    }

    public static void placehorizontal(char [][] arr,int i,int j,String str,boolean[] hp)
    {
        for(int id=0;id<str.length();id++)
        {
            if(arr[i][j+id]=='-')
            {
                hp[id]=true;
                arr[i][j+id]=str.charAt(id);
            }
        }
    }

    public static void placevertical(char [][] arr,int i,int j,String str,boolean[] vp)
    {
        for(int id=0;id<str.length();id++)
        {
            if(arr[i+id][j]=='-')
            {
                vp[id]=true;
                arr[i+id][j]=str.charAt(id);
            }
        }

    }

    public static void unplacehorizontal(char [][] arr,int i,int j,boolean[] hp){
        for(int jj=0;jj<hp.length;jj++)
        {
            if(hp[jj])
            {
                arr[i][j+jj]='-';
            }
        }

    }

    public static void unplacevertical(char [][] arr,int i,int j,boolean[] vp){

        for(int ii=0;ii<vp.length;ii++)
        {
            if(vp[ii])
            {
                arr[i+ii][j]='-';
            }
        }

    }


    public static void solution(char[][] arr, String[] words, int idx){
        //write your code here
        if(idx==words.length)
        {
            print(arr);return;
        }

        String wrd =words[idx];
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                if(canPlaceHorizontal(arr,i,j,wrd))
                {
                    boolean hp[] = new boolean[wrd.length()];
                    placehorizontal(arr,i,j,wrd,hp);
                    solution(arr,words,idx+1);
                    unplacehorizontal(arr,i,j,hp);
                }


                if(canPlaceVertical(arr,i,j,wrd))
                {
                    boolean vp[] = new boolean[wrd.length()];
                    placevertical(arr,i,j,wrd,vp);
                    solution(arr,words,idx+1);
                    unplacevertical(arr,i,j,vp);
                }
            }
        }


    }


    public static void print(char[][] arr){
        for(int i = 0 ; i < arr.length; i++){
            for(int j = 0 ; j < arr.length; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] arr = new char[10][10];
        for(int i = 0 ; i < arr.length; i++){
            String str = scn.next();
            arr[i] = str.toCharArray();
        }
        int n = scn.nextInt();
        String[] words = new String[n];
        for(int i = 0 ; i  < words.length; i++){
            words[i] = scn.next();
        }
        solution(arr,words,0);
    }
}