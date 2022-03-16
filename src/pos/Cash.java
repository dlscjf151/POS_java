package pos;

public class Cash {
	private int cash;
	
	
	public Cash(int cash) {
		this.cash = cash;
	}

	public int GetCash() {
		return cash;
	}
	
	public int IncreaseCash(int num) {
		cash += num;
		return cash;
	}

	public int DecreaseCash(int num) {
		cash -= num;
		return cash;
	}

}
