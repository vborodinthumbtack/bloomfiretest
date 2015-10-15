package bloomfire.test;

/**
 * Created by Vlad on 15.10.15.
 */
public class Constants
{
    public static final String ORGANIZATION_FIELDS = "id,groups_enabled,subdomain,name,host,support_email," +
            "account_name,mobile_color,colors,mobile_logo(_500x500),ask_a_question,default_public_content,has_featured";
    public static final String ORGANIZATION_FIND_FIELDS = ORGANIZATION_FIELDS + ",authenticators(type,instance(url))";
    public static final String USER_FIELDS = "id,updated_at,role,first_name,last_name,email,has_avatar"
            + ",can_create_comment"
            + ",can_create_question";
    public static final String LOGIN_FIELDS = "session_token,organization(" + ORGANIZATION_FIELDS + "),user(" + USER_FIELDS + ")";
    public static final String GROUPS_INFO_FIELDS = "my_groups(id,name),visible_bookmarks_count";
}
