// Abstract class - Blueprint for all factories
public abstract class DocumentFactory {
    
    // Factory method - subclasses will implement this
    public abstract Document createDocument();
    
    // Common method to open document
    public void openDocument() {
        Document doc = createDocument();
        doc.open();
    }
}