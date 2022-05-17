package controller;

import java.util.List;
import javax.swing.JOptionPane;

import dao.daoKereta;
import dao.interfaceKereta;
import model.Kereta;
import view.EditKereta;
import view.viewKereta;

public class ControllerEditKereta {
    EditKereta frame;
    interfaceKereta infcKereta;
    
    public ControllerEditKereta(EditKereta frame) {
        this.frame = frame;
        infcKereta = new daoKereta();
    }
    public void tampilkanData(Kereta kereta1){
        frame.setTxtHarga(Integer.toString(kereta1.getHarga()));
        frame.setTxtKapasitas(Integer.toString(kereta1.getJumlahTempat()));
        frame.setIndexTujuan(kereta1.getTujuan());
        frame.setIndexJam(kereta1.getJamBerangkat());
    }
    public void simpanEdit(int id_kereta){
        Kereta kereta_baru = new Kereta();
        kereta_baru.setAsal(frame.getAsal());
        kereta_baru.setTujuan(frame.getTujuan());
        kereta_baru.setJamBerangkat(frame.getJamBerangkat());
        kereta_baru.setJamSampai(frame.getJamSampai());
        kereta_baru.setHarga(Integer.parseInt(frame.getTxtHarga().getText()));
        kereta_baru.setJumlahTempat(Integer.parseInt(frame.getTxtKapasitas().getText()));
        kereta_baru.setId(id_kereta);
        infcKereta.update(kereta_baru);
        JOptionPane.showMessageDialog(frame, "Berhasil Mengedit Data");
        
        kembali();
    }
    
    public void kembali(){
         frame.dispose();
        new viewKereta().setVisible(true);
    }
}
