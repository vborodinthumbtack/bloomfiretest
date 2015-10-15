package bloomfire.test.data;

/**
 * Created by Vlad on 15.10.15.
 */
public class Organization
{
    public String id;
    public String subdomain;
    public String support_email;
    public String name;
    public String host;

    public Boolean ask_a_question;
    public Boolean has_featured;
    public Boolean groups_enabled;
    public Boolean default_public_content;

    public Colors colors;

    public void assertNotNull()
    {
        assert id != null;
        assert subdomain != null;
        assert support_email != null;
        assert name != null;
        assert host != null;

        assert ask_a_question != null;
        assert has_featured != null;
        assert groups_enabled != null;
        assert default_public_content != null;

        assert colors != null;
        colors.assertNotNull();
    }

/*
        "organization": {
            "id": 55,
            "subdomain": "aldigitchildnew",
            "support_email": "support@bloomfire.com",
            "name": "Aldigit child with a very very very looooooong name",
            "host": "aldigitchildnew.bloomfire.mobi",
            "colors": ...
            "ask_a_question": true,
            "has_featured": true,
            "groups_enabled": true,
            "default_public_content": true
        },

 */
}
