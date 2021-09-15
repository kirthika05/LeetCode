import java.util.Random;


public class FirstBadVersion {

    public static boolean isBadVersion(int n){
        Random rd = new Random(); // creating Random object
        return rd.nextBoolean();
    }
    
    public static int firstBadVersion(int n) {
        int lo = 1, hi = n;
        while (lo < hi) {
            int med = lo + (hi -  lo)/2;
            if (isBadVersion(med)) {
                hi = med;
            } else {
                lo = med + 1;
            }
        }
        return lo;
    }
    
    public static void main(String[] args) throws Exception{

        int n = 5;
        // int target = 9;
        System.out.println("The first bad version is " + firstBadVersion(n));

    }


}
