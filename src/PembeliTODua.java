public class PembeliTODua implements java.io.Serializable{
          private static final long serialVersionUID = 6529685098267757690L;

    
    private int id;
    private String nama;
    
    public PembeliTODua(){
        
    }
    
    public PembeliTODua(int id, String nama){
        this.id = id;
        this.nama = nama;
    }
    
    public int getId(){
        return id;
    }
    public String getNama(){
        return nama;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public void setNama(String nama){
        this.nama = nama;
    } 
    public String toString() {
          return this.nama;
    }
}
