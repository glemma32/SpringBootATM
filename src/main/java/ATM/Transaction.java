package ATM;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private Long acctNumber;
	private int action;
	private int amount;
	private String reason;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getAcctNumber() {
		return acctNumber;
	}
	
	public void setAcctNumber(Long acctNumber) {
		this.acctNumber = acctNumber;
	}
	
	public int getAction() {
		return action;
	}
	
	public void setAction(int action) {
		this.action = action;
	}
	
	/*public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}*/
	public String getReason() {
		return reason;
	}
	
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	public int withdraw(int withdrawAmount){
		amount=0-withdrawAmount;
		return amount;	
	}
	
	public int deposit(int depositAmount){
		amount=0+ depositAmount;
		return amount;
	}
	

}
