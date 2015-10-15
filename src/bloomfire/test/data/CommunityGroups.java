package bloomfire.test.data;

import java.util.List;

/**
 * Created by vborodin on 3/12/15.
 */
public class CommunityGroups
{
    public Integer visible_bookmarks_count;
    public List<Group> my_groups;

    public void assertNotNull()
    {
        assert visible_bookmarks_count != null;
        assert my_groups != null;
        if (my_groups.size() != 0)
        {
            for (Group group : my_groups)
                group.assertNotNull();
        }
    }
}
