package Service;

import Dao.OdontologoDAOH2;
import Dao.iDao;
import Model.Odontologo;

import java.util.List;

public class OdontologoService {
    private iDao<Odontologo> odontologoiDao;

    public OdontologoService() {
        odontologoiDao = new OdontologoDAOH2();
    }

    // Método para agregar un nuevo odontólogo
    public Odontologo add(String matricula, String nombre, String apellido) {
        Odontologo odontologo = new Odontologo(matricula, nombre, apellido);
        return odontologoiDao.guardar(odontologo);
    }

    // Método para obtener todos los odontólogos
    public List<Odontologo> buscarTodos() {
        return odontologoiDao.buscarTodos();
    }
}
