package comp3350.movieknight.objects;

public class User
{
    private String userID;
    private String username;

    public User(String newId, String username)
    {
        userID = newId;
        this.username = username;
    }
    public String getUserID()
    {
        return (userID);
    }

    public String getUsername()
    {
        return (username);
    }

    public String toString()
    {
        return "User: " + userID + " " + username + "\n";
    }

    public boolean equals(Object object)
    {
        boolean result;
        User u;

        result = false;

        if (object instanceof User)
        {
            u = (User) object;
            if (((u.userID == null) && (userID == null)) || (u.userID.equals(userID)))
            {
                result = true;
            }
        }
        return result;
    }
}
