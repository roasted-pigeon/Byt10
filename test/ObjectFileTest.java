import com.company.*;
import com.control.ObjectFileController;
import com.supplementary.*;
import org.junit.Test;
import org.junit.Assert;

import java.util.Date;

public class ObjectFileTest {
    ObjectFileController controller = new ObjectFileController(new User(true, "test", "test", new Date(System.currentTimeMillis()), 0, Clearance.LEVEL_2, new Job("test", "test", Department.AD), null, new LoginData("test", "test")));

    @Test
    public void testCreateObjectFile(){
        Assert.assertNotNull(controller.createObjectFile("test", Clearance.LEVEL_0, "test", new SCPObject("test", Clearance.LEVEL_0, ContainmentClass.NEUTRALIZED, DisruptionClass.DARK, RiskClass.NOTICE, SecondaryClass.BLANK)));
    }

    @Test
    public void testViewObjectFile(){
        ObjectFile temp = controller.createObjectFile("test", Clearance.LEVEL_0, "test", new SCPObject("test", Clearance.LEVEL_0, ContainmentClass.NEUTRALIZED, DisruptionClass.DARK, RiskClass.NOTICE, SecondaryClass.BLANK));
        ObjectFile temp2 = new ObjectFile("test", Clearance.LEVEL_3, "test", new SCPObject("test", Clearance.LEVEL_0, ContainmentClass.NEUTRALIZED, DisruptionClass.DARK, RiskClass.NOTICE, SecondaryClass.BLANK), new User(true, "test", "test", new Date(System.currentTimeMillis()), 0, Clearance.LEVEL_5, new Job("test", "test", Department.AD), null, new LoginData("test", "test")));
        Assert.assertEquals(controller.viewObjectFile(temp), "test");
        Assert.assertNull(controller.viewObjectFile(temp2));
    }

    @Test
    public void testEditObjectFile(){
        ObjectFile temp = controller.createObjectFile("test", Clearance.LEVEL_0, "test", new SCPObject("test", Clearance.LEVEL_0, ContainmentClass.NEUTRALIZED, DisruptionClass.DARK, RiskClass.NOTICE, SecondaryClass.BLANK));
        ObjectFile temp2 = new ObjectFile("test", Clearance.LEVEL_0, "test", new SCPObject("test", Clearance.LEVEL_0, ContainmentClass.NEUTRALIZED, DisruptionClass.DARK, RiskClass.NOTICE, SecondaryClass.BLANK), new User(true, "test", "test", new Date(System.currentTimeMillis()), 0, Clearance.LEVEL_5, new Job("test", "test", Department.AD), null, new LoginData("test", "test")));
        controller.editObjectFile(temp, "test2");
        Assert.assertEquals(controller.viewObjectFile(temp), "test2");
        controller.editObjectFile(temp2, "test2");
        Assert.assertNotEquals(controller.viewObjectFile(temp2), "test2");
    }

    @Test
    public void testDeleteObjectFile(){
        ObjectFile temp = controller.createObjectFile("test", Clearance.LEVEL_0, "test", new SCPObject("test", Clearance.LEVEL_0, ContainmentClass.NEUTRALIZED, DisruptionClass.DARK, RiskClass.NOTICE, SecondaryClass.BLANK));
        temp=controller.deleteObjectFile(temp);
        Assert.assertNull(temp);
    }
}
