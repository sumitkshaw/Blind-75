import java.util.*;

public class LevelOrder {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
            left =null;
            right = null;
        }
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        TreeNode root = buildTree(arr);
        List<List<Integer>> result = level(root);

        for(List<Integer> list:result){
            for(int num:list){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
    public static TreeNode buildTree(int [] arr){
        if(arr.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while(i<arr.length){
            TreeNode current = queue.poll();

            if(i<arr.length){
                current.left = new TreeNode(arr[i++]);
                queue.offer(current.left);
            }
            if(i<arr.length){
                current.right = new TreeNode(arr[i++]);
                queue.offer(current.right);
            }
        }
        return root;
    }
    public static List<List<Integer>> level(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();

        if(root==null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currlevel = new ArrayList<>();

            for(int i=0;i<levelSize;i++){
                TreeNode curr = queue.poll();
                currlevel.add(curr.val);
                if(curr.left!=null){
                    queue.offer(curr.left);
                }
                if(curr.right!=null){
                    queue.offer(curr.right);
                }
            }
            result.add(currlevel);
            
        }
        return result;
    }
}
