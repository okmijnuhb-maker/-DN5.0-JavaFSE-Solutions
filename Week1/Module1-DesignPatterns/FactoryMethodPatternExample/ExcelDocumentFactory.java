// Concrete factory - Creates Excel documents
public class ExcelDocumentFactory extends DocumentFactory {
    
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}