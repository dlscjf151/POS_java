package pos;

import java.awt.event.FocusEvent.Cause;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import pos.entity.Food;
import pos.entity.NonFood;
import pos.entity.Product;
import pos.stock.Stock;

public class POS {
	private History history = new History();
	private Stock stock = new Stock();
	private Cash cash;
	
	private String info_store;

	public POS(String info_store, int cash) {
		this.info_store = info_store;
		this.cash = new Cash(cash);
		
	}

	public List<Product> SellProduct(List<Product> selectedProduct, List<Product> stock) {
		List<Product> selp = new ArrayList<Product>();
		for (Product ppp : selectedProduct) {
			selp.add(ppp.clone());
		}

		for (Product p : selectedProduct) {
			for (Product pp : stock) {
				if (pp instanceof Food) {
					if (p.equals((Food) pp)) {
						pp.setQuantity(pp.getQuantity() - p.getQuantity());
						break;
					}
				} else if (pp instanceof NonFood) {
					if (p.equals((NonFood) pp)) {
						pp.setQuantity(pp.getQuantity() - p.getQuantity());
						break;
					}
				}
			}
		}
		List<Product> r = new ArrayList<Product>();
		for (Product pp : stock) {
			if (pp.getQuantity() == 0) {
				r.add(pp);
			}
		}
		for (Product pp : r) {
			stock.remove(pp);
		}
		return selp;
	}
	
	public void IncreaseCash(int num) {
		cash.IncreaseCash(num);
	}

	public void DecreaseCash(int num) {
		cash.DecreaseCash(num);
	}
	

	
	public List<Product> GetProduct() {
		return stock.getProduct();
	}
	
	public void write() {
		stock.Write();
	}
	
	public int getCash() {
		return cash.GetCash();
	}
	
	public void addTransaction(Transaction t) {
		history.AddHistory(t);
	}
	
	public List<Transaction> getHistory() {
		return history.GetHistory();
	}
	
	public void SeletProduct(Product p, List<Product> selectedProduct, int q) {
		Product selp = p.clone();
		selp.setQuantity(q);
		int c = 0;
		for (Product pp : selectedProduct) {
			if (pp instanceof Food) {
				if (selp.equals((Food) pp)) {
					pp.setQuantity(selp.getQuantity() + pp.getQuantity());
					c = 1;
					break;
				}
			} else if (pp instanceof NonFood) {
				if (selp.equals((NonFood) pp)) {
					pp.setQuantity(selp.getQuantity() + pp.getQuantity());
					c = 1;
					break;
				}
			}
		}
		if (c == 0)
			selectedProduct.add(selp);
	}
}
