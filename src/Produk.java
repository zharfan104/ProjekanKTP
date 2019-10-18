/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GL63
 */
public class Produk {
    private int id;
     private int stok;
    private String name;
    private float price;
    private String addDate;
    private byte[] picture;
       
    public Produk(int id, String name,int stok, float price, String addDate, byte[] picture) {
        this.id = id;
        this.name = name;
        this.stok = stok;
        this.price = price;
        this.addDate = addDate;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getAddDate() {
        return addDate;
    }

    public byte[] getPicture() {
        return picture;
    }
   public int getStok() {
        return stok;
    }

    
}
