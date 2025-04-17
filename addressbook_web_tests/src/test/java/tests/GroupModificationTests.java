package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupModificationTests extends TestBase {
    @Test
    void canModifyGroup(){
        if (!app.groups().isGroupPresent(app)) {
            app.groups().createGroup(new GroupData("name", "name header", "name footer"));
        }
        app.groups().ModifyGroup(new GroupData().withName("modified name"));
    }
}
