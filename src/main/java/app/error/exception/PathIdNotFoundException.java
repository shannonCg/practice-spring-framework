package app.error.exception;

public class PathIdNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    
    private String errorPathName;

    private String errorPathValue;

    public PathIdNotFoundException(String errorPathName, String errorPathValue) {
        super();
        this.errorPathName = errorPathName;
        this.errorPathValue = errorPathValue;
    }

    public String getErrorPathName() {
        return errorPathName;
    }

    public void setErrorPathName(String errorPathName) {
        this.errorPathName = errorPathName;
    }

    public String getErrorPathValue() {
        return errorPathValue;
    }

    public void setErrorPathValue(String errorPathValue) {
        this.errorPathValue = errorPathValue;
    }
    
}
