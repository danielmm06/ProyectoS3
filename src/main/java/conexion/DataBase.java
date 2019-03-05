/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Daniel
 */
public class DataBase {

    private static DataBase dbConnection = null;

    private Connection connection = null;
    private BasicDataSource poolConnections = null;

    private String SQL = "";

    public DataBase() {
        String HOST = App.HOST_DB;
        String NAME = App.NAME_DB;
        String USER = App.USER_DB;
        String PASS = App.PASS_DB;

        poolConnections = new BasicDataSource();
        poolConnections.setDriverClassName("com.mysql.jdbc.Driver");
        poolConnections.setUsername(USER);
        poolConnections.setPassword(PASS);
//                poolConnections.setUrl("jdbc:mysql://localhost:3306/prueba?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        poolConnections.setUrl("jdbc:mysql://" + HOST + "/" + NAME + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        poolConnections.setInitialSize(20);
        poolConnections.setMaxIdle(15);
        poolConnections.setMaxTotal(20);
        poolConnections.setMaxWaitMillis(5000);
    }

    //Crea una instancia de la base de datos
    public static DataBase CreateInstance() {
        if (dbConnection == null) {
            dbConnection = new DataBase();
            //System.out.println("CREATE INSTANCES");
        }
        return dbConnection;
    }

    //Abre la conexión con la base de datos
    public void OpenConnection() {
        try {
            connection = poolConnections.getConnection();
            connection.setAutoCommit(true);
            //System.out.println("OPEN CONNECTION");
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectarse a base de datos.", e);
        }
    }

    //Cierra la conexión con la base de datos
    public void CloseConnection() throws IOException {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                //System.out.println("CLOSE CONNECTION");
            } catch (SQLException e) {
                throw new RuntimeException("Error al cerrar conexión.", e);
            }
        }
    }

    //Habilita el auto commit
    public void AutoCommit() {
        try {
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectarse a base de datos.", e);
        }
    }

    //Deshabilita el auto commit
    public void NoAutoCommit() {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectarse a base de datos.", e);
        }
    }

    //Realiza commit de las sentencias ejecutadas
    public void Commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException("Error al realizar commit.", e);
        }
    }

    //Realiza rollback de las sentencias ejecutadas
    public void Rollback() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new RuntimeException("Error al realizar rollback.", e);
        }
    }

    //Método para prepara sentencias SELECT
    public PreparedStatement PreparedQuery(String SQL) throws SQLException {
        this.SQL = SQL;
        PreparedStatement pstmt = connection.prepareStatement(SQL);
        return pstmt;
    }

    //Método para preparar sentencias INSERT,UPDATE,DELETE 
    public PreparedStatement PreparedUpdate(String SQL) throws SQLException {
        this.SQL = SQL;
        PreparedStatement pstmt = connection.prepareStatement(SQL);
        return pstmt;
    }

    //Método para preparar sentencias INSERT con generación de PK
    public PreparedStatement PreparedUpdate(String SQL, String pk) throws SQLException {
        this.SQL = SQL;
        PreparedStatement pstmt = connection.prepareStatement(SQL, new String[]{pk});
        return pstmt;
    }

    //Método para sentencias SELECT sin variables bind y sin preparar sql
    public ResultSet QuerySelect(String SQL) throws SQLException {
        this.SQL = SQL;
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(SQL);
        return rs;
    }

    //Método para sentencias INSERT,UPDATE,DELETE sin variables bind y sin preparar sql
    public int QueryUpdate(String SQL) throws SQLException {
        this.SQL = SQL;
        Statement s = connection.createStatement();
        int ex = s.executeUpdate(SQL);
        return ex;
    }

    //Método para sentencias SELECT con variables bind
    public ResultSet ExecuteQuery(PreparedStatement pstmt, ArrayList<Object> input) throws SQLException {
        for (int i = 0; i < input.size(); i++) {
            String tipoDato = "";
            if (input.get(i) != null) {
                try {
                    tipoDato = "Long-Integer";
                    long inputLong = Long.parseLong(input.get(i).toString());
                    pstmt.setLong((i + 1), inputLong);
                } catch (NumberFormatException nfe) {
                    try {
                        tipoDato = "Double";
                        double inputDouble = Double.parseDouble(input.get(i).toString());
                        pstmt.setDouble((i + 1), inputDouble);
                    } catch (Exception e) {
                        try {
                            tipoDato = "Date";
//                            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                            Date date = (Date) formatter.parse(input.get(i).toString().split("\\.")[0]);
                            Date date = Date.valueOf(input.get(i).toString());
                            Timestamp inputTimestamp = new Timestamp(date.getTime());
                            pstmt.setTimestamp((i + 1), inputTimestamp);
                        } catch (Exception ex) {
                            tipoDato = "String";
                            String[] inputsString = input.get(i).toString().split("@String");
                            String inputString = "";
                            if (inputsString.length > 0) {
                                inputString = inputsString[0];
                            } else {
                                inputString = input.get(i).toString();
                            }
                            if (!inputString.equalsIgnoreCase("null") && !inputString.equalsIgnoreCase("")) {
                                pstmt.setString((i + 1), inputString);
                            } else {
                                pstmt.setObject((i + 1), null);
                            }
                        }
                    }
                }
            } else {
                pstmt.setObject((i + 1), null);
            }
            if (App.printSQL) {
                if (tipoDato.equals("Date")) {
                    this.SQL = this.SQL.replaceFirst("\\?", "TO_DATE('" + input.get(i) + "','YYYY-MM-DD HH24:MI:SS')");
                } else if (tipoDato.equals("String")) {
                    this.SQL = this.SQL.replaceFirst("\\?", "'" + ((String) input.get(i)).split("@String")[0] + "'");
                } else {
                    this.SQL = this.SQL.replaceFirst("\\?", input.get(i) + "");
                }
            }
        }
        if (App.printSQL) {
            System.out.println("SQL: " + this.SQL);
        }
        ResultSet resultQuery = pstmt.executeQuery();
        return resultQuery;
    }

    //Método para sentencias SELECT sin variables bind
    public ResultSet ExecuteQuery(PreparedStatement pstmt) throws SQLException {
        if (App.printSQL) {
            System.out.println("SQL: " + this.SQL);
        }
        ResultSet resultQuery = pstmt.executeQuery();
        return resultQuery;
    }

    //Método para sentencias INSERT, UPDATE, DELETE con variables bind
    public long ExecuteUpdate(PreparedStatement pstmt, ArrayList<Object> input) throws SQLException {
        for (int i = 0; i < input.size(); i++) {
            String tipoDato = "";
            if (input.get(i) != null) {
                try {
                    tipoDato = "Long-Integer";
                    long inputLong = Long.parseLong(input.get(i).toString());
                    pstmt.setLong((i + 1), inputLong);
                } catch (NumberFormatException nfe) {
                    try {
                        tipoDato = "Double";
                        double inputDouble = Double.parseDouble(input.get(i).toString());
                        pstmt.setDouble((i + 1), inputDouble);
                    } catch (Exception e) {
                        try {
                            tipoDato = "Date";
//                            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                            Date date = (Date) formatter.parse(input.get(i).toString().split("\\.")[0]);
                            Date date = Date.valueOf(input.get(i).toString());
                            Timestamp inputTimestamp = new Timestamp(date.getTime());
                            pstmt.setTimestamp((i + 1), inputTimestamp);
                        } catch (Exception ex) {
                            tipoDato = "String";
                            String[] inputsString = input.get(i).toString().split("@String");
                            String inputString = "";
                            if (inputsString.length > 0) {
                                inputString = inputsString[0];
                            } else {
                                inputString = input.get(i).toString();
                            }
                            if (!inputString.equalsIgnoreCase("null") && !inputString.equalsIgnoreCase("")) {
                                pstmt.setString((i + 1), inputString);
                            } else {
                                pstmt.setObject((i + 1), null);
                            }
                        }
                    }
                }
            } else {
                pstmt.setObject((i + 1), null);
            }
            //SQL
            if (tipoDato.equals("Date")) {
                this.SQL = this.SQL.replaceFirst("\\?", "TO_DATE('" + (input.get(i) + "").split("\\.", 2)[0] + "','YYYY-MM-DD HH24:MI:SS')");
            } else if (tipoDato.equals("String")) {
                this.SQL = this.SQL.replaceFirst("\\?", "'" + ((String) input.get(i)).split("@String")[0] + "'");
            } else {
                this.SQL = this.SQL.replaceFirst("\\?", input.get(i) + "");
            }
        }
        if (App.printSQL) {
            System.out.println("SQL: " + this.SQL);
        }
        long execute = pstmt.executeUpdate();
        if (execute >= 1) {
            try {
                ResultSet rs = pstmt.getGeneratedKeys();
                while (rs.next()) {
                    execute = rs.getLong(1);
                }
            } catch (SQLException e) {
            }
        }
        return execute;
    }

    //Método para sentencias INSERT, UPDATE, DELETE sin variables bind
    public long ExecuteUpdate(PreparedStatement pstmt) throws SQLException {
        if (App.printSQL) {
            System.out.println("SQL: " + this.SQL);
        }
        long execute = pstmt.executeUpdate();
        if (execute >= 1) {
            try {
                ResultSet rs = pstmt.getGeneratedKeys();
                while (rs.next()) {
                    execute = rs.getLong(1);
                }
            } catch (SQLException e) {
            }
        }
        return execute;
    }

}
