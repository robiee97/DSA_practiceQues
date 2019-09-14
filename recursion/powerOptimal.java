public class powerOptimal{
    public static void main(String args[]){

        System.out.println(poweroptimal(2,5));
        System.out.println(powerBekar(2,5));
    }

    public static int poweroptimal(int a, int b){
    if(b==0){
        return 1;
    }
        int ans=poweroptimal(a,b/2);
    ans*=ans;
    if(b%2!=0){
        ans=a*ans;
    }
    return ans;
    }

    public static int powerBekar(int a, int b){
        if(b==0){
            return 1;
        }
        int ans =a* powerBekar(a, b-1) ;
        return ans;
    }
}