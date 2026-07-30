class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer>charCountMap=new HashMap<Character,Integer>();

        if(s.length() != t.length()){
            return false;
        }

        for(int i=0;i<s.length();i++){
            charCountMap.put(s.charAt(i),charCountMap.getOrDefault(s.charAt(i),0)+1);
        }

        for(int j=0;j<t.length();j++){
            if(!charCountMap.containsKey(t.charAt(j))){
                return false;
            }
            else if(charCountMap.get(t.charAt(j)) == 0){
                return false;
            }
            else{
                charCountMap.replace(t.charAt(j),charCountMap.get(t.charAt(j))-1);
            }
        }
        return true;
    }
}
