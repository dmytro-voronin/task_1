package internship;

import org.junit.Assert;
import org.junit.Test;

public class ObjectClonerTest {

    @Test
    public void testCloneManager() {
        Manager original = new Manager("Jane", "Smith", 2);
        original.setSalaryRate(6000);
        original.setWorkedHours(160);

        Manager cloned = ObjectCloner.cloneObject(original);

        Assert.assertNotSame(original, cloned);
        if (cloned != null) {
            Assert.assertEquals(original.getFirstName(), cloned.getFirstName());
        }
        Assert.assertEquals(original.getLastName(), cloned.getLastName());
        Assert.assertEquals(original.getId(), cloned.getId());
        Assert.assertEquals(original.getSalaryRate(), cloned.getSalaryRate(), 0);
        Assert.assertEquals(original.getWorkedHours(), cloned.getWorkedHours());
    }

    @Test
    public void testCloneProgrammer() {
        Programmer original = new Programmer("Alice", "Johnson", 3);
        original.setSalaryRate(7000);
        original.setWorkedHours(160);

        Programmer cloned = ObjectCloner.cloneObject(original);

        Assert.assertNotSame(original, cloned);
        Assert.assertEquals(original.getFirstName(), cloned.getFirstName());
        Assert.assertEquals(original.getLastName(), cloned.getLastName());
        Assert.assertEquals(original.getId(), cloned.getId());
        Assert.assertEquals(original.getSalaryRate(), cloned.getSalaryRate(), 0);
        Assert.assertEquals(original.getWorkedHours(), cloned.getWorkedHours());
    }

    @Test
    public void testCloneWithNullFields() {
        Manager original = new Manager();
        original.setSalaryRate(5000);
        original.setWorkedHours(160);

        Manager cloned = ObjectCloner.cloneObject(original);

        Assert.assertNotSame(original, cloned);
        Assert.assertNull(cloned.getFirstName());
        Assert.assertNull(cloned.getLastName());
        Assert.assertEquals(original.getSalaryRate(), cloned.getSalaryRate(), 0);
        Assert.assertEquals(original.getWorkedHours(), cloned.getWorkedHours());
    }
}
