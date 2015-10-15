package bloomfire.test.data;

/**
 * Created by Vlad on 15.10.15.
 */
public class User
{
    public Boolean can_create_question;
    public Boolean can_create_comment;
    public String email;
    public String role;
    public String id;
    public String first_name;
    public String last_name;
    public String updated_at;
    public Boolean has_avatar;

    public void assertNotNull()
    {
        assert can_create_question != null;
        assert can_create_comment != null;
        assert email != null;
        assert role != null;
        assert id != null;
        assert first_name != null;
        assert last_name != null;
        assert updated_at != null;
        assert has_avatar != null;
    }
    /*
            "user": {
            "can_create_question": true,
            "can_create_comment": true,
            "email": "vborodin@thumbtack.net",
            "role": "author",
            "id": 283,
            "first_name": "Vlad",
            "last_name": "Borodin",
            "updated_at": "2015-08-21T04:39:29-04:00",
            "has_avatar": true
        }

     */
}
