package pos;

import java.util.ArrayList;
import java.util.List;

public class History {
	private List<Transaction> history = new ArrayList<Transaction>();
	
	public List<Transaction> GetHistory() {
		return history;
	}
	
	public void AddHistory(Transaction transaction) {
		history.add(transaction);
	}
	
	
	public boolean isEmpty() {
		if(history.isEmpty()) {
			return true;
		}
		else 
			return false;
	}
}
