class MinStack {
    Deque<Integer> st; 
    Deque<Integer> min; 
    public MinStack() {
       st = new ArrayDeque<>();
       min = new ArrayDeque<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(min.isEmpty()){
            min.push(val);
        }else if(val <= min.peek()){
            min.push(val);
        }
    }
    
    public void pop() {
        int value = st.pop();
        if(value == min.peek()){
            min.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        if(min.isEmpty()) return 0;
        return min.peek();
    }
}
