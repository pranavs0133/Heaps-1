/*
Time Complexity - O(N log k)
Space Complexity - O(k)

Explanation :
Put the head of each non-empty list into a min-heap by node value.
Repeatedly pop the smallest node, attach it to the result, and push its next node if it exists.
Heap always contains the next best candidate from each list, so merging stays efficient.
*/



import java.util.PriorityQueue;

public class Problem2 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> {
            return a.val - b.val;
        });

        for(ListNode li : lists) {
            if(li != null) {
                pq.offer(li);
            }
            
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(!pq.isEmpty()) {
            ListNode temp = pq.poll();
            curr.next = temp;
            curr = curr.next;
            if(temp.next != null) {
                pq.offer(temp.next);
            }
        }

        return dummy.next;
    }
}
