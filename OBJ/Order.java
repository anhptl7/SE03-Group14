package OBJ;

public class Order {
	private int mahoadon;
	private String tenthuoc;
	private int sl;
	private float tongtien;
	
	public Order() {
	}

	public Order(int mahoadon, String tenthuoc, int sl, int tongtien) {
		super();
		this.mahoadon = mahoadon;
		this.tenthuoc = tenthuoc;
		this.sl = sl;
		this.tongtien = tongtien;
	}

	public int getMahoadon() {
		return mahoadon;
	}

	public void setMahoadon(int mahoadon) {
		this.mahoadon = mahoadon;
	}

	public String getTenthuoc() {
		return tenthuoc;
	}

	public void setTenthuoc(String tenthuoc) {
		this.tenthuoc = tenthuoc;
	}

	public int getSl() {
		return sl;
	}

	public void setSl(int sl) {
		this.sl = sl;
	}

	public float getTongtien() {
		return tongtien;
	}

	public void setTongtieng(float tongtien) {
		this.tongtien = tongtien;
	}

	
	
	
}

	
