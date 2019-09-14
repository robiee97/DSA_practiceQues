import java.util.*;

public class string1{

public static void main(String args[]){
// duplicate();


// String str="abcd";
// SSfun(str);

}


public static void duplicate(){

    StringBuilder sb= new StringBuilder();    
    String str="AAABCDDDEFGH";

    for(int i=1;i<str.length()-1;i++){
        char pch= str.charAt(i-1);
        char ch=str.charAt(i); 
        if(pch!=ch){
            sb.append(pch);
            }
        }
        char lch=str.charAt(str.length()-1);
        sb.append(lch);
        System.out.println(sb.toString());
    }


public static void SSfun(String str){
    for(int i=0;i<str.length();i++){
        for(int j=i+1;j<=str.length();j++){
            System.out.println(str.substring(i,j));
        }
    }
    }
}
