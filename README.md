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
        FileUtils.createFile(fileName);
        FileUtils.createDirectory(folderName)

        FileUtils.writeFile(fileName, content);

        String content = FileUtils.readFile(fileName);
        String sha = FileUtils.sha1(content);

        FileUtils.deleteFile(fileName);
        FileUtils.deleteDirectory(folderName);

        FileUtils.fileExists(fileName);
    }
}
```
