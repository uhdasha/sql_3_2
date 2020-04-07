package ru.netology;

import java.sql.*;
import java.util.HashMap;

public class MysqlConn {
    private static final String url = "jdbc:mysql://localhost:3306/netology?serverTimezone=UTC";
    private static final String user = "netology";
    private static final String password = "pass_0000";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public HashMap<String, String> passCorespond = new HashMap<String, String>();

    public String code;
    public String pass;
    public static final String login = "hacker";


    public MysqlConn() {
        String queryUser = "select * from users limit 1";
        passCorespond.put("$2a$10$.MxwJLfnw7bW2fE/LDnnheNfg..vem1zzhZL0VYwozij4KEIe7IgO", "qwerty123");

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
            // getting Statement object to execute query
            stmt = con.createStatement();
            // executing SELECT query

            rs = stmt.executeQuery(queryUser);
            rs.next();
            String id = rs.getString(1);
            this.pass = passCorespond.get(rs.getString(3));

            PreparedStatement st = con.prepareStatement("UPDATE users SET login = ? WHERE id = ?");
            st.setString(1, login);
            st.setString(2, id);
            st.executeUpdate();

            con.close();
            stmt.close();
            rs.close();

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public void getCodeSec() {
        String query = "select * from auth_codes order by created asc";
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
            // getting Statement object to execute query
            stmt = con.createStatement();
            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                this.code = rs.getString(3);
                //System.out.println(this.code);
            }

            con.close();
            stmt.close();
            rs.close();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

}
