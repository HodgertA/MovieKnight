package comp3350.movieknight.tests.objects;

import junit.framework.TestCase;

import comp3350.movieknight.objects.User;

public class UserTest extends TestCase
{
    public UserTest(String arg0) { super(arg0); }

    public void testUser1()
    {
        User user;

        System.out.println("\nStarting testUser\n");

        user = new User("123", "John Smith");
        assertNotNull(user);
        assertTrue("123".equals(user.getUserID()));
        assertTrue("John Smith".equals(user.getUsername()));

        System.out.println("Finished testUser");
    }
}
