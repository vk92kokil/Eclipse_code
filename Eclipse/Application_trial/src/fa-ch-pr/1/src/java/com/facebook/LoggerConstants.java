
public class LoggerConstants {

    private static String facebookUserId = "";
    private static String ipAddress = "";

    
    public static String getFacebookUserId() {
        return facebookUserId;
    }

    public static void setFacebookUserId(String facebookUserId) {
        LoggerConstants.facebookUserId = facebookUserId;
    }

    public static String getIpAddress() {
        return ipAddress;
    }

    public static void setIpAddress(String ipAddress) {
        LoggerConstants.ipAddress = ipAddress;
    }


}
