package exceptions;

public class LocalConfFileNotFoundException extends Exception {
    private static final long serialVersionUID = 1688335156898284115L;

    public LocalConfFileNotFoundException(String path) {
        super("File local_conf.ini was not found in the path: " + path);
    }
}
