package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase {


    @Test
    public void canRemoveGroup() {
        if (!app.groups().isGroupPresent(app)) {
            app.groups().createGroup(new GroupData("name", "name header", "name footer"));
        }
        app.groups().removeGroup();

    }


}
