package pk1.mv.fachlogik;


public class PersistenzException extends Exception {
    public PersistenzException() {
        super("PersistenzException");
    }

    public PersistenzException(String message) {
        super(message);
    }
}
