import com.company.User;
import com.control.JobController;
import com.company.Clearance;
import com.company.Department;
import com.company.Job;
import com.company.LoginData;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class JobTest {
    JobController controller = new JobController();

    @Test
    public void testListJobs(){
        controller.addJob(new Job("test", "test", Department.AD));
        controller.addJob(new Job("test2", "test2", Department.EC));
        Assert.assertEquals(controller.listJobs().size(), 2);
    }

    @Test
    public void testAssignUser(){
        User testUser = new User(true, "test", "test", new Date(System.currentTimeMillis()), 0, Clearance.LEVEL_2, new Job("test", "test", Department.AD), null, new LoginData("test", "test"));
        controller.assignJob(testUser, new Job("test2", "test2", Department.EC));
        Assert.assertEquals(testUser.getJob().matches(new Job("test2", "test2", Department.EC)), true);
    }
}
