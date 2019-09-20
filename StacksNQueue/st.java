import java.util.*;

public class st {

    private int[] data;
    private int tos;
    private int tos1;
    private int tos2;

    st() {
        data = new int[5];
        tos1 = -1;
        tos2 = data.length;
    }

    void push(int val) {
        if (tos == data.length) {
            System.out.println("stack is full");
        }
        tos++;
        data[tos] = val;
    }

    int top() {
        if (tos == -1) {
            System.out.println("stack is empty");
            return -1;
        } else {
            return data[tos];
        }
    }

    void pop() {
        if (tos == -1) {
            System.out.println("stack is empty");
            return;
        } else {
            data[tos] = 0;
            tos--;
        }
    }

    int size() {
        return tos + 1;
    }

    void push1(int val) {
        if (iF()) {
            System.out.println("stack is full");
            return;
        } else {
            tos1++;
            data[tos1] = val;
        }
    }

    void push2(int val) {
        if (iF()) {
            System.out.println("stack is full");
            return;
        } else {
            tos2--;
            data[tos2] = val;
        }
    }

    void pop1() {
        if (ie1()) {
            System.out.println("stack 1 is empty");
            return;
        } else {
            data[tos1] = 0;
            tos1--;
        }
    }

    void pop2() {
        if (ie2()) {
            System.out.println("stack 2 is empty");
            return;
        } else {
            data[tos2] = 0;
            tos2++;
        }
    }

    int top1() {
        if (ie1()) {
            System.out.println("stack 1 is empty");
            return -1;
        } else {
            return data[tos1];
        }
    }

    int top2() {
        if (ie2()) {
            System.out.println("stack 2 is empty");
            return -1;
        } else {
            return data[tos2];
        }
    }

    boolean ie1() {
        return tos1 == -1;
    }

    boolean ie2() {
        return tos2 == data.length;
    }

    boolean iF() {
        return tos2 == tos1 + 1;
    }

    public static void main(String[] args) {
        st s = new st();
        // s.push(10);
        // s.push(20);
        // s.push(30);
        // s.push(40);
        // s.push(50);

        // while(s.size()>0){
        // int val= s.top();s.pop();
        // System.out.println(val+" ");
        // }

        s.push1(10);
        s.push1(20);
        s.push2(30);
        s.push2(40);
        s.push2(50);

        int val1 = s.top1();
        s.pop1();
        System.out.println(val1);
        int val2 = s.top2();
        s.pop2();
        System.out.println(val2);
    }
}