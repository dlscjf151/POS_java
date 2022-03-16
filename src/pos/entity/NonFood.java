package pos.entity;

public class NonFood extends Product{
	private int adult;
	
	public NonFood(String name, int quantity, int price, int adult) {
		super(name, quantity, price);
		this.adult = adult;
	}
	
	public int getAdult() {
		return adult;
	}

	public void setAdult(int adult) {
		this.adult = adult;
	}

	public String toString() {
		return String.format("%s\t%d\t%d\t%d\tNon-Food\n", super.getName(), super.getQuantity(), super.getPrice(), adult);
	}
	
	public boolean equals(NonFood nonFood) {
		if (super.getName().equals(nonFood.getName()) && super.getPrice() == nonFood.getPrice()
				&& adult == nonFood.getAdult()) {
			return true;
		}
		return false;
	}
	
	public String PrintList() {
		return String.format("%-20s%-5d%-10d%-10d", super.getName(), super.getQuantity(), super.getPrice(), adult);
	}
	
	
	public Product clone(){
		return (Product)super.clone();	
	}
	
	public String[] ToArray() {
		String[] p;
		if(adult==1)
			 p = new String[]{null,super.getName(), Integer.toString(super.getPrice()), Integer.toString(super.getQuantity()), "O"};
		else
			 p=  new String[]{null,super.getName(), Integer.toString(super.getPrice()), Integer.toString(super.getQuantity()), "X"};
		return p;
	}
}
