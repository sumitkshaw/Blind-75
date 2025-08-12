
import java.util.Scanner;



public class MergeTwo {
    static class Node{
        int data;
        Node next;
        Node(int x){
            data = x;
            next = null;
        }
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr1 = new int [n];

        for(int i=0;i<n;i++){
            arr1[i] = sc.nextInt();
        }
        int n1 = sc.nextInt();
        int [] arr2 = new int [n1];

        for(int i=0;i<n1;i++){
            arr2[i] = sc.nextInt();
        }
        sc.close();

        Node head1 = arrtoLL(arr1);
        Node head2 = arrtoLL(arr2);
        Node result = merge(head1,head2);

        while(result!=null){
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
    public static Node arrtoLL(int []arr){
        if(arr.length == 0){
            return null;
        }
        Node newnode = new Node(arr[0]);
        Node temp = newnode;

        for(int i=1;i<arr.length;i++){
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return newnode;
    }
    public static Node merge(Node head1, Node head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }

        if(head1!=null && head2!=null){
            if(head1.data < head2.data){
                head1.next = merge(head1.next, head2);
                return head1;
            }
            else{
                head2.next = merge(head1, head2.next);
                return head2;
            }
        }
        return null;
    }
    
}
