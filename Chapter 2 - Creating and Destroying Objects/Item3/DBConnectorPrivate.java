package Item3;

public class DBConnectorPrivate
{
    private static String url = "jdbc:postgresql://localhost:5432/jdbc";
    private static String username = "root";
    private static String password = "localhost";
    
    public static final DBConnectorPrivate DBConnectorInstance = new DBConnectorPrivate(url, username, password);
    
    private DBConnectorPrivate(String url, String username, String password)
    {
        this.url = url;
        this.username = username;
        this.password = password;
    }
    
}
