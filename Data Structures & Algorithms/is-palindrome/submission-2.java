class Solution {
    public boolean isPalindrome(String str) {
        int left=0;
        int right=str.length()-1;

        while(left<=right){
            if(isAlphanumeric(str.charAt(left)))
               {
                    if(isAlphanumeric(str.charAt(right)))
                       {
       if(Character.toLowerCase(str.charAt(left)) !=
        Character.toLowerCase(str.charAt(right)) ){
            return false;
         }else{
            left++;
            right--;
         }
                       }
                       else
                       {
                            right--;
                       }
               }
               else
               {
                    left++;
               }
        }
        return true;
    }
    public boolean isAlphanumeric(char c){
        return ((c>='A' && c<='Z') ||
               (c>='a' && c<='z') ||
               (c>='0' && c<='9'));
    }
}
