import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.SendGridAPI;

public class MailCallingService
{
    private SendGridAPI sendGrid;

    // The key of SendGrid API.
    private String apiKey = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";

    // Elements of a mail to send.
    private Email from = new Email("XXXXXXX@xxx.com");
    private Email to = new Email("YYYYYYY@yyy.com");
    private String title = "title";
    private Content content = new Content("text/plain", "Hello.")



	public MailCallingService()
	{
		sendGrid = new SendGrid(apiKey);
	}

    public Response send()
    {
		Request request = new Request();
		Response response = new Response();
		request.setMethod(Method.POST);
		request.setEndpoint("mail/send");

		// Create a mail.
		Mail mail = new Mail(from, title, to, content)

		try
		{
			request.setBody(mail.build());
			response = sendGrid.api(request);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return response;
    }
}