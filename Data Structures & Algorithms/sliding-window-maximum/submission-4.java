class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       int n=nums.length;

       //Step1: Initialize the deque
       //store indices
       Deque<Integer> deque=new ArrayDeque<Integer>();
       int []result= new int[n-k+1];

       //setup deque for first K elements
       for(int i=0;i<k;i++){
        //remove smaller elements from back
        while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]){
            deque.pollLast();
        }
        deque.offerLast(i);
       }

        //front of deque is the max of first window
        result[0]=nums[deque.peekFirst()];

        //process the remaining result
        for(int i=k;i<n;i++){
            //Remove elements that has slid out of window
            if(deque.peekFirst()<=i-k){
                deque.pollFirst();
            }
            //Remove all elements smaller than incoming element
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }

            //Add current element's index
            deque.offerLast(i);

            //The front is the always the max out of the window
            result[i-k+1]=nums[deque.peekFirst()];
        }
        return result;
    }
}
