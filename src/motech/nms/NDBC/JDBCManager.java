package motech.nms.NDBC;

import java.sql.*;
import java.util.List;
import java.util.Map;


/**
 * For Future Use
 * class DriverInfo {

    private String DriverClass;
    private String url;
    private String username;
    private String password;

    public DriverInfo(String driverClass, String url, String username,
            String password) {
        DriverClass = driverClass;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String getDriverClass() {
        return DriverClass;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}**/

public class JDBCManager {

    /**
     * For Future Use
     * public static Connection getConnection(DriverInfo driverInfo) {
        Connection con = null;
        try {
            Class.forName(driverInfo.getDriverClass());
            con = DriverManager.
                    getConnection(driverInfo.getUrl(), driverInfo.getUsername(),
                            driverInfo.getPassword());
        } catch (SQLException e) {

        } catch (ClassNotFoundException cnf) {

        }
        return con;

    }

    public static int JDBCSelectId(Connection con, String query,
            Map<Integer, Integer> params) {

        PreparedStatement prSt = null;
        int result = 0;
        try {

            prSt = con.prepareStatement(query);
            for (Integer count : params.keySet()) {
                prSt.setLong(count, params.get(count));
            }
            //count will give you how many records got updated
            int count = prSt.executeUpdate();
            if (count < 1) {
                ResultSet resultSet = prSt.executeQuery();
                while (resultSet.next()) {
                    result = resultSet.getInt("ID");
                }
            } else {
                System.out.println(
                        "Please Check Query. It's bringing more than one results.");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (prSt != null)
                    prSt.close();
            } catch (Exception ex) {
            }
        }
        return result;
    }

    public static void close(Connection con) {
        try {
            if (con != null)
                con.close();
        } catch (SQLException e) {

        }

    }

**/
}
