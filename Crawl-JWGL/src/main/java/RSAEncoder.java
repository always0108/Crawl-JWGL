import java.math.BigInteger;
import java.util.Random;

public class RSAEncoder {
    private static BigInteger n = null;
    private static BigInteger e = null;

    public static String RSAEncrypt(String pwd, String nStr, String eStr){
        n = new BigInteger(nStr,16);
        e = new BigInteger(eStr,16);

        BigInteger r = RSADoPublic(pkcs1pad2(pwd,(n.bitLength()+7)>>3));
        String sp = r.toString(16);
        if((sp.length()&1) != 0 )
            sp = "0" + sp;
        return sp;
    }

    private static BigInteger RSADoPublic(BigInteger x){
              return x.modPow(e, n);
    }

    private static BigInteger pkcs1pad2(String s, int n){
        if(n < s.length() + 11) { // TODO: fix for utf-8
            System.err.println("Message too long for RSAEncoder");
            return null;
        }
        byte[] ba = new byte[n];
        int i = s.length()-1;
        while(i >= 0 && n > 0) {
            int c = s.codePointAt(i--);
            if(c < 128) { // encode using utf-8
                ba[--n] = new Byte(String.valueOf(c));
            }
            else if((c > 127) && (c < 2048)) {
                 ba[--n] = new Byte(String.valueOf((c & 63) | 128));
                ba[--n] = new Byte(String.valueOf((c >> 6) | 192));
            } else {
                ba[--n] = new Byte(String.valueOf((c & 63) | 128));
                ba[--n] = new Byte(String.valueOf(((c >> 6) & 63) | 128));
                ba[--n] = new Byte(String.valueOf((c >> 12) | 224));
            }
        }
        ba[--n] = new Byte("0");

        byte[] temp = new byte[1];
        Random rdm = new Random(47L);

        while(n > 2) { // random non-zero pad
            temp[0] = new Byte("0");
            while(temp[0] == 0)
                rdm.nextBytes(temp);
            ba[--n] = temp[0];
        }
        ba[--n] = 2;
        ba[--n] = 0;
        return new BigInteger(ba);
    }
}
