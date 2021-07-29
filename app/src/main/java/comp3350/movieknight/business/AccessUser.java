package comp3350.movieknight.business;

import java.util.ArrayList;

import comp3350.movieknight.application.Main;
import comp3350.movieknight.application.Services;
import comp3350.movieknight.objects.User;
import comp3350.movieknight.persistence.DataAccess;

public class AccessUser {
    private DataAccess dataAccess;

    public AccessUser()
    {
        dataAccess = Services.getDataAccess(Main.dbName);
    }

    public String getAllUsers(ArrayList<User> users) {
        return dataAccess.getAllUsers(users);
    }

    public String insertUser(User user)
    {
        return dataAccess.insertUser(user);
    }

    public String updateUser(User user)
    {
        return dataAccess.updateUser(user);
    }

    public String deleteUser(User user)
    {
        return dataAccess.deleteUser(user);
    }

    public String getAllFriends(ArrayList<User> friendList, User myself) {
        String result = dataAccess.getAllUsers(friendList);
        friendList.remove(myself);
        return result;
    }
}
