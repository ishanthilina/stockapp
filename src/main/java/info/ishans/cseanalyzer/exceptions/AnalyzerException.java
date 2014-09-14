package info.ishans.cseanalyzer.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: ishan
 * Date: 9/14/14
 * Time: 8:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class AnalyzerException extends Exception {
    public AnalyzerException() {
        super();
    }

    public AnalyzerException(String message) {
        super(message);
    }

    public AnalyzerException(String message, Throwable cause) {
        super(message, cause);
    }

    public AnalyzerException(Throwable cause) {
        super(cause);
    }
}
