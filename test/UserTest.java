import com.company.User;
import com.company.Clearance;
import com.company.Department;
import com.company.Job;
import com.company.LoginData;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class UserTest{
    User testUser = new User(true, "test", "test", new Date(System.currentTimeMillis()), 0, Clearance.LEVEL_2, new Job("test", "test", Department.AD), null, new LoginData("test", "test"));

    @Test
    public void testCreateUser(){
        Assert.assertNotNull(new User(true, "test", "test", new Date(System.currentTimeMillis()), 0, Clearance.LEVEL_2, new Job("test", "test", Department.AD), null, new LoginData("test", "test")));
    }

    @Test
    public void testViewUser(){
        Assert.assertEquals(testUser.toShortString(), "test test, Administrative Department, test");
    }

    @Test
    public void testEditUser(){
        User temp = new User(true, "test", "test", new Date(System.currentTimeMillis()), 0, Clearance.LEVEL_2, new Job("test", "test", Department.AD), null, new LoginData("test", "test"));

        testUser.editUser(false, null, null, null, -1, null, null, null, null);
        Assert.assertEquals(temp.matches(testUser), false);
        testUser.editUser(true, null, null, null, -1, null, null, null, null);
        Assert.assertEquals(temp.matches(testUser), true);
    }

    @Test
    public void testDeleteUser(){
        testUser=User.deleteUser();
        Assert.assertNull(testUser);
    }
}
