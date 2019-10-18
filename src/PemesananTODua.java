public class PemesananTODua implements java.io.Serializable{
    private int id;
    private String waktukeberangkatan;
    private KeretaApiTO kereta;
    private PembeliTODua pembeli;
    private String jam;
    private String tanggal;
    
    public PemesananTODua(){
        
    }
    
    public PemesananTODua(int id, KeretaApiTO kereta, PembeliTODua pembeli, String jam, String tanggal){
        this.kereta = kereta;
        this.pembeli = pembeli;
        this.id = id;
        this.jam = jam;
        this.tanggal = tanggal;
    }
    
    public KeretaApiTO getKereta(){
        return kereta;
    }
    public PembeliTODua getPembeli(){
        return pembeli;
    }
    public int getId(){
        return id;
    }
    public String getWaktuKeberangkatan(){
        return waktukeberangkatan;
    }
    public String getJam(){
        return jam;
    }
    public String getTanggal(){
        return tanggal;
    }        
    public void setKereta(KeretaApiTO kereta){
        this.kereta = kereta;
    }
    public void setPembeli(PembeliTODua pembeli){
        this.pembeli = pembeli;
    }
    public void setId(int id){
        this.id = id;
    }
       public void setTanggal(String tanggal){
        this.tanggal = tanggal;
    }
          public void setJam(String jam){
        this.jam = jam;
    }
    public void setWaktuKeberangkatan(String waktukeberangkatan){
        this.waktukeberangkatan = waktukeberangkatan;
    }
    
}
