class MinStack {

    Stack<Integer> st;
     Deque<Integer> deque;
    public MinStack() {
        st =  new Stack<Integer>();
        deque = new ArrayDeque<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(!deque.isEmpty() && val<=deque.peekFirst()){
            deque.addFirst(val);
        }else{
            deque.add(val);
        }
    }
    
    public void pop() {
        if(!st.isEmpty()){
            int peek=st.peek();
            st.pop();
            deque.removeLastOccurrence(peek);
        }
    }
    
    public int top() {
        int peek=0;
        if(!st.isEmpty()){
          peek=st.peek();
        }
        return peek;
    }
    
    public int getMin() {
        return deque.peekFirst();
    }
}
