
import java.util.Scanner;


public class detectloop{
    static class Node{
        int data;
        Node next;
        Node(int x){
            data = x;
            next = null;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] =new int [n];
        for(int i=0; i<n;i++){
            arr[i]= sc.nextInt();
        }
        Node head = arrtoLL(arr);
        boolean result = detect(head);
        System.out.println(result);
    }
    public static Node arrtoLL(int [] arr){
        if(arr.length ==0){
            return null;
        }
        Node newNode = new Node(arr[0]);

        for(int i=1;i<arr.length;i++){
            newNode.next = new Node(arr[i]);
            newNode = newNode.next;
        }

        return newNode;
    }
    public static boolean detect(Node head){
        if(head == null){
            return false;
        }
        Node fast = head;
        Node slow = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}