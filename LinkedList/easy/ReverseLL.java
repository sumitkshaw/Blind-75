import java.util.Scanner;

public class ReverseLL {
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
        int [] arr = new int [n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Node head = arrtoLL(arr);
        Node curr = reverse(head);
        Node temp = curr;

        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public static Node arrtoLL(int [] arr){
        if(arr.length == 0){
            return null;
        }
        Node head = new Node(arr[0]);
        Node temp = head;

        for(int i=1;i<arr.length;i++){
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = temp.next;
        }
        return head;
    }
    public static Node reverse(Node head){
        if(head == null){
            return null;
        }
        Node prev = null;
        Node curr = head;
        Node nextCurr = head;

        while(curr!=null){
            nextCurr = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextCurr;
        }
        return prev;
    }
}