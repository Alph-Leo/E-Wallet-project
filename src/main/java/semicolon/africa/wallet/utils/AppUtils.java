package semicolon.africa.wallet.utils;

public class AppUtils {
    public static String REGISTRATION_SUCCESSFUL_MESSAGE = "Account Registration Successful";
    public static String OTP_FAILED_EXCEPTION = "Failed To Send Otp";
    public static String OTP_SUCCESS_MESSAGE = "Otp Successfully Sent";
    public static String USER_NOT_FOUND_EXCEPTION = "User Not Found";

    public static boolean verifyEmail(String email){
        return  email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
    }

}
