package pk1.mv.datenhaltung;

import java.util.List;

import pk1.mv.fachlogik.*;

public interface IDao {
    void speichern(List<Medium> liste) throws PersistenzException;
    List<Medium> laden() throws PersistenzException;
}
