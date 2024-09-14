package Dao;

import Model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements iDao<Odontologo> {
    private static final Logger logger = Logger.getLogger(OdontologoDAOH2.class);
    private static final String SQL_INSERT = "INSERT INTO ODONTOLOGOS (MATRICULA, NOMBRE, APELLIDO) VALUES (?, ?, ?)";
    private static final String SQL_SELECT_ALL = "SELECT * FROM ODONTOLOGOS";

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("Iniciando las operaciones de guardado de un odontólogo");
        Connection connection = null;
        try {
            connection = BD.getConnection();
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
            psInsert.setString(1, odontologo.getMatricula());
            psInsert.setString(2, odontologo.getNombre());
            psInsert.setString(3, odontologo.getApellido());
            psInsert.executeUpdate();
        } catch (Exception e) {
            logger.error("Conexión fallida: " + e.getMessage());
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        logger.info("Iniciando la operación de búsqueda de todos los odontólogos");
        List<Odontologo> odontologos = new ArrayList<>();
        Connection connection = null;
        try {
            connection = BD.getConnection();
            PreparedStatement psGet = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = psGet.executeQuery();
            while (rs.next()) {
                Odontologo odontologo = new Odontologo(
                        rs.getString("matricula"),
                        rs.getString("nombre"),
                        rs.getString("apellido")
                );
                odontologos.add(odontologo);
            }
        } catch (Exception e) {
            logger.error("Conexión fallida: " + e.getMessage());
        }
        return odontologos;
    }
}

