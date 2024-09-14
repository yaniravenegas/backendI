package Dao;

import Model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOArrayList implements iDao<Odontologo> {
    private static final Logger logger = Logger.getLogger(OdontologoDAOArrayList.class);
    private List<Odontologo> odontologos = new ArrayList<>();

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("Guardando un nuevo odontólogo: " + odontologo.getMatricula());
        odontologos.add(odontologo);
        logger.info("Odontólogo guardado exitosamente: " + odontologo);
        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        logger.info("Buscando todos los odontólogos");
        return new ArrayList<>(odontologos); // Devolver una copia de la lista para evitar modificaciones externas
    }
}
