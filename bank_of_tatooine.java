//Citlalli Trejo Del Rio
//Homework 5
import java.util.*;
public class bank
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		//Checking Accounts
		ArrayList<CheckingAccount> Check = new ArrayList<CheckingAccount>();
		Check.add(new CheckingAccount("Trejo", "Lalli","citlalli.trejo99@gmail.com", 50000.0));
		Check.add(new CheckingAccount("Darth", "Vader","NotAnakinSkywalker", 10000.0));
		Check.add(new CheckingAccount("Obi-Wan", "Kenobi", "TheObiKenobi@gmail.com", 60000.0));
		Check.add(new CheckingAccount("Din", "Djarin", "NoMandoLore@gmail.com", 8000.0));
		Check.add(new CheckingAccount("Amidala","Padme","IAmPadme@gmail.com", 10000.0));

		// Loan Accounts
		ArrayList<LoanAccount> Loan = new ArrayList<LoanAccount>();
		Loan.add(new LoanAccount("Dooku", "Count", "NotWithJedi@gmail.com", 10000.0));
		Loan.add(new LoanAccount("Fett", "Boba","NotAClone@gmail.com", 20000.0));
		Loan.add(new LoanAccount("Ren", "Kylo", "NotASkywalker", 70000));
		Loan.add(new LoanAccount("Solo", "Han", "MyLeia@gmail.com", 20000.0));
		Loan.add(new LoanAccount("Windu", "Mace", "IAmWithPurple@gmail.com", 50000));

		// Menu Choices
		int Choice = 0;
		while (Choice != 8)
		{
			System.out.println("~*~*~*~*~*~*~*~ Bank of Tatooine ~*~*~*~*~*~*~*~");
			System.out.println(" "); // spacing
			System.out.println("1 = Bank Information");
			System.out.println("2 = See Checking Accounts");
			System.out.println("3 = Deposit to Checking Account");
			System.out.println("4 = Widthdraw from Checking Account");
			System.out.println("5 = Print all Loan Accounts");
			System.out.println("6 = Make Loan");
			System.out.println("7= Make Payment");
			System.out.println("8 = Exit");
			System.out.println(" "); // spacing
			System.out.println("Enter your choice: ");
			Choice = in.nextInt();
			System.out.println(" "); // spacing
			if (Choice == 1) // bank info
			{
				System.out.println("Bank Balance: $" + Check.get(0).BankBalance);
				int TotalTransactions = 0;
				for (int i=0; i<Check.size(); i++)
				{
					TotalTransactions += Check.get(i).CustomerTransactions;
				}
				System.out.println("Total Bank Transaction: " + TotalTransactions);
				System.out.println("Number of Customers: " + Check.get(0).NumberCustomers);
				System.out.println(" ");// spacing
			}
			if (Choice == 2) // see checking accounts
			{
				System.out.println("-----------Checking Accounts----------------");
				System.out.println("RecNo	LName	FName	Balance	Transactions");
				System.out.println("============================================");
				for (int i=0; i<Check.size(); i++)
				{
					System.out.println(i + "	" + Check.get(i).LName + "\t" + Check.get(i).FName + "\t" + Check.get(i).getCheckingBalance() + "\t" + Check.get(i).CustomerTransactions);
					System.out.println(" "); // spacing
				}
			}
			if (Choice == 3) // Deposit
			{
				System.out.print("Enter record number: ");
				int RecNum = in.nextInt();
				System.out.print("Enter amount ot deposit: $");
				double Amount = in.nextDouble();
				Check.get(RecNum).Deposit(Amount);
				System.out.println(Check.get(RecNum).LName + ", " + Check.get(RecNum).FName + " now has $" + Check.get(RecNum).getCheckingBalance());
				System.out.println(" "); // spacing
			}
			if (Choice == 4) // Widthdraw
			{
				System.out.print("Enter record number: ");
				int RecNum = in.nextInt();
				System.out.print("Amount to widthdraw $");
				double Amount = in.nextDouble();
				Check.get(RecNum).Widthdraw(Amount);
				System.out.println(Check.get(RecNum).LName + ", " + Check.get(RecNum).FName + " now has $" + Check.get(RecNum).getCheckingBalance());
				System.out.println(" "); // spacing
			}
			if (Choice == 5) // Print Loan Accounts
			{
				System.out.println("---------------Loan Accounts----------------");
				System.out.println("RecNo	LName	FName	Balance	Transactions");
				System.out.println("============================================");
				for (int i=0; i<Loan.size(); i++)
				{
					System.out.println(i + "	" + Loan.get(i).LName + "\t" + Loan.get(i).FName + "\t" + Loan.get(i).getLoanBalance() + "\t" + Loan.get(i).CustomerTransactions);
					System.out.println(" "); // spacing
				}
			}
			if (Choice == 6) // Make Loan
			{
				System.out.print("Enter record number: ");
				int RecNum = in.nextInt();
				System.out.print("Amount of Loan: $");
				double Amount = in.nextDouble();
				Loan.get(RecNum).MakeLoan(Amount*1.25);
				System.out.println(Loan.get(RecNum).LName + ", " + Loan.get(RecNum).FName + " now has a Loan balance of $" + Loan.get(RecNum).getLoanBalance()+" .There is a 25% interest premium added");
				System.out.println(" "); // spacing
			}
			if (Choice == 7) // Make Payment
			{
				System.out.print("Enter record number: ");
				int RecNum = in.nextInt();
				System.out.print("Amount to pay Loan: $");
				double Amount = in.nextDouble();
				Loan.get(RecNum).MakePayment(Amount);
				System.out.println(Loan.get(RecNum).LName + ", " + Loan.get(RecNum).FName + " now has a Loan balance of $" + Loan.get(RecNum).getLoanBalance());
				System.out.println(" "); // spacing
			}
		}// end of Choice Menu
		System.out.println("Thanks for choosing Bank of Tatooine");
	}// end of main
}// end of public class bank

class Customer // superclass
{
	String LName, FName, Email;
	int CustomerTransactions = 0;
	static double BankBalance = 0;
	static int NumberCustomers = 0;
}// end of Customer class

class CheckingAccount extends Customer // subclass
{
	private double CheckingBalance; //data hiding - making class vars private

	CheckingAccount (String theLName, String theFName, String theEmail, double OpeningDeposit)
	{
		LName = theLName; FName = theFName; Email = theEmail; CheckingBalance = OpeningDeposit;
		BankBalance += OpeningDeposit;
		NumberCustomers++;
	}

	double getCheckingBalance() // need to see checking balance, it's private
	{
		return CheckingBalance;
	}

	void Deposit(double Amount)
	{
		CheckingBalance += Amount;
		CustomerTransactions++;
		BankBalance += Amount;
	}
	void Widthdraw(double Amount)
	{
		CheckingBalance -= Amount;
		if (CheckingBalance < 0)
		{
			CheckingBalance -=25; //overdraft
			System.out.println("Overdraft! $25 fee charged");
		}
		CustomerTransactions++;
		BankBalance -= Amount;
	}
}// end of Checking Account class

class LoanAccount extends Customer // subclass
{
	private double LoanBalance; // data hiding -making class private

	LoanAccount(String theLName, String theFName, String theEmail, double OpeningLoan)
	{
		LName = theLName; FName = theFName; Email = theEmail; LoanBalance = OpeningLoan*1.25;
		BankBalance -= OpeningLoan;
		NumberCustomers++;
	}

	double getLoanBalance() // need to see loan balance, it's private
	{
		return LoanBalance;
	}
	void MakeLoan(double Amount)
	{
		LoanBalance += Amount;
		BankBalance -= Amount;
		CustomerTransactions++;
	}

	void MakePayment(double Amount)
	{
		LoanBalance -= Amount;
		if (LoanBalance <=0)
		{
			System.out.println("Yay! You have paid off loan!");
		}
		CustomerTransactions++;
		BankBalance += Amount;

	}
}//End of Loan Account class
