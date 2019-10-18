
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ShiningA
 */
public class PemesananDua implements PemesananInterfaceDua{
    Connection connection = null;
    public PemesananDua(){
        connection = MysqlUtilityDua.getConnection();
    }
    public void add(PemesananTODua pemesanan){
        Statement statement = null;
        
         try{
            statement = connection.createStatement();
            String sql = "INSERT into kereta(idkereta, namakereta) VALUES ("+ (pemesanan.getId()+20) +",\'"+pemesanan.getKereta().getNama()+ "\')";
            System.out.println(sql);
            if(statement.executeUpdate(sql) > 0){
                System.out.println("Berhasil Insert 1");
            }else{
                System.out.println("Gagal Insert");
            }
        }catch(SQLException ex){
            System.out.println("ex:" + ex.getMessage());
        }finally{
            if(statement != null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    System.out.println("ex:" + ex.getMessage());
                }
            }
        }
         
         
          try{
            statement = connection.createStatement();
            String sql = "INSERT into pembeli(idpembeli, namapembeli) VALUES ("+ (pemesanan.getId()+10) +",\'"+pemesanan.getPembeli().getNama()+ "\')";
            System.out.println(sql);
            if(statement.executeUpdate(sql) > 0){
                System.out.println("Berhasil Insert 2");
            }else{
                System.out.println("Gagal Insert");
            }
        }catch(SQLException ex){
            System.out.println("ex:" + ex.getMessage());
        }finally{
            if(statement != null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    System.out.println("ex:" + ex.getMessage());
                }
            }
        }
        
        
        
        
        
        try{
            statement = connection.createStatement();
            String sql = "INSERT into pemesanan(idpemesanan, idpembeli, idkereta, jam, tanggal) VALUES ("+ pemesanan.getId() +","+ (pemesanan.getId()+10) +","+ (pemesanan.getId()+20) + ",\'"+ pemesanan.getJam() +"\',\'"+ pemesanan.getTanggal()+"\')";
            System.out.println(sql);
            if(statement.executeUpdate(sql) > 0){
                System.out.println("Berhasil Insert 3");
            }else{
                System.out.println("Gagal Insert");
            }
        }catch(SQLException ex){
            System.out.println("ex:" + ex.getMessage());
        }finally{
            if(statement != null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    System.out.println("ex:" + ex.getMessage());
                }
            }
        }
    }
    public void delete(int id){
        Statement statement = null;
        try{
            statement = connection.createStatement();
            String sql = "DELETE FROM pemesanan WHERE idpemesanan="+ id;
            if(statement.executeUpdate(sql) > 0){
                System.out.println("Berhasil DELETE");
            }else{
                System.out.println("Gagal DELETE");
            }
        }catch(SQLException ex){
            System.out.println("ex:" + ex.getMessage());
        }finally{
            if(statement != null){
                try{
                    statement.close();
                }catch(SQLException ex){
                    System.out.println("ex:" + ex.getMessage());
                }
            }
        }
    }
    public void update(PemesananTODua pemesanan){
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "UPDATE pemesanan SET idpembeli='" + pemesanan.getPembeli().getId() + "',idkereta='"+ pemesanan.getKereta().getId() +"'WHERE idpemesanan='" + pemesanan.getId() + "'";
            if (statement.executeUpdate(sql) > 0) {
                System.out.println("Berhasil update");
            } else {
                System.out.println("Gagal update");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    System.out.println("Gagal menutup statement");
                }
            }
        }        
    }
     public List<PemesananTODua> getAll(){
        Statement statement = null;
        ResultSet result = null;
        List<PemesananTODua> list = new ArrayList<>();
        try{
            statement = connection.createStatement();
            String sql = "SELECT * FROM pemesanan JOIN pembeli ON pemesanan.idpembeli=pembeli.idpembeli JOIN kereta ON pemesanan.idkereta=kereta.idkereta ORDER BY idpemesanan ASC";
            result = statement.executeQuery(sql);
            while(result.next()){
                PembeliTODua pembeli = new PembeliTODua(0,"");
                KeretaApiTO kereta = new KeretaApiTO(0,"");
                pembeli.setId(result.getInt("pembeli.idpembeli"));
                pembeli.setNama(result.getString("pembeli.namapembeli"));
                kereta.setId(result.getInt("kereta.idkereta"));
                kereta.setNama(result.getString("kereta.namakereta"));
                PemesananTODua pemesanan = new PemesananTODua(0,kereta,pembeli, "0","0");
                pemesanan.setId(result.getInt("pemesanan.idpemesanan"));
                   pemesanan.setWaktuKeberangkatan(result.getString("pemesanan.waktukeberangkatan"));
                   pemesanan.setJam(result.getString("pemesanan.jam"));
                   pemesanan.setTanggal(result.getString("pemesanan.tanggal"));
                   
                   
                   System.out.println(result.getString("pemesanan.waktukeberangkatan"));
                list.add(pemesanan);
            }
            return list;
        }catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("Objek Statement berhasil dibuat");
            System.out.println("Objek Statement gagal dibuat");
            return null;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    System.out.println("Gagal menutup statement");
                }
            }
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    System.out.println("ResultSet gagal ditutup");
                }
            }
        }
    }
}
