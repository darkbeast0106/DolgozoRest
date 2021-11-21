package com.example.dolgozodemo.models;

import com.example.dolgozodemo.core.MysqlDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DolgozoDB extends MysqlDB {

    public DolgozoDB() throws SQLException {
        super("dolgozok");
    }

    public List<Dolgozo> getDolgozok() throws SQLException {
        List<Dolgozo> dolgozok = new ArrayList<>();
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM dolgozok");
        while (result.next()){
            int id = result.getInt("id");
            String nev = result.getString("nev");
            String nem = result.getString("nem");
            int kor = result.getInt("kor");
            int fizetes = result.getInt("fizetes");
            Dolgozo d = new Dolgozo(id,nev,nem,kor,fizetes);
            dolgozok.add(d);
        }
        return dolgozok;
    }

    public int deleteDolgozo(int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM dolgozok WHERE id = ?");
        stmt.setInt(1,id);
        return stmt.executeUpdate();
    }

    public int insertDolgozo(String nev, String nem, int kor, int fizetes) throws SQLException {
        String sql = "INSERT INTO dolgozok(nev,nem,kor,fizetes) VALUES(?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1,nev);
        stmt.setString(2,nem);
        stmt.setInt(3,kor);
        stmt.setInt(4,fizetes);
        return stmt.executeUpdate();
    }

    public int updateDolgozo(int id, String nev, String nem, int kor, int fizetes) throws SQLException {
        String sql = "UPDATE dolgozok SET nev = ?, nem = ?, kor = ?, fizetes = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1,nev);
        stmt.setString(2,nem);
        stmt.setInt(3,kor);
        stmt.setInt(4,fizetes);
        stmt.setInt(5,id);
        return stmt.executeUpdate();
    }
}

