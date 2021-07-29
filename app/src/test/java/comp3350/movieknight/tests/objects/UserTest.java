package comp3350.movieknight.tests.objects;

import junit.framework.TestCase;

import comp3350.movieknight.objects.User;

public class UserTest extends TestCase {
    public UserTest(String arg0) { super(arg0); }

    public void testTypicalUser() {
        System.out.println("Starting User test: testTypicalUser");

        User user = new User(123, "John Smith");
        assertNotNull(user);
        assertEquals(123, user.getUserID());
        assertEquals("John Smith", user.getUsername());
        assertEquals("John Smith", user.toString());
        assertEquals(user,user);

        System.out.println("Finished User test: testTypicalUser");
    }

    public void testEmptyValues() {
        System.out.println("Starting User test: testEmptyValues");

        User user = new User(1, "");
        assertNotNull(user);
        assertEquals(1, user.getUserID());
        assertEquals("", user.getUsername());
        assertEquals("", user.toString());
        assertEquals(user,user);

        System.out.println("Finished User test: testEmptyValues");
    }

    public void testTwoUsers() {
        System.out.println("Starting User test: testTwoUsers");

        User user1 = new User(123, "John Smith");
        User user2 = new User(456, "Bob Jones");
        assertNotNull(user1);
        assertNotNull(user2);
        assertEquals(123, user1.getUserID());
        assertEquals(456, user2.getUserID());
        assertEquals("John Smith", user1.getUsername());
        assertEquals("Bob Jones", user2.getUsername());
        assertEquals("John Smith", user1.toString());
        assertEquals("Bob Jones", user2.toString());
        assertFalse(user1.equals(user2));

        System.out.println("Finished User test: testTwoUsers");
    }

    public void testNullValues() {
        System.out.println("Starting User test: testNullValues");

        User user = new User(1, null);
        assertNotNull(user);
        assertEquals(1, user.getUserID());
        assertNull(user.getUsername());
        assertNull(user.toString());
        assertEquals(user,user);

        System.out.println("Finished User test: testNullValues");
    }

    public void testEdgeCases() {
        System.out.println("Starting User test: testEdgeCases");

        User user = new User(0, "    J");
        assertNotNull(user);
        assertEquals(0, user.getUserID());
        assertEquals("    J", user.getUsername());
        assertEquals("    J", user.toString());
        assertEquals(user,user);

        System.out.println("Finished User test: testEdgeCases");
    }

    public void testInvalidValues() {
        System.out.println("Starting User test: testInvalidValues");
        try {
            User user = new User(-1, "Bob Jones");
            fail("Expected an IllegalArguementException");
        } catch (IllegalArgumentException ex) { }

        System.out.println("Finished User test: testInvalidValues");
    }
}
