package controller;

import java.util.List;

import dao.daoKereta;
import dao.interfaceKereta;
import model.Kereta;
import model.tableModelKereta;
import view.viewKereta;
import view.InputKereta;
import view.DetailKereta;

public class ControllerKereta {
    viewKereta frame;
    interfaceKereta infcKereta;
    List<Kereta> list_kereta;
    
    public ControllerKereta(viewKereta frame) {
        this.frame = frame;
        infcKereta= new daoKereta();
        list_kereta = infcKereta.getData();
    }
    
    public void load_table() {
        tableModelKereta tmk = new tableModelKereta(list_kereta);
        frame.getTabelKereta().setModel(tmk);
    }
    
    public void halaman_tambah(){
        frame.dispose();
        new InputKereta().setVisible(true);
    }
    
    public void halaman_detail(int row){
        Kereta kereta1 = list_kereta.get(row);
        frame.dispose();
        new DetailKereta(kereta1).setVisible(true);
    }
}
