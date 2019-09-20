import java.util.*;

public class kstacks {
    private int[] da;
    private int[] na;
    private int[] ta;

    private int free;

    kstacks(int k, int cap) {
        free=0;
        da = new int[cap];
        na = new int[cap];
        ta = new int[k];

        for(int i=0;i<na.length-1;i++){
            na[i]=i+1;
        }
        na[na.length-1]=-1;

        Arrays.fill(ta, -1);
    }

    void push(int i, int val) {
        if(isfull()){
            System.out.println("stack is full");
            return;
        }else{
            //remove first from freee
                int temp=free;
                free= na[free];
                na[temp]=-1;
            //addfirst in stack
                da[temp]=val;
                na[temp]=ta[i];
                ta[i]=temp;
        }
        
    }

    void pop(int i) {
        if (isEmpty(i)) {
            System.out.println("stack is empty");
            return;
        }else{
            //remove first from stack
                int temp=ta[i];
                ta[i]= na[ta[i]];
                na[temp]=-1;
            //addfirst in free
                da[temp]=0;
                na[temp]=free;
                free=temp;
        }
    }

    int top(int i) {
        if (isEmpty(i)) {
            System.out.println("stack is empty");
            return -1;
        }else{
            return da[ta[i]];
        }
    }

    boolean isEmpty(int i) {
        return ta[i] == -1;
    }

    boolean isfull() {
        return free == -1;
    }
}