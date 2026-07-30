class Solution {
    public int[] twoSum(int[] nums, int target) {
        // if size is 2, and as per condition pair will always exist so return 0,1
        if(nums.length==2){
            return new int[]{0,1};
        }

        Map<Integer,Integer> indexValueMap = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(indexValueMap.containsKey(target-nums[i])){
                return new int[]{indexValueMap.get(target-nums[i]),i};
            }else{
                indexValueMap.put(nums[i],i);
            }
        }
        return new int[]{};
    }
}
