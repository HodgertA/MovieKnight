package comp3350.movieknight.objects;

public class User
{
    private int userID;
    private String username;

    public User(int newId, String username)
    {
        if (newId >= 0) {
            userID = newId;
            this.username = username;
        } else {
            throw new IllegalArgumentException();
        }
    }
    public int getUserID()
    {
        return userID;
    }

    public String getUsername()
    {
        return username;
    }

    public String toString()
    {
        return "User: " + userID + " " + username;
    }

    public boolean equals(Object object)
    {
        boolean result;
        User u;

        result = false;

        if (object instanceof User)
        {
            u = (User) object;
            if ((u.userID == userID))
            {
                result = true;
            }
        }
        return result;
    }
}
