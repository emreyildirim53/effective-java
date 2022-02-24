package Item3;

public class DBConnector
{
    private static DBConnector dbConnectorInstance;

    private String url = "jdbc:postgresql://localhost:5432/jdbc";
    private String username = "root";
    private String password = "localhost";

    private DBConnector()
    {
    }

    public static DBConnector getInstance(String url, String username, String password)
    {
        if (dbConnectorInstance == null)
        {
            DBConnector dbConnector = new DBConnector();
            dbConnector.url = url;
            dbConnector.username = username;
            dbConnector.password = password;
            dbConnectorInstance = dbConnector;
        }

        return dbConnectorInstance;
    }

    @Override
    public String toString()
    {
        return "DBConnector{" +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}