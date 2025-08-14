import java.util.*;

public class LCA{
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){
            val=x;
            left=null;
            right=null;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        TreeNode root = buildTree(arr);
        
        int [] arr2 = new int[2];
        for(int i=0;i<2;i++){
            if(i==0){
                System.out.print("p: ");
                arr2[i] = sc.nextInt();
            }
            else{
                System.out.print("q: ");
                arr2[i] = sc.nextInt();
            }
        }
        TreeNode left = new TreeNode(arr2[0]);
        TreeNode right = new TreeNode(arr2[1]);
        TreeNode result = lowest(root, left, right);
        System.out.println(result.val);
    }
    public static TreeNode buildTree(int [] arr){
        if(arr.length==0){
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        int i=1;
        queue.offer(root);

        while(!queue.isEmpty() && i<arr.length){
            TreeNode curr = queue.poll();
            if(i<arr.length){
                curr.left = new TreeNode(arr[i++]);
                queue.offer(curr.left);
            }
            if(i<arr.length){
                curr.right = new TreeNode(arr[i++]);
                queue.offer(curr.right);
            }
        }
        return root;
    }

    public static TreeNode lowest(TreeNode root, TreeNode p, TreeNode q){
        if(p.val>q.val){
            return valid(root, q,p);
        }
        else{
            return valid(root,p,q);
        }
    }
    public static TreeNode valid(TreeNode root, TreeNode left, TreeNode right){
        if(root.val>right.val){
            return valid(root.left, left, right);
        }
        if(root.val<left.val){
            return valid(root.right, left, right);
        }
        return root;
    }

}