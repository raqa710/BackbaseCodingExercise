package exceptions;

public class WrongIniFileFormatException extends Exception {
    private static final long serialVersionUID = 9183300119696588025L;

    public WrongIniFileFormatException() {
        super("local_conf.ini did not have the format like varName = varValue");
    }
}
