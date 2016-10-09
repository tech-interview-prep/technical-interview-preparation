class ImplementStackW2Queues {
    
    LinkedList<Integer>q1 = new LinkedList<Integer>();
    LinkedList<Integer>q2 = new LinkedList<Integer>();

    
    // Push element x onto stack.
    public void push(int x) {
        if(empty()){
            q1.offer(x); //push elements to empty q1
        } else { //look at diagram for understanding
            if(q1.size() > 0){
                q2.offer(x); 
                int size = q1.size();
                while(size > 0){
                    q2.offer(q1.poll()); 
                    size--;
                }
            }
            else if(q2.size() > 0){
                q1.offer(x);
                int size = q2.size();
                while(size > 0){
                    q1.offer(q2.poll());
                    size--;
            }
        }
    }
}

    // Removes the element on top of the stack.
    public void pop() {
        if(q1.size() > 0){
            q1.poll();
        } else if(q2.size() > 0){
            q2.poll();
        }
        
    }

    // Get the top element.
    public int top() {
        if(q1.size() > 0){
            return q1.peek();
        } else if(q2.size() > 0){
            return q2.peek();
        }
        return 0;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        if(q1.isEmpty() && q2.isEmpty()){
            return true;
        }
        return false;
    }
}