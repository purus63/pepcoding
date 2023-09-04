package XYZ.skellum.ARC;


import java.util.*;

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
    public void setLeft(Node left)
    {
        this.left = left;
    }

    public void setRight(Node right)
    {
        this.right = right;
    }


}


public class Gfg
{
    Node root;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();

            int inord[] = new int[n];
            int level[] = new int[n];
            for(int i = 0; i < n; i++)
                inord[i] = sc.nextInt();

            for(int i = 0; i < n; i++)
                level[i] = sc.nextInt();

            GfG g = new GfG();
            Node node =  g.buildTree(inord, level);
            printPreOrder(node);
            System.out.println();


        }
    }

    static void printPreOrder(Node node)
    {
        if(node == null)
            return;

        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }
}
// } Driver Code Ends


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below*/
class GfG
{
    Node buildTree(int inorder[], int level[])
    {
        //your code here
        return helper(inorder,level,0,inorder.length-1,0,level.length-1);
    }

    static Node helper(int inorder[],int level[],int in1,int in2,int l1,int l2)
    {
        if(in1>in2) return null;
        Node node = new Node(level[l1]);
        int idx=in1;
        HashSet<Integer> hset = new HashSet<>();
        while(inorder[idx]!=level[l1])
        {
            hset.add(inorder[idx]);
            idx++;
        }
        int cnt= idx-in1;

        int lvl1[]=new int[cnt];
        int lvl2[]=new int[in2-idx];
        int i1=0,i2=0;
        for(int i=l1+1;i<=l2;i++)
        {
            if(hset.contains(level[i]))
                lvl1[i1++]=level[i];
            else
                lvl2[i2++]=level[i];
        }


        node.left=helper(inorder,lvl1,in1,idx-1,0,lvl1.length-1);
        node.right=helper(inorder,lvl2,idx+1,in2,0,lvl2.length-1);

        return node;

    }

}


