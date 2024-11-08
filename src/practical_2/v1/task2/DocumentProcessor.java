package practical_2.v1.task2;

import practical_2.v1.task2.exceptions.DocumentCopyException;
import practical_2.v1.task2.exceptions.DocumentDeletionException;

interface DocumentProcessor {
    void addTextToDocument(String text, String pathOfDocument) throws DocumentCopyException;

    void copyDocument(String sourceDocumentName, String destinationDocumentName) throws DocumentCopyException;

    void deleteDocument(String documentName) throws DocumentDeletionException;
}
