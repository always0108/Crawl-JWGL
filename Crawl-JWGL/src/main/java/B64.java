import static java.lang.Integer.parseInt;

public class B64 {

    public static String b64map="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    private static char b64pad = '=';
    private static String hexCode = "0123456789abcdef";

    // 获取对应16进制字符
    public static char int2char(int a){
        return hexCode.charAt(a);
    }

    // Base64转16进制
    public static String b64tohex(String s) {
        String ret = "";
        int k = 0;
        int slop = 0;
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == b64pad) break;
            int v = b64map.indexOf(s.charAt(i));
            if(v < 0) continue;
            if(k == 0) {
                ret += int2char(v >> 2);
                slop = v & 3;
                k = 1;
            }
            else if(k == 1) {
                ret += int2char((slop << 2) | (v >> 4));
                slop = v & 0xf;
                k = 2;
            }
            else if(k == 2) {
                ret += int2char(slop);
                ret += int2char(v >> 2);
                slop = v & 3;
                k = 3;
            }
            else {
                ret += int2char((slop << 2) | (v >> 4));
                ret += int2char(v & 0xf);
                k = 0;
            }
        }
        if(k == 1)
            ret += int2char(slop << 2);
        return ret;
    }

    // 16进制转Base64
    public static String hex2b64(String h) {
        int i , c;
        StringBuilder ret = new StringBuilder();
        for(i = 0; i+3 <= h.length(); i+=3) {
            c = parseInt(h.substring(i,i+3),16);
            ret.append(b64map.charAt(c >> 6));
            ret.append(b64map.charAt(c & 63));
        }
        if(i+1 == h.length()) {
            c = parseInt(h.substring(i,i+1),16);
            ret.append(b64map.charAt(c << 2));
        }
        else if(i+2 == h.length()) {
            c = parseInt(h.substring(i,i+2),16);
            ret.append(b64map.charAt(c >> 2));
            ret.append(b64map.charAt((c & 3) << 4));
        }
        while((ret.length() & 3) > 0) ret.append(b64pad);
        return ret.toString();
    }
}
