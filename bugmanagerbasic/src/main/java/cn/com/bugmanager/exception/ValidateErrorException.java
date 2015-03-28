package cn.com.bugmanager.exception;

/**
 * Created by genghis on 14-8-25.
 */
public class ValidateErrorException extends RuntimeException {

    public ValidateErrorException(String message) {
        super(message);
    }
}
