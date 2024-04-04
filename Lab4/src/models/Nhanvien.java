
package models;

public class Nhanvien {
    private String MaNV ;
    private String Hoten ;
    private String Gioitinh ;
    private String ChucVu ;

    public Nhanvien() {
    }

    public Nhanvien(String MaNV, String Hoten, String Gioitinh, String ChucVu) {
        this.MaNV = MaNV;
        this.Hoten = Hoten;
        this.Gioitinh = Gioitinh;
        this.ChucVu = ChucVu;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public String getGioitinh() {
        return Gioitinh;
    }

    public void setGioitinh(String Gioitinh) {
        this.Gioitinh = Gioitinh;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }
    
}
