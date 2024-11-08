package practical_2.v1.task2;

import practical_2.v1.task2.exceptions.DocumentCopyException;
import practical_2.v1.task2.exceptions.DocumentDeletionException;

import java.io.BufferedWriter;
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

class SimpleDocumentProcessor implements DocumentProcessor {
    private static final Logger logger = Logger.getLogger(SimpleDocumentProcessor.class.getName());

    public SimpleDocumentProcessor() {
        try {
            FileHandler fileHandler = new FileHandler("document_processing_log.txt", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addTextToDocument(String text, String pathOfDocument) throws DocumentCopyException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathOfDocument, true))) {
            writer.write(text);
            writer.newLine();
            logger.log(Level.INFO, "Text added to document {0}", pathOfDocument);
        } catch (IOException e) {
            logger.log(Level.WARNING, "Error adding text to document {0}: {1}", new Object[]{pathOfDocument, e.getMessage()});
            throw new DocumentCopyException("Error adding text to document.");
        }
    }

    @Override
    public void copyDocument(String sourceDocumentName, String destinationDocumentName) throws DocumentCopyException {
        try {
            Path source = Paths.get(sourceDocumentName);
            Path destination = Paths.get(destinationDocumentName);
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            logger.log(Level.INFO, "Document copied from {0} to {1}", new Object[]{sourceDocumentName, destinationDocumentName});
        } catch (IOException e) {
            logger.log(Level.WARNING, "Error copying document from {0} to {1}: {2}", new Object[]{sourceDocumentName, destinationDocumentName, e.getMessage()});
            throw new DocumentCopyException("Error copying document.");
        }
    }

    @Override
    public void deleteDocument(String documentName) throws DocumentDeletionException {
        try {
            Path path = Paths.get(documentName);
            Files.delete(path);
            logger.log(Level.INFO, "Document {0} deleted successfully", documentName);
        } catch (IOException e) {
            logger.log(Level.WARNING, "Error deleting document {0}: {1}", new Object[]{documentName, e.getMessage()});
            throw new DocumentDeletionException("Error deleting document.");
        }
    }
}
