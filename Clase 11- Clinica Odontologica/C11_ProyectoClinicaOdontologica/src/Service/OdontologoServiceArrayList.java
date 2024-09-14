
package Service;

import Dao.iDao;
import Dao.OdontologoDAOArrayList;
import Model.Odontologo;

import java.util.List;

public class OdontologoServiceArrayList {
    private iDao<Odontologo> odontologoiDao;

    public OdontologoServiceArrayList() {
        this.odontologoiDao = new OdontologoDAOArrayList();
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
