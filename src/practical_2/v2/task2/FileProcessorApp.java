package practical_2.v2.task2;

import practical_2.v2.task2.exceptions.DocumentCopyException;
import practical_2.v2.task2.exceptions.FileMoveException;
import practical_2.v2.task2.exceptions.FileRenameException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileProcessorApp {
    public static void main(String[] args) {
        SimpleFileProcessor sfp = new SimpleFileProcessor();
        preparationOfTestFile();

        try {
            sfp.moveFile(Path.of("source.txt"), "targetFolder");
            sfp.renameFile(Paths.get("targetFolder/source.txt"), "renamedFile.txt");
            sfp.addTextToDocument("Sample text", "targetFolder/renamedFile.txt");

        } catch (DocumentCopyException | FileRenameException e) {
            System.out.println("Some other error while processing: " + e.getMessage());

        } catch (FileMoveException moveException) {
            System.out.println("Error moving file: " + moveException.getMessage());
            System.out.println("Source Path: " + moveException.getSourcePath());
            System.out.println("Target Path: " + moveException.getTargetPath());
        }
    }

    public static void preparationOfTestFile() {
        try {
            Path pathOfTestFile = Path.of("source.txt");
            if (Files.notExists(pathOfTestFile)) {
                Files.createFile(pathOfTestFile);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}