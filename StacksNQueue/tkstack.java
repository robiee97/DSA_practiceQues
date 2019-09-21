import java.util.*;

public class tkstack {
    public static void main(String[] args) {
        kstacks ts = new kstacks(4, 12);
        ts.push(1, 10);
        int val = ts.top(1);
        ts.pop(1);
        System.out.println(val);
    }
}