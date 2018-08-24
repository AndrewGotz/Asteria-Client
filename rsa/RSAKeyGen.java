import java.io.BufferedWriter;
import java.io.FileWriter;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

public class RSAKeyGen {

    public static void main(String[] args) {
        try {
            KeyFactory factory = KeyFactory.getInstance("RSA");
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(1024);
            KeyPair keypair = keyGen.genKeyPair();
            PrivateKey privateKey = keypair.getPrivate();
            PublicKey publicKey = keypair.getPublic();

            RSAPrivateKeySpec privSpec = factory.getKeySpec(privateKey,
                    RSAPrivateKeySpec.class);
            writeKey("./rsa/keys/rsa_private.txt", privSpec.getModulus(),
                    privSpec.getPrivateExponent());

            RSAPublicKeySpec pubSpec = factory.getKeySpec(publicKey,
                    RSAPublicKeySpec.class);
            writeKey("./rsa/keys/rsa_public.txt", pubSpec.getModulus(),
                    pubSpec.getPublicExponent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeKey(String file, BigInteger modulus,
            BigInteger exponent) {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(file))) {
            writer.write("private static final BigInteger RSA_MODULUS = new BigInteger(\"" + modulus
                    .toString() + "\");");
            writer.newLine();
            writer.newLine();
            writer.write("private static final BigInteger RSA_EXPONENT = new BigInteger(\"" + exponent
                    .toString() + "\");");
            writer.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}