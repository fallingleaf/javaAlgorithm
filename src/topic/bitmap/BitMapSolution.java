package bitmap;
import java.util.*;


public class BitMapSolution {

    /*
        Max value of IP is 2^32 - 1
        Need 2^32 bit => 2^28 bytes
    */
    public int countUniqueIp(int[] ips) {
        int numBytes = (int) Math.pow(2, 28);
        byte[] bytes = new byte[numBytes];

        int ans = 0;

        for(int ip: ips) {
            int nthByte = ip / 8;
            int nthBit = ip % 8;
            if((bytes[nthByte] & 1 << nthBit) == 0) {
                bytes[nthByte] |=  (byte) 1 << nthBit;
                ans ++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        BitMapSolution bm = new BitMapSolution();
        int ans = bm.countUniqueIp(new int[] {1000, 100, 1, 10, 99, 99, 1, 100, 256, 255, 126});
        System.out.println("Number of unique IP: " + ans);
    }
}
