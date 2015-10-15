package bloomfire.test;

import bloomfire.test.data.CommunityGroups;
import bloomfire.test.data.Group;
import bloomfire.test.data.Login;
import bloomfire.test.data.Organization;

import java.util.List;

/**
 * Created by Vlad on 15.10.15.
 */
public class TestConnect
{
    static public void testConnect(Login login)
    {
        Organization org = (Organization) NetWork.requestWithTokenAndAssert(login, "organization?fields=" + Constants.ORGANIZATION_FIELDS, Organization.class);
        org.assertNotNull();
    }

    static public List<Group> testGetGroupsList(Login login)
    {
        CommunityGroups cg = (CommunityGroups) NetWork.requestWithTokenAndAssert(login, "users/me?fields=" + Constants.GROUPS_INFO_FIELDS, CommunityGroups.class);
        cg.assertNotNull();
        return cg.my_groups;
    }
}
