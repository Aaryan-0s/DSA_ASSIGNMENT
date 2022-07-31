package Week1;

//singly linked list implementation
public class SingelyLinkedList {

    public static class Node{
        Node next;
        int data;
        Node(int data){
            this.data= data;
            this.next= null;
        }
    }
    Node head= null;
    Node tail= null;
    int size = 0;
    //function to addnode 
    public void addNode(int data){
        size++;
        Node newnode = new Node(data);
        if(head == null){
            head = tail= newnode;
        }
        else{
            tail.next = newnode;
            tail = newnode;
        }

    }
    //funtion to getsize
    public int getSize(){
        return size;
    }
    //function to check if node is empty
    boolean isEmpty() {
        return head == null;
    }
    //function to get data at any postiton 
    public int getDataAtAnyPos(int pos){
        Node current = head;
        for(int i=1; i<=pos; i++){
            current = current.next;
        }
        return current.data;
    }

}
