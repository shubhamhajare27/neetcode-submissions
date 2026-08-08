class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> mainList = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            int left = i+1;
            int right = nums.length-1;
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            while(left<right){
                if(nums[i]+nums[left]+nums[right]==0){
                    List<Integer> smallList= new ArrayList<Integer>();
                    smallList.add(nums[i]);
                    smallList.add(nums[left]);
                    smallList.add(nums[right]);
                    mainList.add(smallList);
                    left++;
                    right--;
                    while(left<right && nums[left]==nums[left-1]){
                        left++;
                    }
                    while(left<right && nums[right]==nums[right+1]){
                        right--;
                    }
                }
                else if(nums[i]+nums[left]+nums[right]>0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return mainList;
        
    }
}
