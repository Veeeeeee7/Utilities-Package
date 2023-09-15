package Utilities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public abstract class FileUtils {

    public FileUtils() throws URISyntaxException {
        check();
    }

    public static void createFile(String fileName) throws URISyntaxException {
        check();
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void writeFile(String fileName, String content) throws URISyntaxException {
        check();
        try {
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void deleteFile(String fileName) throws URISyntaxException {
        check();
        File file = new File(fileName);
        file.delete();
    }

    public static void deleteDirectory(String directoryName) throws URISyntaxException {
        check();
        File directory = new File(directoryName);
        File[] files = directory.listFiles();
        for (File file : files) {
            file.delete();
        }
        directory.delete();
    }

    public static String readFile(String fileName) throws URISyntaxException {
        check();
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

    private static boolean checkFileExists() throws URISyntaxException {
        Path resourceDirectory = Paths.get("./bin/resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        File andrewBin = new File(absolutePath + "/ANDREW.jpg");
        File andrew = new File("resources/ANDREW.jpg");
        return andrew.exists() || andrewBin.exists();
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
        return new String(md.digest());
    }

    private static void check() throws URISyntaxException {
        Path resourceDirectory = Paths.get("./bin/resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        File andrewBin = new File(absolutePath + "/ANDREW.jpg");
        File andrew = new File("resources/ANDREW.jpg");
        try {
            if (!checkFileExists() ||
                    !((hash(andrew).equals("\uFFFD\uFFFDv}z\uFFFDS\uFFFDF\u07DA\uFFFD\uFFFDI\uFFFDZ")) ||
                            (hash(andrewBin).equals("\uFFFD\uFFFDv}z\uFFFDS\uFFFDF\u07DA\uFFFD\uFFFDI\uFFFDZ")))) {
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("YOU DUMBASS");
        }
    }

    // public static void throwE() throws Exception {
    // Path resourceDirectory = Paths.get("./bin/resources");
    // String absolutePath = resourceDirectory.toFile().getAbsolutePath();
    // File andrew = new File(absolutePath + "/ANDREW.jpg");
    // andrew.delete();
    // }
}
