public class PemesananTO implements java.io.Serializable{
    private int id;
    private String waktukeberangkatan;
    private PesawatTO pesawat;
    private PembeliTO pembeli;
    private String jam;
    private String tanggal;
          private static final long serialVersionUID = 6529685098267757690L;

    public PemesananTO(){
        
    }
    
    public PemesananTO(int id, PesawatTO pesawat, PembeliTO pembeli, String jam, String tanggal){
        this.pesawat = pesawat;
        this.pembeli = pembeli;
        this.id = id;
        this.jam = jam;
        this.tanggal = tanggal;
    }
    
    public PesawatTO getPesawat(){
        return pesawat;
    }
    public PembeliTO getPembeli(){
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
    public void setPesawat(PesawatTO pesawat){
        this.pesawat = pesawat;
    }
    public void setPembeli(PembeliTO pembeli){
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
