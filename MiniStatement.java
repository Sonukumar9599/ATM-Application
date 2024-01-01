package Interface;

public class MiniStatement {
	
	private double amount;
	private String msg;
	private double curr_bal;
	String date;
	
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public double getCurr_bal() {
		return curr_bal;
	}
	public void setCurr_bal(double curr_bal) {
		this.curr_bal = curr_bal;
	}
	
	public MiniStatement(String date,double amount,String msg ,double curr_bal) {
		this.date=date;
		this.amount=amount;
		this.msg=msg;
		this.curr_bal=curr_bal;
	}
	
	
	
}
