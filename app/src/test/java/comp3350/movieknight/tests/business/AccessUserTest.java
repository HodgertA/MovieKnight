package comp3350.movieknight.tests.business;

import junit.framework.TestCase;

import java.util.ArrayList;

import comp3350.movieknight.application.Main;
import comp3350.movieknight.application.Services;
import comp3350.movieknight.business.AccessUser;
import comp3350.movieknight.objects.User;
import comp3350.movieknight.tests.persistence.DatabaseStub;

public class AccessUserTest extends TestCase {
    private static String dbName = Main.dbName;

    public AccessUserTest(String arg0) {
        super(arg0);
    }

    public void testGetAllUsers() {
        System.out.println("\nStarting getAllUsers tests (using stub)");

        Services.closeDataAccess();
        Services.createDataAccess(new DatabaseStub(dbName));

        AccessUser accessUser = new AccessUser();

        User user1 = new User(1, "Default User");
        User user2 = new User(2, "User2");
        User user3 = new User(3, "User3");
        User user4 = new User(5, "Another");

        ArrayList<User> users = new ArrayList<User>();
        accessUser.getAllUsers(users);

        assertEquals(4, users.size());
        assertTrue(users.contains(user1));
        assertTrue(users.contains(user2));
        assertTrue(users.contains(user3));
        assertFalse(users.contains(user4));

        Services.closeDataAccess();
        System.out.println("\nFinished getAllUsers tests (using stub)");
    }

    public void testDeleteUser() {
        System.out.println("\nStarting deleteUser tests (using stub)");

        Services.closeDataAccess();
        Services.createDataAccess(new DatabaseStub(dbName));

        AccessUser accessUser = new AccessUser();

        User user1 = new User(1, "Default User");
        User user2 = new User(2, "User2");
        User user3 = new User(3, "User3");

        ArrayList<User> users = new ArrayList<User>();
        accessUser.getAllUsers(users);

        assertEquals(4, users.size());
        assertTrue(users.contains(user1));
        assertTrue(users.contains(user2));
        assertTrue(users.contains(user3));

        accessUser.deleteUser(user1);
        accessUser.deleteUser(user2);
        accessUser.deleteUser(user3);

        users.clear();
        accessUser.getAllUsers(users);
        assertEquals(1, users.size());
        assertFalse(users.contains(user1));
        assertFalse(users.contains(user2));
        assertFalse(users.contains(user3));

        Services.closeDataAccess();
        System.out.println("\nFinished deleteUser tests (using stub)");
    }

    public void testInsertMovie() {
        System.out.println("\nStarting insertUser tests (using stub)");

        Services.closeDataAccess();
        Services.createDataAccess(new DatabaseStub(dbName));

        AccessUser accessUser = new AccessUser();

        User user4 = new User(4, "User4");

        ArrayList<User> users = new ArrayList<User>();

        accessUser.insertUser(user4);

        users.clear();
        accessUser.getAllUsers(users);
        assertEquals(4, users.size());
        assertTrue(users.contains(user4));

        accessUser.insertUser(user4);

        users.clear();
        String result = accessUser.getAllUsers(users);
        assertEquals(null, result);
        assertEquals(4, users.size());

        Services.closeDataAccess();
        System.out.println("\nFinished insertIUser tests (using stub)");
    }

    public void testUpdateMovie() {
        System.out.println("\nStarting updateMovie tests (using stub)");

        Services.closeDataAccess();
        Services.createDataAccess(new DatabaseStub(dbName));

        AccessUser accessUser = new AccessUser();

        User user1 = new User(1, "New Username");
        User user2 = new User(2, "New Username");
        User user3 = new User(3, "New Username");

        ArrayList<User> users = new ArrayList<User>();

        accessUser.updateUser(user1);
        accessUser.updateUser(user2);
        accessUser.updateUser(user3);
        accessUser.getAllUsers(users);

        assertEquals(4, users.size());
        assertTrue(users.contains(user1));
        assertEquals("New Username", users.get(0).getUsername());
        assertTrue(users.contains(user2));
        assertEquals("New Username", users.get(1).getUsername());
        assertTrue(users.contains(user3));
        assertEquals("New Username", users.get(2).getUsername());

        Services.closeDataAccess();
        System.out.println("\nFinished updateMovie tests (using stub)");
    }

    public void testGetAllFriends() {
        System.out.println("\nStarting getAllFriends tests (using stub)");

        Services.closeDataAccess();
        Services.createDataAccess(new DatabaseStub(dbName));

        AccessUser accessUser = new AccessUser();

        User user1 = new User(1, "Default User");
        User user2 = new User(2, "User2");
        User user3 = new User(3, "User3");
        User user4 = new User(4, "NoTickets");

        ArrayList<User> friends = new ArrayList<User>();
        accessUser.getAllFriends(friends, user1);

        assertEquals(3, friends.size());
        assertFalse(friends.contains(user1));
        assertTrue(friends.contains(user2));
        assertTrue(friends.contains(user3));
        assertTrue(friends.contains(user4));

        friends.clear();
        accessUser.getAllFriends(friends,user2);

        assertEquals(3, friends.size());
        assertTrue(friends.contains(user1));
        assertFalse(friends.contains(user2));
        assertTrue(friends.contains(user3));
        assertTrue(friends.contains(user4));

        friends.clear();
        accessUser.getAllFriends(friends,user3);

        assertEquals(3, friends.size());
        assertTrue(friends.contains(user1));
        assertTrue(friends.contains(user2));
        assertFalse(friends.contains(user3));

        System.out.println(friends.get(2).toString());

        assertTrue(friends.contains(user4));

        friends.clear();
        accessUser.getAllFriends(friends,user4);

        assertEquals(3, friends.size());
        assertTrue(friends.contains(user1));
        assertTrue(friends.contains(user2));
        assertTrue(friends.contains(user3));
        assertFalse(friends.contains(user4));

        Services.closeDataAccess();

        System.out.println("\nFinished getAllFriends tests (using stub)");
    }
}
