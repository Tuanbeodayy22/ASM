/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;
import java.sql.*;
import java.util.ArrayList;
import models.Nhanvien;
import utils.DbConnection;
/**
 *
 * @author tuanb
 */
public class Nhanvienrepositories {
    private Connection conn;
    public Nhanvienrepositories (){
       this.conn=DbConnection.getConnection();
    }
    public ArrayList<Nhanvien> serach(String keyword){
        String SQL = "SELECT * FROM NhanVien";
        if(keyword.trim().length() !=0){
            SQL += " WHERE MaNhanVien LIKE ? OR HoTen LIKE ? OR GioiTinh LIKE ? OR ChucVu LIKE ?";
        }
        ArrayList<Nhanvien> ds = new ArrayList<>();
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            if(keyword.trim().length() !=0){
                ps.setString(1, "%"+keyword+"%");
                ps.setString(2, "%"+keyword+"%");
                ps.setString(3, "%"+keyword+"%");
                ps.setString(4, "%"+keyword+"%");
            }
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()){
                String MaNV = rs.getString("MaNhanVien") ;
                String Hoten = rs.getString("HoTen");
                String Gioitinh = rs.getString("GioiTinh");
                String ChucVu = rs.getString("ChucVu"); 
                Nhanvien nv = new Nhanvien(MaNV, Hoten, Gioitinh, ChucVu);
                ds.add(nv);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
    public void them(Nhanvien nv){
         String SQL = "INSERT INTO Nhanvien (MaNhanVien,HoTen,ChucVu,GioiTinh)Values (?,?,?,?)";
         try {
             PreparedStatement ps = this.conn.prepareStatement(SQL);
             ps.setString(1, nv.getMaNV());
             ps.setString(2, nv.getHoten());
             ps.setString(3, nv.getChucVu());
             ps.setString(4, nv.getGioitinh());
             ps.execute();
                        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void sua(Nhanvien nv){
        String SQL = "UPDATE Nhanvien SET HoTen=? ChucVu = ? GioiTinh = ? Where MaNhanVien=? ";
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            ps.setString(1, nv.getHoten());
            ps.setString(2, nv.getChucVu());
            ps.setString(3, nv.getGioitinh());
            ps.setString(4, nv.getMaNV());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void xoa(Nhanvien nv){
        String SQL = "DELETE FROM Nhanvien Where MaNhanVien=?";
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            ps.setString(1, nv.getMaNV());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
