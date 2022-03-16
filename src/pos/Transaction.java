package pos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import pos.entity.Product;

public class Transaction {
	private String time;
	private List<Product> product = new ArrayList<Product>();
	private int totalPrice;
	private boolean cash;
	private boolean isRefunded;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<Product> getProduct() {
		return product;
	}

	public Transaction(String time, List<Product> product, int totalPrice, boolean cash, boolean isRefunded) {
		super();
		this.time = time;
		this.product = product;
		this.totalPrice = totalPrice;
		this.cash = cash;
		this.isRefunded = isRefunded;
	}

	public Transaction() {
		
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean getIsRefunded() {
		return isRefunded;
	}

	public void setIsRefunded(boolean isRefunded) {
		this.isRefunded = isRefunded;
	}

	public String toString() {
		String format = String.format("\n%20s\n\nDate : %s\n\n", "Transaction", time);
		
		for(Product pr : product) {
			format += pr.PrintList()+"\n";
		}
		
		format += String.format("\nRefund : %s\n\n", String.valueOf(isRefunded));
		return format;
	}
	
	public boolean isCash() {
		return cash;
	}

	public void setCash(boolean cash) {
		this.cash = cash;
	}

	public String[] toArray() {
		String[] name = new String[product.size()];
		int i = 0;
		for(Product p : product) {
			name[i]=p.getName();
			i++;
		}
		
		String st = (String)Arrays.toString(name).substring(1,Arrays.toString(name).length()-1);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
		String[] a= {null,st, Integer.toString(totalPrice),isRefunded==true?"O":"X",time};
		return a;
	}
}