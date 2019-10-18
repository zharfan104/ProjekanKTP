import java.util.List;
import java.rmi.*;

public interface KeretaApiInterface extends Remote {
    public void add(KeretaApiTO kereta) throws Exception;
    public void delete(int id) throws Exception;
    public void update(KeretaApiTO kereta) throws Exception;
    public List<KeretaApiTO> getAll() throws Exception;
}
