// Concrete factory - Creates Word documents
public class WordDocumentFactory extends DocumentFactory {
    
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}