import java.util.List;
import java.rmi.*;

public interface PembeliInterfaceDua extends Remote {
    public void add(PembeliTO pembeli) throws Exception;
    public void delete(int id) throws Exception;
    public void update(PembeliTO pembeli) throws Exception;
    public List<PembeliTO> getAll() throws Exception;
}
