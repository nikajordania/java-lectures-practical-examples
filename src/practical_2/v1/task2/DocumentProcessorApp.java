package practical_2.v1.task2;

import practical_2.v1.task2.exceptions.DocumentCopyException;
import practical_2.v1.task2.exceptions.DocumentDeletionException;

public class DocumentProcessorApp {
    public static void main(String[] args) {
        SimpleDocumentProcessor sdp = new SimpleDocumentProcessor();

        try {
            sdp.addTextToDocument("This is a test text.", "document.txt");
            sdp.copyDocument("document.txt", "document_copy.txt");
            sdp.deleteDocument("document.txt");
        } catch (DocumentDeletionException | DocumentCopyException e) {
            System.out.println("Error deleting document: " + e.getMessage());
        }
    }
}
