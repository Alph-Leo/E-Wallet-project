package semicolon.africa.wallet.utils;

public class AppUtils {
    public static String REGISTRATION_SUCCESSFUL_MESSAGE = "Registration Successful";
    public static final String LOGIN_SUCCESSFUL_MESSAGE = "Welcome Back!";
    public static final String LOGIN_ERROR_MESSAGE = "Invalid email or password";
    public static final String UPDATE_SUCCESS_MESSAGE = "Profile Successfully Updated";
    public static final String BLANK_SPACE = " ";
    public static final String IMAGE_FILE_PATH = "C:\\Users\\Leo_Nation\\IdeaProjects\\WalletApp\\src\\test\\resources\\images\\WhatsApp Image 2023-10-27 at 11.25.07_b6be4915.jpg";
    public static String OTP_FAILED_EXCEPTION = "Failed To Send Otp";
    public static String OTP_SUCCESS_MESSAGE = "Otp Successfully Sent";
    public static String USER_NOT_FOUND_EXCEPTION = "User Not Found";
    public static final String INVALID_EMAIL_EXCEPTION = "Invalid email provided";

    public static boolean validateEmail(String email){
        return  email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
    }

}
