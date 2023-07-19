import java.util.ArrayList;
import java.util.Date;

class Product {
    private String maHang;
    private String tenHang;
    private String donViTinh;
    private double donGia;
    private int soLuong;

    public Product(String maHang, String tenHang, String donViTinh, double donGia, int soLuong) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.donViTinh = donViTinh;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public void displayInfo() {
        System.out.println("Mã hàng: " + maHang);
        System.out.println("Tên hàng: " + tenHang);
        System.out.println("Đơn vị tính: " + donViTinh);
        System.out.println("Đơn giá: " + donGia);
        System.out.println("Số lượng: " + soLuong);
    }

    public double calculateTotalPrice() {
        return donGia * soLuong;
    }

    // Các phương thức hỗ trợ khác
    // ...
}

class Bill {
    private int soHoaDon;
    private String tenCongTy;
    private String maSoThue;
    private String dienThoai;
    private String tenNhanVien;
    private Date ngayHoaDon;
    private ArrayList<Product> danhSachMatHang;

    public Bill(int soHoaDon, String tenCongTy, String maSoThue, String dienThoai, String tenNhanVien, Date ngayHoaDon) {
        this.soHoaDon = soHoaDon;
        this.tenCongTy = tenCongTy;
        this.maSoThue = maSoThue;
        this.dienThoai = dienThoai;
        this.tenNhanVien = tenNhanVien;
        this.ngayHoaDon = ngayHoaDon;
        danhSachMatHang = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        danhSachMatHang.add(product);
    }

    public void displayInfo() {
        System.out.println("Số hóa đơn: " + soHoaDon);
        System.out.println("Tên công ty: " + tenCongTy);
        System.out.println("Mã số thuế: " + maSoThue);
        System.out.println("Điện thoại: " + dienThoai);
        System.out.println("Tên nhân viên: " + tenNhanVien);
        System.out.println("Ngày hóa đơn: " + ngayHoaDon);

        System.out.println("Danh sách mặt hàng:");
        for (Product product : danhSachMatHang) {
            product.displayInfo();
        }
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product product : danhSachMatHang) {
            totalPrice += product.calculateTotalPrice();
        }
        return totalPrice;
    }

    public double calculateTotalTax() {
        // Tính tổng tiền thuế (nếu có)
        // ...
        return 0;
    }

    public double finalTotalPrice() {
        return calculateTotalPrice() + calculateTotalTax();
    }

    // Các phương thức hỗ trợ khác
    // ...
}

public class Main {
    public static void main(String[] args) {
        // Tạo sản phẩm
        Product product1 = new Product("MH001", "Sản phẩm 1", "Cái", 10.5, 3);
        Product product2 = new Product("MH002", "Sản phẩm 2", "Hộp", 25.0, 2);
        Product product3 = new Product("MH003", "Sản phẩm 3", "Chai", 8.8, 5);

        // Tạo hóa đơn
        Bill bill = new Bill(123, "Siêu thị ABC", "123456789", "1234567890", "Nhân viên 1", new Date());

        // Thêm sản phẩm vào hóa đơn
        bill.addProduct(product1);
        bill.addProduct(product2);
        bill.addProduct(product3);

        // Hiển thị thông tin hóa đơn
        bill.displayInfo();

        // Tính tổng tiền hàng
        double totalPrice = bill.calculateTotalPrice();
        System.out.println("Tổng tiền hàng: " + totalPrice);

        // Tính tổng tiền hóa đơn
        double finalTotalPrice = bill.finalTotalPrice();
        System.out.println("Tổng tiền hóa đơn: " + finalTotalPrice);
    }
}
