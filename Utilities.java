import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.imageio.ImageIO;

public class Utilities {
    public static void check() throws NoSuchAlgorithmException, IOException {
        File andrew = new File("ANDREW.jpg");
        if (!checkFileExists() ||
                !(hash(andrew).equals("\uFFFD\uFFFDv}z\uFFFDS\uFFFDF\u07DA\uFFFD\uFFFDI\uFFFDZ"))) {
            System.exit(0);
        }
    }

    private static boolean checkFileExists() {
        File file = new File("ANDREW.jpg");
        return file.exists();
    }

    public static String hash(File imageFile) throws IOException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        try {
            BufferedImage img = ImageIO.read(imageFile);
            byte[] bytes = (byte[]) img.getRaster().getDataElements(0, 0, img.getWidth(), img.getHeight(), null);
            md.update(bytes);
        } catch (Exception e) {
            System.out.println("Error in hashing");
        }
        byte[] digest = md.digest();
        return new String(digest);
    }
}
