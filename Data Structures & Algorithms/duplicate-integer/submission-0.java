class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> intSet = new HashSet<Integer>();
        for(Integer num:nums){
            if(intSet.contains(num)){
                return true;
            }else{
                intSet.add(num);
            }
        }
        return false;
    }
}