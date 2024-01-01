package Interface;

import java.util.Scanner;

public class ATMDriver {

	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean f=true;
		ATMapp a=new ATMapp();
		
	
		System.out.println("🔑🔑🔑 Enter your ATM Pin 🔑🔑🔑");
		int p=sc.nextInt();
		
		if(p==a.getPin()) {
			while(f) {
				System.out.println("");
				System.out.println("-----------------🏧 WELCOME TO SBI ATM 🏧----------------------");
				System.out.println(" ");
				System.out.println("  1.  WITHDRAW                                  2.  BALANCE");
				System.out.println("  3.  DEPOSIT                                   4.  PIN CHANGE");
				System.out.println("  5.  MINI STATEMENT                            6.  EXIT");
				System.out.println("--------------------------------------------------------------");
				System.out.println(" ");
				
				int c=sc.nextInt() ;
				switch(c) {
				case 1: a.withdraw();
						break;
				case 2: a.getBalance();
						break;
				case 3: a.deposit();
						break;
				case 4: a.changePin();
						break;
				case 5: a.miniStatement();
						break;
				case 6: f=false;
						System.out.println("==============================================================");
						System.out.println("");
						System.out.println("                            THANK YOU 😊😊😊");
						System.out.println("");
						System.out.println("==============================================================");
						break;
				default:
					System.out.println("--------------------------------------------------------------");
					System.out.println("Please Enter Correct Choice ");	
				}
			}
			
		}
		else {
			System.out.println("--------------------------------------------------------------");
			System.out.println("❎❎❎ INVALID PIN ❎❎❎");
			System.out.println("--------------------------------------------------------------");
		}
		
		
		
		
	}

}
