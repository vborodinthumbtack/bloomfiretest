package bloomfire.test.data;

/**
 * Created by Vlad on 15.10.15.
 */
public class Login
{
    public String session_token;
    public Organization organization;
    public User user;

    public void assertNotNull()
    {
        assert session_token != null;
        assert organization != null;
        organization.assertNotNull();
        assert user != null;
        user.assertNotNull();
    }

    public String getAPIUrl()
    {
        return "https://"+organization.subdomain+".bloomfire.mobi/api/v2/";
    }
    /*
    [
    {
        "session_token": "5370ab3380b58b7a6b3558bbb6b9b3c42caeb160ac2e429a8041e4cb296fd620",
        "organization": ...
        "user": ...
    },

     */
}
