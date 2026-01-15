/*
Time Complexity - O(nlog(n-k))
Space Complexity - O(n-k)

Explanation :
We use a max-heap to keep track of the largest elements.
When the heap size exceeds n − k, we remove the largest element.
The smallest removed element among these is the kth largest overall.
*/


import java.util.PriorityQueue;

public class Problem1 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            return b - a;
        });

        int minimum = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++) {
            pq.offer(nums[i]);
            if(pq.size() > (n-k)) {
                int temp = pq.poll();
                if(temp < minimum) {
                    minimum = temp;
                }
            }
        }

        return minimum;
    }
}
