package comp3350.movieknight.application;

public class Main {

    public static final String dbName="DB";

    public static void main(String[] args)
    {
        startUp();

        //run the application here

        shutDown();
        System.out.println("All done");
    }

    public static void startUp()
    {
        Services.createDataAccess(dbName);
    }

    public static void shutDown()
    {
        Services.closeDataAccess();
    }
}
