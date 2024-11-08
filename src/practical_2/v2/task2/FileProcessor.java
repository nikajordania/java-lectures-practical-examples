package practical_2.v2.task2;

import practical_2.v2.task2.exceptions.DocumentCopyException;
import practical_2.v2.task2.exceptions.FileMoveException;
import practical_2.v2.task2.exceptions.FileRenameException;

import java.nio.file.Path;

public interface FileProcessor {
    void moveFile(Path fileSourcePath, String targetFolderPath) throws FileMoveException;

    void renameFile(Path path, String fileNewName) throws FileRenameException;

    void addTextToDocument(String text, String pathOfDocument) throws DocumentCopyException;
}
