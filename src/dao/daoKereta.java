package dao;

import controller.Connector;
import model.Kereta;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class daoKereta implements interfaceKereta{
    Connection connection;
    final String insert = "INSERT INTO `kereta` (asal, tujuan, jam_berangkat, jam_sampai, harga, jumlah_tempat) VALUES (?, ?, ?, ?, ?, ?);";
    final String update = "UPDATE kereta SET asal=?, tujuan=?, jam_berangkat=?, jam_sampai=?, harga=?, jumlah_tempat=? WHERE id_kereta=? ;";
    final String delete = "DELETE FROM kereta WHERE id_kereta=? ;";
    final String select = "SELECT * FROM kereta ORDER BY id_kereta DESC;";
    
    public daoKereta(){
        connection = Connector.connection();
    }

    @Override
    public void insert(Kereta kereta1) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, kereta1.getAsal());
            statement.setString(2, kereta1.getTujuan());
            statement.setString(3, kereta1.getJamBerangkat());
            statement.setString(4, kereta1.getJamSampai());
            statement.setInt(5, kereta1.getHarga());
            statement.setInt(6, kereta1.getJumlahTempat());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(Kereta kereta1) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, kereta1.getAsal());
            statement.setString(2, kereta1.getTujuan());
            statement.setString(3, kereta1.getJamBerangkat());
            statement.setString(4, kereta1.getJamSampai());
            statement.setInt(5, kereta1.getHarga());
            statement.setInt(6, kereta1.getJumlahTempat());
            statement.setInt(7, kereta1.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
         PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Kereta> getData() {
        List<Kereta> listKereta = null;
        try {
            listKereta = new ArrayList<Kereta>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Kereta kereta1 = new Kereta();
                kereta1.setId(rs.getInt("id_kereta"));
                kereta1.setAsal(rs.getString("asal"));
                kereta1.setTujuan(rs.getString("tujuan"));
                kereta1.setJamBerangkat(rs.getString("jam_berangkat"));
                kereta1.setJamSampai(rs.getString("jam_sampai"));
                kereta1.setHarga(rs.getInt("harga"));
                kereta1.setJumlahTempat(rs.getInt("jumlah_tempat"));
                listKereta.add(kereta1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoKereta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listKereta;
    }
 }
