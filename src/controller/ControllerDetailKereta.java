package controller;
import java.util.List;

import dao.daoKereta;
import dao.interfaceKereta;
import model.Kereta;
import view.DetailKereta;
import view.EditKereta;
import view.viewKereta;

public class ControllerDetailKereta {
    
    DetailKereta frame;
    interfaceKereta infcKereta;

    public ControllerDetailKereta(DetailKereta frame) {
        this.frame = frame;
        infcKereta = new daoKereta();
    }
    public void tampilkanData(Kereta kereta1){
        frame.setOutAsal(kereta1.getAsal());
        frame.setOutTujuan(kereta1.getTujuan());
        frame.setOutJamBerangkat(kereta1.getJamBerangkat());
        frame.setOutJamSampai(kereta1.getJamSampai());
        frame.setOutHarga(kereta1.getHarga());
        frame.setOutKapasitas(kereta1.getJumlahTempat());
    }
    public void kembali(){
        frame.dispose();
        new viewKereta().setVisible(true);
    }
    
    public void halaman_edit(Kereta kereta1){
        frame.dispose();
        new EditKereta(kereta1).setVisible(true);
    }
    
    public void hapusData(int id_kereta){
        infcKereta.delete(id_kereta);
        
        kembali();
    }
}
