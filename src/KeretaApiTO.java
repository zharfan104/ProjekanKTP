public class KeretaApiTO implements java.io.Serializable{
    private int id;
    private String nama;
    
    public KeretaApiTO(){
        
    }
    
    public KeretaApiTO(int id, String nama){
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
}
