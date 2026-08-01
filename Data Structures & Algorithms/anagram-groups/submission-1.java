class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> freqIndexMap = new HashMap<String,List<String>>();

        for(int i=0;i<strs.length;i++){

            //create array for characters
            int arr[] = new int[26];

            //create frequency array for each string
            for(int j=0;j<strs[i].length();j++){
                arr[strs[i].charAt(j) - 'a']++;
            }

            String strArrKey = Arrays.toString(arr);
            freqIndexMap.putIfAbsent(strArrKey,new ArrayList<String>());
            freqIndexMap.get(strArrKey).add(strs[i]);
        }
        return new ArrayList<>(freqIndexMap.values());
    }
}
