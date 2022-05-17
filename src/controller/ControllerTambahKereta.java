
package controller;

import java.util.List;
import javax.swing.JOptionPane;

import dao.daoKereta;
import dao.interfaceKereta;
import model.Kereta;
import view.viewKereta;
import view.InputKereta;

public class ControllerTambahKereta {
    InputKereta frame;
    interfaceKereta infcKereta;

    public ControllerTambahKereta(InputKereta frame) {
        this.frame = frame;
        infcKereta = new daoKereta();
    }
    public void TambahKereta(){
        Kereta kereta_baru = new Kereta();
        kereta_baru.setAsal(frame.getAsal());
        kereta_baru.setTujuan(frame.getTujuan());
        kereta_baru.setJamBerangkat(frame.getJamBerangkat());
        kereta_baru.setJamSampai(frame.getJamSampai());
        kereta_baru.setHarga(Integer.parseInt(frame.getTxtHarga().getText()));
        kereta_baru.setJumlahTempat(Integer.parseInt(frame.getTxtKapasitas().getText()));
        
        infcKereta.insert(kereta_baru);
        JOptionPane.showMessageDialog(frame, "Berhasil menambahkan data baru");
        
        kembali();
    }
    public void kembali(){
         frame.dispose();
        new viewKereta().setVisible(true);
    }
    public void kosongkan_form(){
        frame.setJurusan(0);
        frame.setJam(0);
        frame.setTxtHarga("");
        frame.setTxtKapasitas("");
    }
}
