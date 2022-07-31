//Question 1 :

package Week1;

import Week1.SingelyLinkedList.Node;

public class kLinkedList {

    SingelyLinkedList[] arr; // The linked list user inputs are all stored in this array. 

    kLinkedList(SingelyLinkedList[] arr) {
        // this is a constructor 
        this.arr = arr;
    }

    SingelyLinkedList Merges() {
        // This method loops through each linked list and combines them into a single list. 
        // THis is a link list.
        
        SingelyLinkedList FinalOutputList = arr[0]; // Set the first linked list as the first value for the final output list. 
        SingelyLinkedList mergedList; // The two combined linked lists are kept in this linked list. 
        for (int i = 1; i < arr.length; i++) {
            // looping through each linked list in turn. 
            mergedList = ToMerge(FinalOutputList, arr[i]); // Combine the final output list and the current linked list. 
            FinalOutputList = mergedList; // Add the merged linked list to the final output list. 
        }
        return FinalOutputList; // Send back the complete output list. 
    }

    SingelyLinkedList ToMerge(SingelyLinkedList a, SingelyLinkedList b) {
        // This function merges two linked lists.
        SingelyLinkedList result = new SingelyLinkedList(); // Initialize the result linked list.
        Node first_itterator = a.head; // Initialize the first itterator with the first linked list.
        Node second_itterator = b.head; // Initialize the second itterator with the second linked list.
        while (first_itterator != null) {
            // itterate through the first linked list.
            result.addNode(first_itterator.data); // Add the most recent data to the linked result list. 
            first_itterator = first_itterator.next; // Update the first itterator.
        }
        while (second_itterator != null) {
            // loop through the second linked list.
            result.addNode(second_itterator.data); // Add the most recent data to the linked result list. 
            second_itterator = second_itterator.next; // Update the second itterator.
        }
        return sortLinkedList(result); // Return back the sorted result linked list.
    }

    SingelyLinkedList sortLinkedList(SingelyLinkedList list) {
        // Node current will point to head
        Node current = list.head, index = null; // Initialize the current and index pointers.
        int temp; // Initialize the temp variable.

        if (list.head == null) {
            return null; // Return null if the linked list is empty. 
        } else {
            while (current != null) {
                // Node index will point to node next to current
                index = current.next;

                while (index != null) {
                    // If current node's data is greater than index's node data, swap the data
                    // between them
                    if (current.data > index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
        return list; // Return the sorted linked list.
    }

    void Median() {

        int median = (Merges().getSize()+1) / 2; 
        // Get the median of the linked list.
        System.out.println("The Median is : " + Merges().getDataAtAnyPos(median)); // Print the median.
    }

    public static void main(String[] args) {
        //creating 3 linked lists
        SingelyLinkedList[] arr = new SingelyLinkedList[3];
        SingelyLinkedList L1 = new SingelyLinkedList();
        SingelyLinkedList L2 = new SingelyLinkedList();
        SingelyLinkedList L3 = new SingelyLinkedList();

        //adding nodes to the linked lists
        L1.addNode(2);
        L1.addNode(4);
        L1.addNode(7);
        L1.addNode(5);
        L1.addNode(10);
        L2.addNode(3);
        L2.addNode(2);
        L2.addNode(7);
        L2.addNode(9);
        L3.addNode(12);
        L3.addNode(5);
        L3.addNode(6);
        L3.addNode(9);
        //passing the linked lists as arrays
        arr[0] = L1;
        arr[1] = L2;
        arr[2] = L3;
        kLinkedList w = new kLinkedList(arr);
        //displaying the output
        w.Median();
        
    }
}

