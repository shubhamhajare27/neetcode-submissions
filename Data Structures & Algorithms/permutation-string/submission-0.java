class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int []s1Count=new int[26];
        for(int i=0;i<s1.length();i++){
            s1Count[s1.charAt(i)-'a']++;
        }
        int []s2Count=new int[26];
        int left=0;
        for(int right=0;right<s2.length();right++){
            s2Count[s2.charAt(right)-'a']++;

            if(right-left+1>s1.length()){
                s2Count[s2.charAt(left)-'a']--;
                left++;
            }

            if(Arrays.equals(s1Count,s2Count)){
                return true;
            }
        }
        return false;
    }
}
