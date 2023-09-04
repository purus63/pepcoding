package XYZ.skellum.ARC;

import java.util.Scanner;

public class BstFromPreorder {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,0,preorder.length-1);
    }

    public static TreeNode helper(int pre[],int lo,int hi)
    {
        if(lo>hi)
            return null;
        if(lo==hi)
            return new TreeNode(pre[lo]);
        TreeNode node= new TreeNode(pre[lo]);

        int idx=lo+1;
        while(idx<pre.length && pre[idx]<pre[lo])
            idx++;

        int cnt= idx-lo-1;
        int a1[] =new int[cnt];
        int a2[]= new int[hi-idx+1];
        int i1=0,i2=0;

        for(int i=lo+1;i<=hi;i++)
        {
            if(pre[i]<pre[lo])
                a1[i1++]=pre[i];
            else
                a2[i2++]=pre[i];
        }

        node.left=helper(a1,0,a1.length-1);
        node.right=helper(a2,0,a2.length-1);

        return node;

    }


    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = bstFromPreorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}