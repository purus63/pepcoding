package XYZ.skellum.Grab;

public class Grab2 {
    static class Tree{
        public int x;
        public Tree l;
        public Tree r;
        Tree(int x,Tree l,Tree r)
        {
            this.x=x;
            this.l=l;
            this.r=r;
        }
        Tree(int x)
        {
            this.x=x;
            this.l=null;
            this.r=null;
        }
    }

    public static void main(String[] args) {

        Tree root= new Tree(1);
        //root.l=new Tree(2);
        root.r=new Tree(2);
       // root.l.l=new Tree(1);
        //root.l.r=new Tree(1);
        root.r.l=new Tree(1);
        root.r.r= new Tree(1);
        root.r.r.l= new Tree(4);
        System.out.println(sol2(root));

    }

    static int ans1;
    private static int sol2(Tree root) {
        int arr[]=new int[100000];
        int ans=0;
        helper(root,arr,ans);
        return  ans1;
    }

    private static void helper(Tree root, int[] arr, int ans) {
        if(root==null)
            return;
        if(arr[root.x]==0) {
            arr[root.x] = 1;
            ans1=Math.max(ans+1,ans1);
        }
        else
        {
            return;
        }
        helper(root.l,arr,ans+1);
        helper(root.r,arr,ans+1);
        arr[root.x] = 0;
    }
}
