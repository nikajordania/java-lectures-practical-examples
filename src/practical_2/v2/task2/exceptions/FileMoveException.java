package practical_2.v2.task2.exceptions;

public class FileMoveException extends Exception {
    private final String sourcePath;
    private final String targetPath;

    public FileMoveException(String message, String sourcePath, String targetPath) {
        super(message);
        this.sourcePath = sourcePath;
        this.targetPath = targetPath;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public String getTargetPath() {
        return targetPath;
    }
}