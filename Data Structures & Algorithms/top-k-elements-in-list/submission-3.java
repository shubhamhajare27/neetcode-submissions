class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        if(nums.length == 2&& k==1){
            return new int[]{nums[0]};
        }
        
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a,b)->b.getValue()-a.getValue());

        int[] kArray = new int[k];

        for(int i=0;i<k;i++){
            kArray[i]=list.get(i).getKey();
        }

        return kArray;

    }
}
