package model;

@SuppressWarnings("serial")
public class ExtraRoomException extends Exception {
	
    public ExtraRoomException() {
        super("Non � possibile la consegna in camera per questo prodotto");
    }
    
}