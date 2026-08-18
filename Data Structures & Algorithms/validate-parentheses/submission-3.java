class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        if(s.length()<=1)
        {
            return false;
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='{' || s.charAt(i)=='(' || s.charAt(i)=='['){
                st.push(s.charAt(i));
            }
            else if(s.charAt(i)=='}' || s.charAt(i)==')' || s.charAt(i)==']'){
                if((!st.isEmpty() && s.charAt(i)=='}' && st.peek()=='{') || 
                   (!st.isEmpty() && s.charAt(i)==')' && st.peek()=='(') || 
                   (!st.isEmpty() && s.charAt(i)==']' && st.peek()=='[')){
                        st.pop();
                   }
                else{
                    return false;
                }
            }
        }
        if(st.isEmpty()){
            return true;
        }
        return false;
        
    }
}
