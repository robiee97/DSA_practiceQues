public class oops {
    public static void main(String args[]) {

        student s= new student();
        student s1= new student(); 
        s.name="Robin";
        s.roll_no= 10;
        s1.name="sachin tendulkar";
        s1.roll_no= 9;

        System.out.println(s.name+" "+s.roll_no);
        System.out.println(s1.name+" "+s1.roll_no);
    }
    public static class student{
        int roll_no;
        String name;
    }
}