
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
public class KeretaApi implements KeretaApiInterface{
    Connection connection = null;
    public KeretaApi(){
        connection = MysqlUtilityDua.getConnection();
    }
    public void add(KeretaApiTO kereta){
        Statement statement = null;
        
        try{
            statement = connection.createStatement();
            String sql = "INSERT into kereta(idkereta,namakereta) VALUES (" + kereta.getId() + ",'"+ kereta.getNama() +"')";
            if(statement.executeUpdate(sql) > 0){
                System.out.println("Berhasil Insert");
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
            String sql = "DELETE FROM kereta WHERE idkereta="+ id;
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
    public void update(KeretaApiTO kereta){
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "UPDATE kereta SET namakereta='" + kereta.getNama() + "' WHERE idkereta='" + kereta.getId() + "'";
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
    public List<KeretaApiTO> getAll(){
        Statement statement = null;
        ResultSet result = null;
        List<KeretaApiTO> list = new ArrayList<>();
        try{
            statement = connection.createStatement();
            String sql = "SELECT * FROM kereta";
            result = statement.executeQuery(sql);
            while(result.next()){
                KeretaApiTO kereta = new KeretaApiTO();
                kereta.setId(result.getInt("idkereta"));
                kereta.setNama(result.getString("namakereta"));
                list.add(kereta);
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
