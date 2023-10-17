package semicolon.africa.wallet.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


@Getter
@Setter
@Slf4j
public class AppUtils {
    public static String REGISTRATION_SUCCESSFUL_MESSAGE = "Account Registration Successful";
    public static String OTP_FAILED_EXCEPTION = "Failed To Send Otp";
    public static String OTP_SUCCESS_MESSAGE = "Otp Successfully Sent";
    public static String USER_NOT_FOUND_EXCEPTION = "User Not Found";

    public static boolean verifyEmail(String email){
        return  email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
    }
//    public static boolean sendOTPViaSMS(String phoneNumber, String otp) {
//        String accountSid = "AC437f264a7924a4e6c16c04bcf2398243";
//        String authToken = "ce28365b42ec95b1bff5f0d21c23e5ba";
//        String twilioPhoneNumber = "+2347065506982";
//
//        Twilio.init(accountSid, authToken);
//
//        try {
//            Message message = Message.creator(
//                    new PhoneNumber(phoneNumber),
//                    new PhoneNumber(twilioPhoneNumber),
//                    "Your OTP is: " + otp
//            ).create();
//
//            log.info("--->{}", OTP_SUCCESS_MESSAGE);
//            return true ;
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.info("--->{}", OTP_FAILED_EXCEPTION);
//            return false;
//        }



//        public static void sendOTP(String recipientPhoneNumber) {
//            String apiKey = "TLoWsTrRBxqyahGYTRYzK2BCvT91RmY5HSH7JOzT7NVIbGvOnsLonouH0NViH8";
//            String apiSecret = "tsk_j8gm652d11a76cf8b70834y9r0";
//
//            NexmoClient client = NexmoClient.builder()
//                    .apiKey(apiKey)
//                    .apiSecret(apiSecret)
//                    .build();
//
//            VerifyClient verifyClient = client.getVerifyClient();
//
//            VerifyRequest request = new VerifyRequest(recipientPhoneNumber, "E_Wallet"); // Replace with your app name
//            request.setLength(4); // Customize the OTP code length (default is 4)
//
//            try {
//                VerifyResponse response = verifyClient.verify(request);
//
//                if ("O".equals(response.getStatus())) {
//                    log.info(OTP_SUCCESS_MESSAGE);
//
//                } else {
//                    System.err.println(OTP_FAILED_EXCEPTION + response.getErrorText());
//                }
//            } catch (NexmoResponseParseException | IOException e) {
//                e.printStackTrace();
//            }
//        }


    public static String sendSMS(String mob_No,String msg){
        String result="408";
        int TIMEOUT_VALUE = 500;
        try{
            String username = "enter your username";
            String password = "Enter your password";
            String senderid = "Enter your senderid";
            String message = msg;//"new message system....!";
            String mobileNo = mob_No ;
            HttpURLConnection connection = null;
            URL url = new URL("Enter the url");
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setFollowRedirects(true);
            connection.setConnectTimeout(TIMEOUT_VALUE);

            String smsservicetype = "singlemsg"; // For single message.
            String query = "username=" + URLEncoder.encode(username)
                    + "&password=" + URLEncoder.encode(password)
                    + "&smsservicetype=" + URLEncoder.encode(smsservicetype)
                    + "&content=" + URLEncoder.encode(message) + "&mobileno="
                    + URLEncoder.encode(mobileNo) + "&senderid="
                    + URLEncoder.encode(senderid);

            connection.setRequestProperty("Content-length", String
                    .valueOf(query.length()));
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            connection.setRequestProperty("User-Agent",
                    "Mozilla/4.0 (compatible; MSIE 5.0; Windows 98; DigExt)");

            // open up the output stream of the connection
            DataOutputStream output = new DataOutputStream(connection
                    .getOutputStream());

            // write out the data
            int queryLength = query.length();
            output.writeBytes(query);
            // output.close();
            // get ready to read the response from the cgi script
            DataInputStream input = new DataInputStream(connection
                    .getInputStream());
            String tempres="";
            // read in each character until end-of-stream is detected
            for (int c = input.read(); c != -1; c = input.read())
            {System.out.print((char) c);
                tempres+=String.valueOf((char) c);
            }

            result=tempres.substring(0, tempres.indexOf(","));
            input.close();
            System.out.println("Resp Code:" + connection.getResponseCode());
            System.out.println("Resp Message:"
                    + connection.getResponseMessage());
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("More than " + TIMEOUT_VALUE + " elapsed.");

        }

        return result;
    }

}
