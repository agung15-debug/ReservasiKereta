package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class tableModelKereta extends AbstractTableModel {
    List<Kereta> list_kereta;

    public tableModelKereta(List<Kereta> list_kereta) {
        this.list_kereta = list_kereta;
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public int getRowCount() {
        return list_kereta.size();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Asal";
            case 1:
                return "Tujuan";
            case 2:
                return "Jam Berangkat";
            case 3:
                return "Jam Sampai";
            case 4:
                return "Harga";
            case 5:
                return "Kapasitas";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return list_kereta.get(row).getAsal();
            case 1:
                return list_kereta.get(row).getTujuan();
            case 2:
                return list_kereta.get(row).getJamBerangkat();
            case 3:
                return list_kereta.get(row).getJamSampai();
            case 4:
                return list_kereta.get(row).getHarga();
            case 5:
                return list_kereta.get(row).getJumlahTempat();
            default:
                return null;
        }
    }
}
