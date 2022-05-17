package model;

public class Kereta {
    private int id;
    private String asal;
    private String tujuan;
    private int jumlah_tempat;
    private int harga;
    private String jam_berangkat;
    private String jam_sampai;
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setAsal(String asal){
        this.asal = asal;
    }
    public void setTujuan(String tujuan){
        this.tujuan = tujuan;
    }
    public void setJamBerangkat(String jam_berangkat){
        this.jam_berangkat = jam_berangkat;
    }
    public void setJamSampai(String jam_sampai){
        this.jam_sampai = jam_sampai;
    }
    public void setHarga(int harga){
        this.harga = harga;
    }
    public void setJumlahTempat(int jumlah_tempat){
        this.jumlah_tempat = jumlah_tempat;
    }
    public int getId(){
        return this.id;
    }
    public String getAsal(){
        return this.asal;
    }
    public String getTujuan(){
        return this.tujuan;
    }
    public String getJamBerangkat(){
        return this.jam_berangkat;
    }
    public String getJamSampai(){
        return this.jam_sampai;
    }
    public int getHarga(){
        return this.harga;
    }
    public int getJumlahTempat(){
        return this.jumlah_tempat;
    }
}
