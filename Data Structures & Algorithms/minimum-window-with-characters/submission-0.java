class Solution {
    public String minWindow(String s, String t) {

        if(t.length()>s.length()){
            return "";
        }

        Map<Character,Integer> need= new HashMap<Character,Integer>();
        Map<Character,Integer> window = new HashMap<Character,Integer>();

        for(char c:t.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }

        int required = need.size();
        int formed=0;
        int l=0;
        int minLength=Integer.MAX_VALUE;
        int minLeft=0;
        int minRight=0;

        for(int r=0;r<s.length();r++){
            char c = s.charAt(r);
            window.put(c,window.getOrDefault(c,0)+1);

            if(need.containsKey(c) && window.get(c).intValue()==need.get(c).intValue()){
                formed++;
            }

            while(formed==required){
                if(r-l+1<minLength){
                    minLength=r-l+1;
                    minLeft=l;
                    minRight=r;
                }
                
                char leftChar = s.charAt(l);

                window.put(leftChar,window.get(leftChar)-1);

                if(need.containsKey(leftChar) && window.get(leftChar)<need.get(leftChar)){
                    formed--;
                }

                l++;
            }
        }
        if(minLength==Integer.MAX_VALUE){
            return "";
        }
        return s.substring(minLeft,minRight+1);
    }
}
