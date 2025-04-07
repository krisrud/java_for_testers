
import org.junit.jupiter.api.Test;


public class GroupCreationTests extends TestBase {


    @Test
    public void canCreateGroup() {
        openGroupsPage();

        createGroup("group2", "group2 header", "group2 footer");

    }

    @Test
    public void canCreateGroupWithEmptyName() {
        openGroupsPage();
        createGroup("", "", "");

    }
}
