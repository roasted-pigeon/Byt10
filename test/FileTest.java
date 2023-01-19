import com.company.File;
import com.company.ObjectFile;
import com.company.SCPObject;
import com.company.User;
import com.supplementary.*;
import org.junit.Test;
import org.junit.Assert;

import java.util.Calendar;
import java.util.Date;

public class FileTest {
    @Test
    public void testGetClearance(){
        File testFile = new ObjectFile("test", Clearance.LEVEL_0, "test", new SCPObject("test", Clearance.LEVEL_0, ContainmentClass.NEUTRALIZED, DisruptionClass.DARK, RiskClass.NOTICE, SecondaryClass.BLANK), new User(true, "test", "test", new Date(System.currentTimeMillis()), 0, Clearance.LEVEL_5, new Job("test", "test", Department.AD), null, new LoginData("test", "test")));
        Assert.assertEquals(Clearance.LEVEL_0, testFile.getClearance());
    }

    @Test
    public void testGetCreator(){
        File testFile = new ObjectFile("test", Clearance.LEVEL_0, "test", new SCPObject("test", Clearance.LEVEL_0, ContainmentClass.NEUTRALIZED, DisruptionClass.DARK, RiskClass.NOTICE, SecondaryClass.BLANK), new User(true, "test", "test", new Date(System.currentTimeMillis()), 0, Clearance.LEVEL_5, new Job("test", "test", Department.AD), null, new LoginData("test", "test")));
        Assert.assertEquals((new User(true, "test", "test", new Date(System.currentTimeMillis()), 0, Clearance.LEVEL_5, new Job("test", "test", Department.AD), null, new LoginData("test", "test"))).matches(testFile.getCreator()), true);
    }

    @Test
    public void testEdit(){
        File testFile = new ObjectFile("test", Clearance.LEVEL_0, "test", new SCPObject("test", Clearance.LEVEL_0, ContainmentClass.NEUTRALIZED, DisruptionClass.DARK, RiskClass.NOTICE, SecondaryClass.BLANK), new User(true, "test", "test", new Date(System.currentTimeMillis()), 0, Clearance.LEVEL_5, new Job("test", "test", Department.AD), null, new LoginData("test", "test")));
        testFile.edit("test2");
        Assert.assertEquals("test2", testFile.getDocLink());
    }
}
