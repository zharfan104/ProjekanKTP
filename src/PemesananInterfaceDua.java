import java.util.List;
import java.rmi.*;

public interface PemesananInterfaceDua extends Remote {
    public void add(PemesananTODua pemesanan) throws Exception;
    public void delete(int id) throws Exception;
    public void update(PemesananTODua pemesanan) throws Exception;
    public List<PemesananTODua> getAll() throws Exception;
}
