import java.lang.String;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class cau1 {
    public static void main(String arg[]) throws ParseException {
        Data data = new Data();
        data.nhapDanhSachNhanVien();
        data.xuatLuong();
    }
}
abstract class NhanVien
{
    protected String hoTen;
    protected Date ngaySinh;
    protected int luong;

    public abstract void tinhLuong();
    public abstract void nhapThongTin() throws ParseException;
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public String getHoTen() {
        return hoTen;
    }
    public Date getNgaySinh() {
        return ngaySinh;
    }
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public int getLuong() {
        return luong;
    }
}
class NhanVienVP extends  NhanVien
{
    private int soNgayLam;
    public void tinhLuong() {
        luong =  soNgayLam * 100000;
    }
    public void setSoNgayLam(int soNgayLam) {
        this.soNgayLam = soNgayLam;
    }
    public void nhapThongTin() throws ParseException {
        System.out.print("Nhap ten: ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("Nhap ngay sinh (dd-mm-yyyy): ");
        String temp = new Scanner(System.in).nextLine();
        SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
        Date birth = format.parse(temp);
        int _temp =-1;
            while (_temp < 0) {
                System.out.print("Nhap so ngay lam: ");
                _temp = new Scanner(System.in).nextInt();
            }
        this.soNgayLam = _temp;
        this.hoTen = name;
        this.ngaySinh = birth;
    }
}
class NhanVienSX extends NhanVien
{
    private int luongCanBan, soSP;
    public void tinhLuong() {
        luong =  luongCanBan + soSP * 5000;
    }
    public void nhapThongTin() throws ParseException {
        System.out.print("Nhap ten: ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("Nhap ngay sinh (dd-mm-yyyy): ");
        String temp = new Scanner(System.in).nextLine();
        SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
        Date birth = format.parse(temp);

        int _temp = -1;
        while (_temp < 0)
        {
            System.out.print("Nhap luong co ban: ");
            _temp = new Scanner(System.in).nextInt();
        }
        this.luongCanBan = _temp;
        this.hoTen= name;
        this.ngaySinh=birth;

        _temp=-1;
        while (_temp <= 0)
        {
            System.out.print("Nhap so san pham lam duoc: ");
            _temp = new Scanner(System.in).nextInt();
        }
        this.soSP = _temp;
    }
    public void setLuongCanBan(int luongCanBan) {
        this.luongCanBan = luongCanBan;
    }
    public void setSoSP(int soSP) {
        this.soSP = soSP;
    }

}
class Data
{
    private NhanVien[] lstNhanVien;
    private int soNhanVien;
    public void nhapDanhSachNhanVien() throws ParseException {
        System.out.print("Nhap so luong nhan vien: ");
        soNhanVien = new Scanner(System.in).nextInt();
        lstNhanVien = new NhanVien[soNhanVien];
        int check;
        for (int i = 0; i < soNhanVien; i++) {
            check = -1;
            while (check != 2 || check != 1) {
                System.out.print("Loai nhan vien:\n1.Nhan vien van phong\n2.Nhan vien san xuat\n");
                check = new Scanner(System.in).nextInt();
                if (check == 1)
                {
                    lstNhanVien[i] = new NhanVienVP();
                    break;
                }
                if (check == 2)
                {
                    lstNhanVien[i] = new NhanVienSX();
                    break;
                }
            }
            lstNhanVien[i].nhapThongTin();
            lstNhanVien[i].tinhLuong();
        }
    }
    public void xuatLuong()
    {
        for (NhanVien i: lstNhanVien) {
            System.out.println("Ho ten: "+i.getHoTen());
            System.out.println("Ngay sinh: "+ i.getNgaySinh());
            System.out.println("Luong: "+i.getLuong());
        }
    }

}