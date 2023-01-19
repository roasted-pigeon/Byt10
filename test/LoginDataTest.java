import com.control.LoginController;
import com.company.LoginData;
import org.junit.Assert;
import org.junit.Test;

public class LoginDataTest {
    LoginController controller = new LoginController();

    @Test
    public void testCheckLoginData(){
        controller.addLoginData(new LoginData("test", "test"));
        Assert.assertFalse(controller.checkLoginData(new LoginData("test", "test2")));
        Assert.assertFalse(controller.checkLoginData(new LoginData("test2", "test2")));
        Assert.assertFalse(controller.checkLoginData(new LoginData("test2", "test")));
        Assert.assertTrue(controller.checkLoginData(new LoginData("test", "test")));
    }

    @Test
    public void testInvalidateData(){
        controller.addLoginData(new LoginData("test", "test"));
        for (int i = 0; i<4; i++) controller.checkLoginData(new LoginData("test", "test2"));
        Assert.assertFalse(controller.checkLoginData(new LoginData("test", "test2")));
    }
}
