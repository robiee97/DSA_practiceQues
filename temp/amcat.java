import java.util.*;

public class amcat {
    public static void main(String args[]) {

        // Scanner s= new Scanner(System.in);
        // String textInput = "cat batman cat latte batman cat batman cat batman cat";
        // countWords(textInput);
        // needle(11456, 1);
// 121034
        int[] arr={1,1,1,2,2,0};
        memoriseMe(arr, 1);
        memoriseMe(arr, 2);
        memoriseMe(arr, 1);
        memoriseMe(arr, 0);
        memoriseMe(arr, 3);
        memoriseMe(arr, 4);
    }

    public static void countWords(String textString) {
        ArrayList<String> arr = new ArrayList<>();

        int ptr = 0;
        for (int i = 0; i < textString.length(); i++) {
            if (textString.charAt(i) == ' ') {
                String str = textString.substring(ptr, i);
                arr.add(str);
                ptr = i + 1;
            }
        }
        printRepeat(arr);
    }

    public static void printRepeat(ArrayList<String> arr) {
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i+1; j < arr.size(); j++) {
               String str1= arr.get(i);
               String str2= arr.get(j);
                if (str1.equals(str2)) {
                    arr.remove(j);
                }
                // else{
                //     arr.remove(i);
                // }
            }
        }
        System.out.print(arr);
    }

    public static void needle(int n,int ele){
       ArrayList<Integer> arr= new ArrayList<>();
        while(n>0){
            int r=n%10;
            if(r!=ele){
                arr.add(r);
            }
            n=n/10;
        }
        for(int i=arr.size()-1;i>=0;i--){
            System.out.print(arr.get(i));
        }
    }
    
    public static void memoriseMe(int[] arr,int query){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int val:arr){
            if(map.containsKey(val)){
                map.put(val, map.get(val)+1);
            }else{
                map.put(val, 1);
            }
        }
        if(map.containsKey(query)){
            System.out.println(map.get(query));
        }else{
            System.out.println("NOT PRESENT");
        }
    }
}