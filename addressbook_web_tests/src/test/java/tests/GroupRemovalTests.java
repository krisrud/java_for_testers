package tests;

import manager.ApplicationManager;
import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase {


    @Test
    public void canRemoveGroup() {
        app.openGroupsPage();
        if (!app.isGroupPresent()) {
            ApplicationManager.createGroup(new GroupData("name", "name header", "name footer"));
        }
        ApplicationManager.removeGroup();

    }


}
