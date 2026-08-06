class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            seen.add(nums[i]);
        }
        int maxCount=0;
        for(int i=0;i<nums.length;i++){
            if(!seen.contains(nums[i]-1)){ //if there is no previous elemnt to it then its the first one in sequence
                //keep checking its +1 and keep counting it
                int seq=nums[i];
                int counter=1;
                while(seen.contains(seq+1)){
                    counter++;
                    seq++;
                }
                if(counter>maxCount){
                    maxCount=counter;
                }
            }
        }
        return maxCount;
    }
}
