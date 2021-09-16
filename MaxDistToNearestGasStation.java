public class MaxDistToNearestGasStation {
    public static double minmaxGasDist(int[] stations, int K) {
        double l = 0, r = stations[stations.length - 1] - stations[0];
        while (l + 1e-6 < r) {
            double d = l + (r - l) / 2;  
            int cnt = 0;
            for (int i = 0; i < stations.length - 1; i++) {
                cnt += Math.ceil((stations[i + 1] - stations[i]) / d) - 1;// 10 / 3, ceil 4
            }           
            if (cnt <= K) { // cnt can be larger, i.e., d can be smaller
                r = d;
            }
            else {
                l = d;
            }
        }
        return l;
    }
    
    public static void main(String[] args) throws Exception{
        int[] stations = {1,2,3,4,5,6,7,8,9,10};
        int  k = 9;
        // int target = 9;
        System.out.println("The maximum distance between adjacent gas stations is " + minmaxGasDist(stations, k));

    }
}
