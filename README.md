# Utilities Package

## File Utilities

Sample code:

```
import Utilities.FileUtils;

public class Example {

    protected String fileName = "example.txt";
    protected String folderName = "examplefolder";
    protected String content = "Hello World!";

    public static void main (String[] args) {
        fileUtils.createFile(fileName);
        fileUtils.createDirectory(folderName)

        fileUtils.writeFile(fileName, content);

        String content = fileUtils.readFile(fileName);
        String sha = fileUtils.sha1(content);

        fileUtils.deleteFile(fileName);
        fileUtils.deleteDirectory(folderName);

        fileUtils.fileExists(fileName);
    }
}
```
