package Interface;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  

public class ATMapp implements ATM{
	Scanner sc=new Scanner(System.in);
	
	
	
	
	
	
	    
	
	private double balance=5000;
	private int pin=1234;	
	
	MiniStatement m[]=new MiniStatement[5];
	int i=0;

	@Override
	public void withdraw() {
		System.out.println("--------------------------------------------------------------");
		System.out.println("Enter amount to withdrawal ");
		int w=sc.nextInt();
		if(w%100==0) {
			if(w<=25000 ) {
				if(w<=balance) {
				this.balance-=w;
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				String d=dtf.format(now);
				
				MiniStatement m1=new MiniStatement(d,w,"Withdrawal",balance) ;
				if(i<5) {					
					m[i++]=m1;
				}
				else {
					for(int i=0;i<4;i++) {
						m[i]=m[i+1];
					}
					m[4]=m1;
				}
				
				System.out.println("               AMOUNT  WITHDRAWAL SUCCESSFULLY ✅✅✅");
				System.out.println(" ");
				System.out.println("               Current Balance = ₹"+balance);
				System.out.println("");
				
				
				
				}
				else {
					System.out.println("WITHDRAWAL AMOUNT IS EXCEED THE LIMIT OF CURRENT BALANCE  ");
					System.out.println("--------------------------------------------------------------");
				withdraw();
				}
			}
			else {
				System.out.println("WITHDRAWAL LIMIT OF AMOUNT IS MAX 25000 ");
				System.out.println("--------------------------------------------------------------");
				withdraw();
			}
		}
		else {
			System.out.println("❎❎❎ Invalid Amount ❎❎❎");
			System.out.println("--------------------------------------------------------------");
			withdraw();
		}
		
	}

	@Override
	public void getBalance() {
		System.out.println("--------------------------------------------------------------");
		System.out.println("Current Balance = ₹"+balance);
		System.out.println("");
	}

	@Override
	public void deposit() {
		System.out.println("--------------------------------------------------------------");
		System.out.println("Enter amount to Deposit ");
		int d=sc.nextInt();
		
		if(d%100==0) {
			if(d<=40000 ) {
				this.balance+=d;
				
				DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				LocalDateTime now1 = LocalDateTime.now();
				String dt=dtf1.format(now1);
				
				MiniStatement m1=new MiniStatement(dt,d ,"Deposit   ",balance) ;
				if(i<m.length) {					
					m[i++]=m1;
				}
				else {
					for(int i=0;i<4;i++) {
						m[i]=m[i+1];
					}
					m[4]=m1;
				}
				
				System.out.println("               AMOUNT  DEPOSIT SUCCESSFULLY ✅✅✅");
				System.out.println(" ");
				System.out.println("               Current Balance = ₹"+balance);
				System.out.println("");
			}
			else {
				System.out.println("Deposit LIMIT OF AMOUNT IS MAX 40000 ");
				System.out.println("--------------------------------------------------------------");
				deposit();
				
			}
		}
		else {
			System.out.println("❎❎❎ Invalid Amount ❎❎❎");
			System.out.println("--------------------------------------------------------------");
			deposit();
		}
		
	}

	@Override
	public void changePin() {
		System.out.println("--------------------------------------------------------------");
		System.out.println("Enter your old Pin ");
		int p=sc.nextInt();
		int x=p;
		if(count(x)==4 && p==pin) {
			System.out.println("Enter 4 digit new Pin ");
			int n=sc.nextInt();
			int y=n;
			if(count(y)==4 && n!=pin) {
				System.out.println("Enter 4 digit new Pin ");
				this.pin=n;
				System.out.println("                   PIN CHANGE SUCCESSFULLY ✅✅✅");
				System.out.println("--------------------------------------------------------------");
				
			}
			else {
				
				System.out.println("❎❎❎ Invalid pin ❎❎❎");
				System.out.println("--------------------------------------------------------------");
				changePin();
			}
		}
		else {
			System.out.println("❎❎❎ Invalid pin ❎❎❎");
			System.out.println("--------------------------------------------------------------");
			changePin();
		}
	}

	@Override
	public void miniStatement() {
		
				
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("         DATE        |    AMOUNT   |     DEPOSIT / WITHDRAWAL     |    CURRENT BALANCE      ");
		System.out.println("--------------------------------------------------------------------------------------------");
		for(int j=0;j<i;j++) {
		                
		   System.out.println(m[j].date+"  |    ₹"+m[j].getAmount()+  "  |          "+m[j].getMsg()+"          |    ₹"+m[j].getCurr_bal());
		}
		System.out.println("--------------------------------------------------------------------------------------------");
		
		
	}
	
	public int getPin() {
		return pin;
	}		

	public void setPin(int pin) {
		this.pin = pin;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int count(int n) {
		int count=0;
		while(n>0) {
			count++;
			n=n/10;
		}
		return count;
	}
}
