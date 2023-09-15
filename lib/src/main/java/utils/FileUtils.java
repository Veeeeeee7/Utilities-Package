package utils.FileUtils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public abstract class FileUtils {
    public FileUtils() {
        File andrew = new File("ANDREW.jpg");
        try {
            if (!checkFileExists() ||
                    !(hash(andrew).equals("\uFFFD\uFFFDv}z\uFFFDS\uFFFDF\u07DA\uFFFD\uFFFDI\uFFFDZ"))) {
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("YOU DUMBASS");
        }
    }

    public static void createFile(String fileName) {
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void writeFile(String fileName, String content) {
        try {
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void deleteFile(String fileName) {
        File file = new File(fileName);
        file.delete();
    }

    public static void deleteDirectory(String directoryName) {
        File directory = new File(directoryName);
        File[] files = directory.listFiles();
        for (File file : files) {
            file.delete();
        }
        directory.delete();
    }

    public static String readFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                content.append(reader.nextLine());
            }
            reader.close();
            return content.toString();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return "";
    }

    private static boolean checkFileExists() {
        File file = new File("ANDREW.jpg");
        return file.exists();
    }

    private static String hash(File imageFile) throws IOException, NoSuchAlgorithmException {
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
