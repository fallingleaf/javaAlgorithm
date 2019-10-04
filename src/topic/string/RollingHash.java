package string;
import java.util.*;


// hash = a + a1*x + a2*x^2 + .... + an*x^n modulo P where P is prime number
//
public class RollingHash {
    int base = 227;
    int prime = 1000005; //1000000007;


    private int hash(String s) {
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            ans = (base * ans + s.charAt(i)) % prime;
        }
        return ans;
    }

    public int search(String s, String p) {
        int n = s.length();
        int m = p.length();

        if(n < m) {
            return -1;
        }

        int sHash = hash(s.substring(0, m));
        int pHash = hash(p);

        if(sHash == pHash) {
            return 0;
        }

        // base^m value
        int power = 1;
        for(int i = 0; i < m; i++) {
            power = (base * power) % prime;
        }

        for(int i = 0; i < n - m; i++) {
            // Rehash s value, remove char at i and add top char i + m
            // total * x + new_char - x^n * oldchar
            sHash = (sHash * base + s.charAt(i + m)) % prime;
            sHash -= power * s.charAt(i) % prime;

            if(sHash < 0) {
                sHash += prime;
            }

            if(sHash == pHash) {
                return i+1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        RollingHash rh = new RollingHash();
        int res = rh.search("i am supermanz in the movie!", "man");
        System.out.println("Search result..." + res);
    }
}
