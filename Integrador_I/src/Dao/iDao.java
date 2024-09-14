package Dao;

public interface iDao<T> {
    //metodos comunes a los crud de los objetos de logica de negocio
    //administrar datos de los odontologos y pacientes
    //listar
    T listar(T t);
    //agregar
    T agregar(T t);
    //modificar
    T modificar(T t);
    //eliminar
    T eliminar(T t);

    //registrar turno
    T registrarTurno(T t);
}
