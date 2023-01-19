import com.company.LoginData;
import com.company.Session;
import org.junit.Assert;
import org.junit.Test;

public class SessionTest {
    @Test
    public void testCheckSessionValidity(){
        Assert.assertTrue(new Session(new LoginData("test", "test")).isValid());
    }

    @Test
    public void testInvalidateSession(){
        Session temp = new Session(new LoginData("test", "test"));
        temp.invalidate();
        Assert.assertFalse(temp.isValid());
    }
}
