package comp3350.movieknight.application;

import comp3350.movieknight.persistence.DatabaseStub;

public class Services {

    private static DatabaseStub dataAccessService = null;

    public static DatabaseStub createDataAccess(String dbName)
    {
        if (dataAccessService == null) {
            dataAccessService = new DatabaseStub(dbName);
            dataAccessService.open(Main.dbName);
        }
        return dataAccessService;
    }

    public static DatabaseStub getDataAccess(String dbName)
    {
        if (dataAccessService == null) {
            System.out.println("Connection to data access has not been established.");
            System.exit(1);
        }
        return dataAccessService;
    }

    public static void closeDataAccess()
    {
        if (dataAccessService != null) {
            dataAccessService.close();
        }
        dataAccessService = null;
    }
}
