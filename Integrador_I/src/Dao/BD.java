package Dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {
    private static final Logger logger= Logger.getLogger(BD.class);

    private static final String SQL_DROP_CREATE="DROP TABLE IF EXISTS ODONTOLOGOS" +
            "CREATE TABLE ODONTOLOGOS (ID INT PRIMARY KEY, NOMBRE VARCHAR(50) NOT NULL, APELLIDO VARCHAR(50) NOT NULL, MATRICULA INT NOT NULL" +
            "DROP TABLE IF EXISTS PACIENTES; " +
            "CREATE TABLE PACIENTES (ID INT PRIMARY KEY, NOMBRE VARCHAR(50) NOT NULL, APELLIDO VARCHAR(50) NOT NULL, DOMICILIO VARCHAR(100) NOT NULL, DNI INT NOT NULL";

    public static void crearTabla(){
        Connection connection= null;
        try{
            connection= getConnection();
            Statement statement= connection.createStatement();
            statement.execute(SQL_DROP_CREATE);
            logger.info("tabla creada con exito");
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:mem:~/DaoMedicamentos","sa","sa");
    }
}

