class Solution {
    public boolean isPalindrome(String str) {
        int left=0;
        int right=str.length()-1;

        while(left<=right){
            if((str.charAt(left)>='A' && str.charAt(left)<='Z') ||
               (str.charAt(left)>='a' && str.charAt(left)<='z') ||
               (str.charAt(left)>='0' && str.charAt(left)<='9'))
               {
                    if((str.charAt(right)>='A' && str.charAt(right)<='Z') ||
                       (str.charAt(right)>='a' && str.charAt(right)<='z') ||
                       (str.charAt(right)>='0' && str.charAt(right)<='9'))
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
}
