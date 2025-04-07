import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase {


    @Test
    public void canRemoveGroup() {
        openGroupsPage();
        if (!isGroupPresent()) {
            createGroup("group2", "group2 header", "group2 footer");
        }
        removeGroup();

    }


}
