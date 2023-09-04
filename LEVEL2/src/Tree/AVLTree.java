package Tree;

public class AVLTree {

    static class Node{

        int val;
        Node left;
        Node right;

        int ht;
        int balance;

        public Node(int val) {
            this.val = val;
            this.left = this.right = null;
            this.ht = 0;
            this.balance = 0;
        }
    }


    public static  void  updateHeightAndBalance(Node node){
        int lh = node.left==null?-1: node.left.ht;
        int rh = node.right==null?-1:node.right.ht;

        node.balance=lh-rh;
        node.ht = Math.max(lh,rh)+1;
    }

    private static Node getRotation(Node node) {
        updateHeightAndBalance(node);

        if(node.balance==2) {
            if (node.left.balance == 1) {
                //ll
                return llrotation(node);

            }
            if (node.left.balance == -1) {
                //lr
                node.left=rrrotation(node.left);
                return rrrotation(node);
            }
        }
        if(node.balance==-2)
        {
            if (node.left.balance == 1) {
                //rl
                node.right=llrotation(node.right);
                return rrrotation(node);
            }
            if (node.left.balance == -1) {
                //rr
               return  rrrotation(node);
            }
        }
        return node;
    }


    private static Node llrotation(Node node) {
        Node B=node.left;
        node.left=B.right;
        B.right=node;

        updateHeightAndBalance(node);
        updateHeightAndBalance(B);
        return node;
    }

    private static Node rrrotation(Node node) {
        Node B=node.right;
        node.right=B.left;
        B.left=node;

        updateHeightAndBalance(node);
        updateHeightAndBalance(B);
        return node;
    }

    private static void fun() {
        int arr[] ={50,20,30,40,10,60,70,80,90};
        Node node=null;
        for(int i=0;i<arr.length;i++)
        {
            node=add(node,arr[i]);
        }
        display(node);
        System.out.println("-----------------------------------------");
        for(int val:arr)
        {
            remove(node,val);
            display(node);
            System.out.println("=======================================");
        }
    }

    private static void display(Node node) {
        if(node==null)
            return;
        System.out.println(node.val);
        display(node.left);
        display(node.right);
    }

    private static void remove(Node node, int val) {


        if(node.val==val)
        {
            int X=findmin(node.right);
            node.val=X;
        }
        else if(node.val>val)
        {}
        else if(node.val<val)
        {}

    }

    private static int findmin(Node node) {
        if(node.left!=null)
        {
            return findmin(node.left);
        }
        else
        {
            int val=node.val;
            node=node.right;
            return val;
        }
    }

    private static Node add(Node node, int i) {
        if(node==null)
        {
            node=new Node(i);
        }
        else if(node.val>i){
            node.left=add(node.left,i);
        }
        else{
            node.right=add(node.right,i);
        }
        return node;
    }

    public static void main(String[] args) {
        fun();
    }



}
