
import java.util.Scanner;

public class MinRotated {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];

        for(int i=0; i<n;i++){
            arr[i] = sc.nextInt();
        }
        int result = rotated(arr);
        System.out.println(result);
    }
    public static int rotated(int [] arr){
        int  l =0;
        int r = arr.length-1;

        while(l<=r){
            if(arr[l]<=arr[r]){
                return arr[l];
            }
            int mid = l + (r-l)/2;
            if(arr[mid]>=arr[l]){
                l =  mid+1;
            }
            else{
                r = mid;
            }
        }
        return arr[l];
    }
}
