/*
 *  Created and licensed by ASH Szoftverház Kft.
 */
package demo2common.utilities;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.Serializable;

/**
 * @author Varsányi Péter
 */
public class CryptoMngr implements Serializable {

    private static final long serialVersionUID = 20170104151634565L;

    public static String ALGORITHM = "AES";
    private static String AES_CBS_PADDING = "AES/CBC/PKCS5Padding";

    public static byte[] encrypt( final byte[] key, final byte[] IV, final byte[] message ) throws Exception {
        return CryptoMngr.encryptDecrypt(Cipher.ENCRYPT_MODE, key, IV, message);
    }

    public static byte[] decrypt( final byte[] key, final byte[] IV, final byte[] message ) throws Exception {
        return CryptoMngr.encryptDecrypt(Cipher.DECRYPT_MODE, key, IV, message);
    }

    private static byte[] encryptDecrypt( final int mode, final byte[] key, final byte[] IV, final byte[] message )
            throws Exception {
        final Cipher cipher = Cipher.getInstance(AES_CBS_PADDING);
        final SecretKeySpec keySpec = new SecretKeySpec(key, ALGORITHM);
        final IvParameterSpec ivSpec = new IvParameterSpec(IV);
        cipher.init(mode, keySpec, ivSpec);
        return cipher.doFinal(message);
    }
}
