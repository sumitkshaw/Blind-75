
import java.util.Scanner;


class Kadane {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int result = kadanes(arr);
        System.out.println(result);
    }
    public static int kadanes(int []nums){
        int currSum = 0;
        int maxSum  = 0;
        int n = nums.length;

        for(int i=0; i<n;i++){
            currSum = Math.max(nums[i], currSum+nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
    

}
