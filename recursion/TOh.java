public class TOh{
    public static void main(String args[]) {
        TOH(3,"A","B","C");
        // TOHmodify(3, "A", "B", "C");
    }

    public static void TOH(int n,String s, String d, String h) {
        if(n==0) {
            return ;
        }
        TOH(n-1,s,h,d);
        System.out.println("Move "+n+"th block from "+s+" to "+d);
        TOH(n-1,h,d,s);
        /*
        Move 1th block from A to B
        Move 2th block from A to C
        Move 1th block from B to C
        Move 3th block from A to B
        Move 1th block from C to A
        Move 2th block from C to B
        Move 1th block from A to B
        */
    }

    public static void TOHmodify(int n,String s, String d, String h) {
        if(n==0) {
            return ;
        }
        System.out.println("PRE"+s+d+h+n);
        TOHmodify(n-1,s,h,d);
        System.out.println("IN"+s+d+h+n);
        TOHmodify(n-1,h,d,s);
        System.out.println("POST"+s+d+h+n);
    /*
    PREABC3
    PREACB2
    PREABC1
    INABC1
    POSTABC1
    INACB2
    PREBCA1
    INBCA1
    POSTBCA1
    POSTACB2
    INABC3
    PRECBA2
    PRECAB1
    INCAB1
    POSTCAB1
    INCBA2
    PREABC1
    INABC1
    POSTABC1
    POSTCBA2
    POSTABC3*/
    }

}

