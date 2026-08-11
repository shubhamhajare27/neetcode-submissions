class Solution {
    public int lengthOfLongestSubstring(String s) {
      int l=0;
      int maxLen=0;
      Set<Character> mySet= new HashSet<>();
      for(int r=0;r<s.length();r++){
        while(mySet.contains(s.charAt(r))){
            mySet.remove(s.charAt(l));
            l++;
        }
        mySet.add(s.charAt(r));
        maxLen=Math.max(maxLen,r-l+1);
      }
      return maxLen;
    }
}