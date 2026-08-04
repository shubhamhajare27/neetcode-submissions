class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod=1;
        int zeroCount=0;
        for(int i=0;i<nums.length;i++){
                if(nums[i]==0){
                    zeroCount++;
                }
                else{
                    prod=prod*nums[i];
                }
            
        }

        if(zeroCount>1){
            return new int[nums.length];
        }

        int []newArr = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(zeroCount>0){
                if(nums[i]==0){
                    newArr[i]=prod;
                }else{
                    newArr[i]=0;
                }
            }
            else{
                newArr[i]=prod/nums[i];
            }
        }
        return newArr;
    }
}  
