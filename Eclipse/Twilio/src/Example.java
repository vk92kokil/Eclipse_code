import com.twilio.sdk.*;
import java.util.HashMap;
import java.util.Map;
public class Example {
/* Twilio REST API version */
public static final String APIVERSION = "2010-04-01";
public static void main(String[] args){
/* Twilio AccountSid and AuthToken */
String AccountSid = "AC31f00612c5c6f553a3f4a089e5012531";
String AuthToken = "dc40be9bcfdbc7677e5fff3ddbaf68ca";
/* Outgoing Caller ID previously validated with Twilio */
String CallerID = "+919173365243";
String ToCall = "+919471281973";
String Url="http://twimlets.com/message?Message%5B0%5D=Hello%20from%20my%20java%20application.&Message%5B1%5D=http%3A%2F%2Fcom.twilio.music.electronica.s3.amazonaws.com%2Fteru_-_110_Downtempo_Electronic_4.mp3";
/* Instantiate a new Twilio Rest Client */
TwilioRestClient client = new TwilioRestClient(AccountSid, AuthToken, null);
//build map of post parameters
Map params = new HashMap();
params.put("From", CallerID);
params.put("To", ToCall);
params.put("Url", Url);
TwilioRestResponse response;
try {
response = client.request("/"+APIVERSION+"/Accounts/"+client.getAccountSid()+"/Calls", "POST", params);
if(response.isError())
System.out.println("Error making outgoing call: "+response.getHttpStatus()+"n"+response.getResponseText());
else {
System.out.println(response.getResponseText());
}
} catch (TwilioRestException e) {
e.printStackTrace();
}
}
}
