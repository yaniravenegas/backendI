package Dao;

import java.util.List;

public interface iDao<T> {
    //los metodos comunes al crud
    T guardar(T t);
    List<T> buscarTodos();
}
