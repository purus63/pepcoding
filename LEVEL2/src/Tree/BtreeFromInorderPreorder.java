package Tree;

import java.util.Scanner;

public class BtreeFromInorderPreorder {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode helper(int[] preorder, int[] inorder,int p1,int p2,int in1,int in2)
    {
        if(p1>p2)
            return null;
        TreeNode root= new TreeNode(preorder[p1]);
        int cnt=0;

        for(int i=in1;i<=in2;i++)
        {
            if(inorder[i]!=preorder[p1])
                cnt++;
            else
                break;
        }

        if(cnt!=0)
        {
            root.left  = helper(preorder,inorder,p1+1,p1+cnt,in1,in1+cnt-1);
            root.right = helper(preorder,inorder,p1+cnt+1,p2,in1+cnt+1,in2);
        }
        return root;
    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        return helper(preorder,inorder,0,preorder.length,0,inorder.length);

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

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = buildTree(pre, in);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}