package tests;

import manager.ApplicationManager;
import model.GroupData;
import org.junit.jupiter.api.Test;


public class GroupCreationTests extends TestBase {


    @Test
    public void canCreateGroup() {
        app.openGroupsPage();

        ApplicationManager.createGroup(new GroupData("name", "name header", "name footer"));

    }

    @Test
    public void canCreateGroupWithEmptyName() {
        app.openGroupsPage();
        ApplicationManager.createGroup(new GroupData());

    }
    @Test
    public void canCreateGroupWithNameOnly() {
        app.openGroupsPage();
        var emptyGroup = new GroupData();
        var groupWithName = emptyGroup.withName("some name");
        ApplicationManager.createGroup(groupWithName);

    }
}
