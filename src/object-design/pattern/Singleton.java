

public class Connection {

    private static Connection conn;

    private Connection() {

    }

    public static Connection getConnection() {
        if(conn == null) {
            conn = new Connection();
        }

        return conn;
    }
}
