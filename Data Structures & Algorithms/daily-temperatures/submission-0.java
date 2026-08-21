class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int res[]=new int[temperatures.length];
        Stack<Integer> st = new Stack<Integer>();
        st.push(0);
        for(int i=1;i<temperatures.length;i++)
        {
            while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i]){
                int peek=st.peek();
                int pop=st.pop();
                res[peek]=i-pop;
            }
            st.push(i);
        }
        return res;
        
    }
}
