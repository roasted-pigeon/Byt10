import com.company.Department;
import org.junit.Assert;
import org.junit.Test;

public class DepartmentTest {
    @Test
    public void testListDepartments(){
        Assert.assertNotNull(Department.values());
        Assert.assertEquals(Department.values().length, 14);
    };
}
