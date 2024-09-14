package Dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {
    private static final Logger logger = Logger.getLogger(BD.class);
    private static final String SQL_CREATE_ODONTOLOGOS = "DROP TABLE IF EXISTS ODONTOLOGOS; " +
            "CREATE TABLE ODONTOLOGOS(" +
            "MATRICULA VARCHAR(50) PRIMARY KEY, " +
            "NOMBRE VARCHAR(100) NOT NULL, " +
            "APELLIDO VARCHAR(100) NOT NULL);";

    public static void crearTablas() {
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_ODONTOLOGOS);
            logger.info("Tabla ODONTOLOGOS creada con éxito");
        } catch (Exception e) {
            logger.error("Fallo en la creación de la tabla: " + e.getMessage());
        }

}
    public static Connection getConnection() throws Exception{
    Class.forName("org.h2.Driver");
    return DriverManager.getConnection("jdbc:h2:mem:~/ClinicaOdontologicaC3","sa","sa");
}
}
