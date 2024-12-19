package LinkedLists;

import java.util.HashSet;

//Remove duplicates from an unsorted list
public class RemoveDups {
    /*
     Time complexity: O(n)
     Space complexity: O(n)
     Create a hashset to store already seen values and add first node
     set prev to first node
     set current to first's nodes next
     while current is not null
        if current is already seen
            set next of prev to current.next
        else
            add current to hashset
            prev = prev.next
        current = current.next
     */
    public static void bufferApproach(LinkedLists.List<Integer> l){
        if(l != null && !l.isEmpty()) {
            HashSet<Integer> alreadySeen = new HashSet<>();
            alreadySeen.add(l.getFirstNode().data);

            ListNode<Integer> prev = l.getFirstNode();
            ListNode<Integer> current = prev.getNext();

            while(current != null){
                if(alreadySeen.contains(current.data)){
                    prev.nextNode = current.getNext();
                }
                else{
                    alreadySeen.add(current.data);
                    prev = current;
                }
                current = current.getNext();
            }
        }
    }

    /*
    Time complexity: O(n^2)
    Space complexity: O(1)
    set pivot to head
    while pivot is not null
        set prev to pivot
        set current to prev.next
        while current is not null
            if current is same as pivot
                set next of prev to current.next //delete current
            else
                prev = current
            current = current.next
        pivot = pivot.next
     */
    public static void inPlaceApproach(LinkedLists.List<Integer> l){
        if(l != null && !l.isEmpty()) {
            ListNode<Integer> pivot = l.getFirstNode();
            while(pivot != null){
                ListNode<Integer> prev = pivot;
                ListNode<Integer> current = prev.getNext();

                while(current != null){
                    if(current.data.equals(pivot.data)){
                        prev.nextNode = current.nextNode;
                    }
                    else{
                        prev = current;
                    }
                    current = current.nextNode;
                }
                pivot = pivot.nextNode;
            }
        }
    }
}
