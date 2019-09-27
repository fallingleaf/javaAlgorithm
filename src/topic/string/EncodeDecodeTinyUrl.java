package string;


// https://leetcode.com/problems/encode-and-decode-tinyurl/submissions/
public class EncodeDecodeTinyUrl {

    // Encodes a URL to a shortened URL.
    private HashMap<String, String> map = new HashMap<>();
    Random r = new Random();

    public String encode(String longUrl) {
        String key = longUrl.hashCode() + "" + r.nextInt(1000);
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String code = shortUrl.replace("http://tinyurl.com/", "");
        return map.get(code);
    }
}
