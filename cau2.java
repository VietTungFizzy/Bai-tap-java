import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class cau2
{
    public static void main(String arg[])
    {
        HinhHoc lstHinhHoc[];
        double dienTichHinh[];
        int n,check;
        System.out.print("Nhap so hinh: ");
        n = new Scanner(System.in).nextInt();
        lstHinhHoc = new HinhHoc[n];
        dienTichHinh = new double[n];
        for (int i = 0 ; i<n; i++) {
            check =-1;
            while (check != 1 ||check != 2 ||check != 3) {
                System.out.print("Loai hinh hoc:\n1.Hinh tron\n2.Hinh vuong\n3.Hinh chu nhat\n ");
                check = new Scanner(System.in).nextInt();
                if (check ==1)
                {
                    lstHinhHoc[i] = new HinhTron();
                    break;
                }
                if (check == 2)
                {
                    lstHinhHoc[i] = new HinhVuong();
                    break;
                }
                if (check == 3)
                {
                    lstHinhHoc[i] = new HinhChuNhat();
                    break;
                }
            }
            lstHinhHoc[i].nhap();
            lstHinhHoc[i].tinhDienTich();
            dienTichHinh[i] = lstHinhHoc[i].getDienTich();
        }

        Arrays.sort(dienTichHinh);
        System.out.print("Dien tich lon nhat: " + dienTichHinh[n-1]);
    }
}
abstract class HinhHoc
{
    protected double chuVi;
    protected double dienTich;
    public abstract void nhap();
    public abstract void xuat();
    public abstract void tinhChuVi();
    public abstract void tinhDienTich();

    public double getDienTich() {
        return dienTich;
    }
}
class HinhTron extends HinhHoc
{
    private double banKinh;
    @Override
    public void nhap() {
        banKinh = -1;
        while (banKinh <= 0) {
            System.out.print("Nhap ban kinh: ");
            banKinh = new Scanner(System.in).nextDouble();
        }
    }

    @Override
    public void xuat() {
        System.out.println("Ban kinh: " + banKinh);
        System.out.println("Dien tich: "+dienTich);
        System.out.println("Chu vi: "+chuVi);
    }

    @Override
    public void tinhChuVi() {
        chuVi = 2 * Math.PI * banKinh;
    }

    @Override
    public void tinhDienTich() {
        dienTich = Math.PI * banKinh * banKinh;
    }


}
class HinhVuong extends HinhHoc
{
    private double canh;
    @Override
    public void nhap() {
        canh = -1;
        while (canh <= 0) {
            System.out.print("Nhap canh: ");
            canh = new Scanner(System.in).nextDouble();
        }
    }

    @Override
    public void xuat() {
        System.out.println("Do dai canh: " + canh);
        System.out.println("Dien tich: "+dienTich);
        System.out.println("Chu vi: "+chuVi);
    }

    @Override
    public void tinhChuVi() {
        chuVi = canh * 4;
    }

    @Override
    public void tinhDienTich() {
        dienTich = canh * canh;
    }


}
class HinhChuNhat extends HinhHoc
{
    private double chieuDai;
    private double chieuRong;
    @Override
    public void nhap() {
        chieuDai =-1;
        chieuRong =-1;
        while (chieuDai <= 0 || chieuRong <= 0)
        {
            System.out.print("Nhap chieu dai: ");
            chieuDai = new Scanner(System.in).nextDouble();
            System.out.print("Nhap chieu rong: ");
            chieuRong = new Scanner(System.in).nextDouble();
        }
    }

    @Override
    public void xuat() {
        System.out.println("Chieu dai: " + chieuDai);
        System.out.println("Chieu rong: " + chieuRong);
        System.out.println("Dien tich: "+dienTich);
        System.out.println("Chu vi: "+chuVi);
    }
    public  void tinhChuVi()
    {
        chuVi = (chieuDai+chieuRong)*2;
    }
    public  void tinhDienTich()
    {
        dienTich = chieuDai * chieuRong;
    }
}

