package leetcode;

import java.util.HashMap;

/*
TinyURL is a URL shortening service where you enter a URL such as
https://leetcode.com/problems/design-tinyurl and it returns a short URL such as
http://tinyurl.com/4e9iAk.
Design a class to encode a URL and decode a tiny URL.
 */
public class EncodeDecodeTinyUrl {

    private static final String TINY_URL = "http://tinyurl.com/";
    private static HashMap<Integer, String> encodedMap = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl)
    {
        int hashCode = longUrl.hashCode();
        encodedMap.put(hashCode, longUrl);

        StringBuilder tinyUrl = new StringBuilder(TINY_URL);
        tinyUrl.append(String.valueOf(hashCode));
        return tinyUrl.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl)
    {
        shortUrl = shortUrl.replace(TINY_URL, "");
        String decodedUrl = encodedMap.get(Integer.valueOf(shortUrl));
        return decodedUrl;
    }

    public static void main(String[] args)
    {
        EncodeDecodeTinyUrl encodeDecodeTinyUrl = new EncodeDecodeTinyUrl();

//        String originalUrl = "https://leetcode.com/problems/design-tinyurl";
        String originalUrl = "http://www.leetcode.com/faq/?id=10";

        String encodedUrl = encodeDecodeTinyUrl.encode(originalUrl);
        String decodedUrl = encodeDecodeTinyUrl.decode(encodedUrl);

        System.out.println("originalUrl : " + originalUrl);
        System.out.println("encodedUrl : " + encodedUrl);
        System.out.println("decodedUrl : " + decodedUrl);
    }
}
