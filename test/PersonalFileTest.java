import com.company.PersonalFile;
import com.company.User;
import com.control.PersonalFileController;
import com.supplementary.Clearance;
import com.supplementary.Department;
import com.supplementary.Job;
import com.supplementary.LoginData;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class PersonalFileTest {
    PersonalFileController controller = new PersonalFileController(new User(true, "test", "test", new Date(System.currentTimeMillis()), 0, Clearance.LEVEL_2, new Job("test", "test", Department.AD), null, new LoginData("test", "test")));

    @Test
    public void testCreatePersonalFile(){
        Assert.assertNotNull(controller.createPersonalFile("test", Clearance.LEVEL_0, "test"));
    }

    @Test
    public void testViewPersonalFile(){
        PersonalFile temp = controller.createPersonalFile("test", Clearance.LEVEL_0, "test");
        PersonalFile temp2 = controller.createPersonalFile("test", Clearance.LEVEL_3, "test");
        Assert.assertEquals(controller.viewPersonalFile(temp), "test");
        Assert.assertNull(controller.viewPersonalFile(temp2));
    }

    @Test
    public void testEditPersonalFile(){
        PersonalFile temp = controller.createPersonalFile("test", Clearance.LEVEL_0, "test");
        PersonalFile temp2 = new PersonalFile("test", Clearance.LEVEL_0, "test", new User(true, "test", "test", new Date(System.currentTimeMillis()), 0, Clearance.LEVEL_5, new Job("test", "test", Department.AD), null, new LoginData("test", "test")));
        controller.editPersonalFile(temp, "test2");
        Assert.assertEquals(controller.viewPersonalFile(temp), "test2");
        controller.editPersonalFile(temp2, "test2");
        Assert.assertNotEquals(controller.viewPersonalFile(temp2), "test2");
    }

    @Test
    public void testDeletePersonalFile(){
        PersonalFile temp = controller.createPersonalFile("test", Clearance.LEVEL_0, "test");
        temp = controller.deletePersonalFile(temp);
        Assert.assertNull(temp);
    }
}
