import java.util.*;

public class petrolpumps {
    public static class PPhelper {
        int oil;
        int dis;

        public PPhelper(int oil, int dis) {
            this.oil = oil;
            this.dis = dis;
        }
    }

    public static int validTour(PPhelper[] pa) {
        int i = 0;
        int j = 0;
        int spare = 0;

        while (true) {
            if (spare + pa[j].oil >= pa[j].dis) {
                spare = spare + pa[j].oil - pa[j].dis;
                j = (j + 1) % pa.length;
                if (j == i) {
                    return j;
                }
            } else {
                if (j < i) {
                    return -1;
                } else {
                    spare = 0;
                    i = (j + 1) % pa.length;
                    j = i;
                }
            }
        }
    }

    public static void main(String[] args) {
        PPhelper[] arr = { new PPhelper(6, 5), new PPhelper(4, 5), new PPhelper(8, 2), new PPhelper(2, 4),
                new PPhelper(3, 4), new PPhelper(3, 6), new PPhelper(1, 2), new PPhelper(7, 7), new PPhelper(1, 1) };
        System.out.println(validTour(arr));
    }
}