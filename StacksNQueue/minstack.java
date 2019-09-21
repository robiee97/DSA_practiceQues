import java.util.*;

public class minstack {
    Stack<Integer> st;
    private int min;

    minstack() {
        st = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }

    void push(int val) {
        if (st.size() == 0) {
            st.push(val);
            min = val;
        } else if (val >= min) {
            st.push(val);
            // min=val;
        } else {
            st.push(val + (val - min));
            min = val;
        }
    }

    void pop() {
        if (st.size() == 0) {
            System.out.println("stack is empty");
            return;
        } else if (st.peek() >= min) {
            st.pop();
        } else {
            min = 2 * min - st.peek();
            st.pop();
        }
    }

    int top() {
        if (st.size() == 0) {
            System.out.println("stack is empty");
            return -1;
        } else if (st.peek() >= min) {
            return st.peek();
        } else {
            return min;
        }
    }

    int min() {
        if (st.size() > 0) {
            return min;
        } else {
            System.out.println("stack is empty");
            return -1;
        }
    }

    int size() {
        return st.size();
    }

    public static void main(String[] args) {
        minstack ms = new minstack();
        ms.push(10);
        ms.push(2);
        ms.push(18);
        ms.push(1);
        ms.push(56);
        while (ms.size() > 0) {
            int minval= ms.min();
            int val = ms.top();ms.pop();
            System.out.println(val + " " + minval);
        }
    }

}