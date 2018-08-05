package optus.search.searchdemo.exception;

/**
 * @author ali.
 */
public class GeneralException extends Exception {
    public GeneralException(String msg) {
        super(msg);
    }

    public GeneralException(String msg, Throwable e) {
        super(msg, e);
    }
}
