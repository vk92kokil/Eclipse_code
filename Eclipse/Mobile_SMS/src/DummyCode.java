import com.textmagic.sms.TextMagicMessageService;
import com.textmagic.sms.exception.ServiceException;

public class DummyCode {
    public static void main (String []argz) {
          String dummyPhone = "9173365243";
          TextMagicMessageService service = 
             new TextMagicMessageService ("kjhkjhkj","wwerwttre");
          try {
               service.send("Hello, World!", dummyPhone);
          } catch(ServiceException ex) {
               System.out.println(" :-( ");
          }
    }
}