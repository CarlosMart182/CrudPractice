package interfaces;

import java.util.List;

public interface Operations <T>{
    public int create (T t);
    public int update (T t);
    public int delete (int key);
    public T read (int key);
    public List<T> readAll();
}
