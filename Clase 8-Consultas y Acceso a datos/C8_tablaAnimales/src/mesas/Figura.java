package mesas;

import org.apache.log4j.Logger;
import presencial.Animal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Figura {
    private static final Logger logger= Logger.getLogger(Figura.class);

    public static void main(String[] args) {
        Connection connection=null;
        try{
            connection= getConnection();
            logger.info("conexion establecida");
            Statement statement= connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS FIGURAS; " +
                    "CREATE TABLE FIGURAS (ID INT PRIMARY KEY, " +
                    "FIGURA VARCHAR(20) NOT NULL, COLOR VARCHAR(20) NOT NULL)");
            //INSERTAR FIGURAS
            System.out.println("****************************Insertando************************************");
            statement.execute("INSERT INTO FIGURAS VALUES(1,'Círculo','Rojo'),(2,'Círculo','Rojo'),(3,'Cuadrado','Celeste'),(4,'Cuadrado','Azul'),(5,'Cuadrado','Amarillo')");
            //para mostrar necesito un Objeto ResultSet

            System.out.println("****************************Mostrando círculos rojos************************************");
            ResultSet rs= statement.executeQuery("SELECT * FROM FIGURAS WHERE COLOR = 'Rojo'");
            while (rs.next()){
                //mostrar por pantalla
                System.out.println("ID: "+rs.getString(1)+" | "+"Figura: "+rs.getString(2)+" | "+" Color: "+rs.getString(3));
            }
            System.out.println("****************************Mostrando todas las figuras************************************");
            rs= statement.executeQuery("SELECT * FROM FIGURAS");
            while (rs.next()){
                //mostrar por pantalla
                System.out.println("ID: "+rs.getString(1)+" | "+"Figura: "+rs.getString(2)+" | "+" Color: "+rs.getString(3));

            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:mem:~/tablaAnimales","sa","sa");
    }



}

