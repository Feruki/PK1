package pk1.mv.fachlogik;

public class EmptyFilenameException extends Exception {
    public EmptyFilenameException() {
        super("Filename is empty");
    }
}
