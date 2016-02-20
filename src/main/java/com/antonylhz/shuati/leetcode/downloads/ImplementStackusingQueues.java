class MyStack {

    LinkedList<Integer> list1, list2, list_cur;

    public MyStack() {
        list1 = new LinkedList<Integer>();
        list2 = new LinkedList<Integer>();
        list_cur = list1;
    }

    // Push element x onto stack.
    public void push(int x) {
        list_cur.add(new Integer(x));
    }

    // Removes the element on top of the stack.
    public void pop() {
        LinkedList<Integer> list_other = (list_cur == list1 ? list2 : list1);
        Integer element = list_cur.poll();
        while (!list_cur.isEmpty()) {
            list_other.add(element);
            element = list_cur.poll();
        }
        list_cur = list_other;
    }

    // Get the top element.
    public int top() {
        LinkedList<Integer> list_other = (list_cur == list1 ? list2 : list1);
        Integer element = 0;
        while (!list_cur.isEmpty()) {
            element = list_cur.poll();
            list_other.add(element);
        }
        list_cur = list_other;
        return element;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return list_cur.isEmpty();
    }
}
