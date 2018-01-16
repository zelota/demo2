/*
 *  Created and licensed by ASH Szoftverház Kft.
 */
package demo2common.utilities;

import javax.crypto.KeyGenerator;
import java.text.Normalizer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Random;

/**
 * @author Varsányi Péter
 * @since 2017.07.28 - varp - a jogok végigvezetése
 */
public class TextUtility {

    /**
     * AES allows 128, 192 or 256 bit key length. That is 16, 24 or 32 byte.
     * <p>
     * <p>
     * 10 20 30 12345678901234567890123456789012
     */
    private static final int AES_LENGTH = 128;
    private static final String SEC_KEY = "Kdsd2!35GSg#%.E3";
    private static final String IV_KEY = "aSg.DDF#@4DFDau3";

    /**
     * A túl hosszú stringeket levágja. A paraméter trimmeli! Ez 30 hosszra
     * hagyja meg a string-et. A felületen a kiírásokhoz használt.
     *
     * @param str A vágandó string.
     * @return String.
     */
    public static String getValue(String str) {
        return getValue(str, 30);
    }

    /**
     * A túl hosszú stringeket levágja a megadott hosszra. Ha nincs olyan
     * hosszú, akkor nincs vágás. A paraméter trimmeli!
     *
     * @param str       A vágandó string.
     * @param maxLength A vágandó hossz mérete.
     * @return String.
     */
    public static String getValue(String str, int maxLength) {
        str = str != null ? str.trim() : str;
        return (str != null && !str.isEmpty() && str.length() > maxLength) ? str.substring(0, maxLength) : str;
    }

    /**
     * A túl hosszú stringeket levágja a megadott hosszra,ugy hogy a szöveg végére még a megadott számú pontot Ha nincs olyan
     * hosszú, akkor nincs vágás. A paraméter trimmeli!
     *
     * @param str       A vágandó string.
     * @param maxLength A vágandó hossz mérete.
     * @param dotLength A string végén lévő pontok száma
     * @return String
     */
    public static String getValue(String str, int maxLength, int dotLength) {
        str = str != null ? str.trim() : str;
        if (str != null && !str.isEmpty() && str.length() > maxLength) {
            StringBuilder strBuilder = new StringBuilder(str.substring(0, maxLength - dotLength));
            for(int i = 0; i<dotLength; i++){
                strBuilder.append(".");
            }
            str = strBuilder.toString();
        }
        return str;
    }

    /**
     * A megadott string üres-e. Trimmeli is.
     *
     * @param str A vizsgálandó string.
     * @return Üres, ha <code>null</code> vagy 0-a hosszú. Használja a
     * <code>trim()</code> metódust, így a csupa space string-ekre is true-t ad!
     */
    public static Boolean isValueEmpty(String str) {
        return (str == null || str.isEmpty() || str.trim().isEmpty());
    }

    /**
     * A szöveg csak betűket és számokat tartalmazhat.
     *
     * @param str A vizsgálandó str.
     * @return Igaz, ha csak (kicsi vagy nagy) betűket és/vagy számot tartalmaz.
     * Ha üres vagy null vagy akármi, akkor hamis.
     */
    public static Boolean isAlphaNumeric(String str) {
        return (!isValueEmpty(str) && str.matches("^[a-zA-Z0-9]*$"));
    }

    /**
     * A megadott string csak karaktereket tartalmaz-e? Space-t sem
     * tartalmazhat!
     *
     * @param str String.
     * @return Igaz, ha csak betűk vannak benne.
     */
    public static Boolean isOnlyLetters(String str) {
        return (!isValueEmpty(str) && str.matches("[a-zA-Z]+"));
    }

    /**
     * Valid email string.
     *
     * @param str A vizsgálandó str.
     * @return Igaz, ha formailag érvényes email cím a paraméter (és nem üres
     * vagy null).
     */
    public static Boolean isValidEmail(String str) {
        return (!isValueEmpty(str) && str.matches("^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$"));
    }

    /**
     * A megadott stringből kódot konvertál.
     * Ha üres vagy null, akkor egy random számot és időt ad vissza.
     * - Nagybetűsít
     * - SAPCE-eket leszed, kiszed
     *
     * @param str A kód alapjául szolgáló string. Lehet üres vagy null.
     * @return
     */
    public static String generateCode(String str) {
        if (str == null || str.trim().isEmpty()) {
            Random rand = new Random();
            int r = rand.nextInt(1000) + 1;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            LocalDateTime ldt = LocalDateTime.now();
            return formatter.format(ldt) + r;
        }
        // nagyetű
        String retVal = str.toUpperCase().trim();

        // space levétel
        retVal = retVal.replace(" ", "");

        // nem ANSI kódú karaketerek levétele
        retVal = retVal.replaceAll("[^\\x00-\\x7F]", "");

        // egyéb jelek levétele
        retVal = retVal.replaceAll("[^a-zA-Z0-9]", "");

        return retVal;
    }

    /**
     * Az adott String végére egy százalék jelet illeszt.
     *
     * @param text
     * @return
     */
    public static String getTextWithEndPercentCharacter(final String text) {
        StringBuilder sb = new StringBuilder();

        if (text == null) {
            sb.append("");
        } else {
            if (!text.endsWith("%")) {
                sb.append(text);
                sb.append("%");
            } else {
                sb.append(text);
            }
        }
        return sb.toString();
    }

    /**
     * Ékezetek eltávolítása egy <code>String</code>ből.
     *
     * @param s <code>String</code> típusú szöveg. Amit át szeretnénk alakíani.
     * @return <code>String</code> típusú átalakított szöveg.
     */
    public static String removeAccents(String s) {
        s = Normalizer.normalize(s, Normalizer.Form.NFD);
        s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return s;
    }
    //<editor-fold defaultstate="collapsed" desc="ancrypt-decrypt">

    /**
     * Szköz karakaterek eltávolítása
     *
     * @param s : nem null és nem üres karakterláncban csréli ki a szóköz
     *          karaktereket.
     * @return String
     */
    public static String removeAllWhiteSpaces(String s) {
        if (s != null && !s.equals("")) {
            s = s.replaceAll("\\s+", "");
        }
        return s;
    }

    /**
     * @param s     : nem null és nem üres karakterláncban csréli ki a szóköz
     *              karaktereket.
     * @param replc : amire a szóköz karaktereket cseréljük, ha null akkor
     *              eltávolításra kerülnek a szóközök.
     * @return String
     */
    public static String removeAllWhiteSpaces(String s, String replc) {
        if (s != null && !s.equals("")) {
            s = s.replaceAll("\\s+", replc == null ? "" : replc);
        }
        return s;
    }

    public static List<Integer> allIndex(String string, String part) {
        List<Integer> result = new ArrayList<>();
        if (string != null) {
            int index = string.indexOf(part);
            while (index >= 0) {
                result.add(index);
                index = string.indexOf(part, index + 1);
            }
        }
        return result;
    }

    /**
     * Encrypt string.
     *
     * @param plainString Parameter to encript. Not null and not empty (no
     *                    check!).
     * @return Encripted string.
     */
    public static String encryptString(String plainString) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(CryptoMngr.ALGORITHM);
            keyGenerator.init(AES_LENGTH);
            //            //Generate Key
            //            SecretKey key = keyGenerator.generateKey();
            //            System.out.println("key: " + key.getEncoded().length);
            //            //Initialization vector
            //            SecretKey IV = keyGenerator.generateKey();
            //            System.out.println("IV: " + IV.getEncoded().length);
            byte[] cipherText = CryptoMngr.encrypt(SEC_KEY.getBytes("UTF-8"), IV_KEY.getBytes("UTF-8"), plainString.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(cipherText);
        } catch (Exception ex) {
            ex.printStackTrace(); //@TODO: ehh! printStackTrace!
        }
        return null;
    }

    /**
     * Kódolt szöveg dekódolása. Private. Hátha egyszer kell valamihez. :) A
     * paraméterként kapot stringet Base64 dekódolja és úgy encrypteli!
     *
     * @param encrypted Kódolt szöveg.
     * @return Megfejtett, "kikódolt" szöveg.
     */
    private static String decryptString(String encrypted) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(CryptoMngr.ALGORITHM);
            keyGenerator.init(AES_LENGTH);
            //            //Generate Key
            //            SecretKey key = keyGenerator.generateKey();
            //            //Initialization vector
            //            SecretKey IV = keyGenerator.generateKey();
            byte[] decryptedString = CryptoMngr.decrypt(SEC_KEY.getBytes("UTF-8"), IV_KEY.getBytes("UTF-8"), Base64.getDecoder().decode(encrypted));
            return new String(decryptedString, "UTF-8");
        } catch (Exception ex) {
            ex.printStackTrace(); //@TODO: ehh! printStackTrace!
        }
        return null;
    }

    //</editor-fold>    
}
