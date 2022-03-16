package pos.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Food extends Product {
	private String life;

	
	public Food(String name, int quantity, int price, String life) {
		super(name, quantity, price);
		this.life = life;
	}

	public String getLife() {
		return life;
	}

	public void setLife(String life) {
		this.life = life;
	}

	public boolean equals(Food food) {
		if (super.getName().equals(food.getName()) && super.getPrice() == food.getPrice()
				&& life.equals(food.getLife())) {
			return true;
		}
		return false;
	}

	public String toString() {
		return String.format("%s\t%d\t%d\t%s\tFood\n", super.getName(), super.getQuantity(), super.getPrice(), life);
	}
	
	public String PrintList() {
		return String.format("%-20s%-5d%-10d%-10s", super.getName(), super.getQuantity(), super.getPrice(), life);
	}
	
	public Product clone(){
		return (Product)super.clone();	
	}
	
	public boolean CheckLife() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Date time = new Date();
		try {
			if(format.parse(life).before(new Date())) {
				return false;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return true;
	}
	public String[] ToArray() {
		String[] p = {null,super.getName(), Integer.toString(super.getPrice()), Integer.toString(super.getQuantity()), this.life};
		return p;
	}
}
