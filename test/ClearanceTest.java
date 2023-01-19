import com.company.Clearance;
import org.junit.Assert;
import org.junit.Test;

public class ClearanceTest {
    @Test
    public void testListClearances(){
        Assert.assertNotNull(Clearance.values());
        Assert.assertEquals(Clearance.values().length, 6);
    };
}
