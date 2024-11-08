package practical_2.v2.task2;

import practical_2.v2.task2.exceptions.DocumentCopyException;
import practical_2.v2.task2.exceptions.FileMoveException;
import practical_2.v2.task2.exceptions.FileRenameException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class SimpleFileProcessor implements FileProcessor {
    private static final Logger logger = Logger.getLogger(SimpleFileProcessor.class.getName());

    public SimpleFileProcessor() {
        try {
            FileHandler fileHandler = new FileHandler("file_processing_log.txt", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Program won't start correctly: " + e.getMessage());
        }
    }

    @Override
    public void moveFile(Path source, String targetFolderPath) throws FileMoveException {
        try {
            File file = new File(targetFolderPath);

            if (!file.exists()) {
                file.mkdir();
            }
            Path target = Path.of(targetFolderPath, source.getFileName().toString());
            Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
            logger.log(Level.INFO, "File moved from {0} to {1}", new Object[]{source, targetFolderPath});
        } catch (IOException e) {
            logger.log(Level.WARNING, "Error moving file from " + source + " to " + targetFolderPath, e);
            throw new FileMoveException("Error moving file", source.toString(), targetFolderPath);
        }
    }

    @Override
    public void renameFile(Path path, String fileNewName) throws FileRenameException {
        try {
            File parentDir = path.toFile().getParentFile();
            if (parentDir == null) {
                throw new FileRenameException("Invalid file path: no parent directory.");
            }

            Path newPath = Paths.get(parentDir.getAbsolutePath(), fileNewName);
            Files.move(path, newPath);
            logger.log(Level.INFO, "File renamed from {0} to {1}", new Object[]{path.getFileName(), fileNewName});
        } catch (IOException e) {
            logger.log(Level.WARNING, "Error renaming file " + path.getFileName() + " to " + fileNewName, e);
            throw new FileRenameException("Error renaming file: " + e.getMessage());
        }
    }

    @Override
    public void addTextToDocument(String text, String pathOfDocument) throws DocumentCopyException {
        try (FileWriter writer = new FileWriter(pathOfDocument, true)) {
            writer.write(text + System.lineSeparator());
            logger.log(Level.INFO, "Text added to document {0}", pathOfDocument);
        } catch (IOException e) {
            logger.log(Level.WARNING, "Error adding text to document " + pathOfDocument, e);
            throw new DocumentCopyException("Error adding text to document: " + e.getMessage());
        }
    }
}
