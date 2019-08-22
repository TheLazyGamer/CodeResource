import java.util.Date;

class Account {
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated = new Date();
	private static int numberOfAccounts = 0;
	private static double totalValueOfAccounts = 0;

	public Account() {
		numberOfAccounts++;
	}

	public Account(int newID, double newBalance, double newAnnualInterestRate) {
		id = newID;
		balance = newBalance;
		annualInterestRate = newAnnualInterestRate;
		numberOfAccounts++;
		totalValueOfAccounts += balance;
	}

	int getID() {
		return id;
	}

	double getBalance() {
		return balance;
	}

	double getAnnualInterestRate() {
		return annualInterestRate;
	}

	int setID(int newID) {
		id = newID;
		return id;
	}

	double setBalance(double newBalance) {
		double oldBalance = balance;
		totalValueOfAccounts -= oldBalance;
		totalValueOfAccounts += newBalance;
		balance = newBalance;
		return balance;
	}

	double setAnnualInterestRate(double newAnnualInterestRate) {
		annualInterestRate = newAnnualInterestRate;
		return annualInterestRate;
	}

	void getDate() {
		System.out.println("The account was created on: " + dateCreated);
	}

	double withdraw(double amount) {
		balance = balance - amount;
		totalValueOfAccounts = totalValueOfAccounts - amount;
		return balance;
	}

	double deposit(double amount) {
		balance = balance + amount;
		totalValueOfAccounts += amount;
		return balance;    
	}

	double getTotalValue(double valueOfAccount, int accountNumber) {
		totalValueOfAccounts += valueOfAccount;
		return totalValueOfAccounts;
	}

	double getMonthlyInterestRate(double annualInterestRate) {
		double monthlyInterestRate = annualInterestRate / 12;
		return monthlyInterestRate;
	}

	double awardMonthlyInterest() {
		double oldBalance = balance;
		balance = oldBalance + (oldBalance) * ((annualInterestRate / 100) / 12);
		totalValueOfAccounts -= oldBalance;
		totalValueOfAccounts += balance;
		return balance;
	}

	void closeAccount() {
		System.out.println("Closing account " + id);
		numberOfAccounts--;
		totalValueOfAccounts = totalValueOfAccounts - balance;
	}

	public Object getDateCreated() {
		return dateCreated;
	}

	static double averageBalance() {
		if (numberOfAccounts != 0) {
			return (totalValueOfAccounts / numberOfAccounts);
		}
		else {
			return 0;
		}
	}

}

public class TestAccount {
	public static void main(String[] args) {
		System.out.printf("The average account balance is $%.2f.%n", Account.averageBalance());

		Account defaultAcc = new Account();
		System.out.println("Default account:");
		printAccount(defaultAcc);
		defaultAcc.setID(1122);
		defaultAcc.setBalance(20000);
		defaultAcc.setAnnualInterestRate(4.5);
		System.out.println("Modified account:");
		printAccount(defaultAcc);
		defaultAcc.withdraw(2500);
		defaultAcc.deposit(3000);
		System.out.println("After withdrawal and deposit:");
		printAccount(defaultAcc);

		for (int i = 0; i < 6; i++) {
			defaultAcc.awardMonthlyInterest();
		}

		System.out.println("After six months of interest:");
		printAccount(defaultAcc);
		System.out.printf("The average account balance is $%.2f.%n", Account.averageBalance());
		defaultAcc.closeAccount();

		Account[] accountArray = new Account[5];

		for (int i = 0; i < 5; i++) {
			accountArray[i] = new Account(i + 1, Math.random() * 100000, 3.0);
		}

		System.out.println("Array of five accounts with random balances:");
		for (int i = 0; i < 5; i++) {
			printAccount(accountArray[i]);
		}

		System.out.printf("The average account balance is $%.2f.%n", Account.averageBalance());

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				accountArray[i].awardMonthlyInterest();
			}
		}

		System.out.println("Array after awarding 6 months of interest:");

		for (int i = 0; i < 5; i++) {
			printAccount(accountArray[i]);
		}

		System.out.printf("The average account balance is $%.2f.%n", Account.averageBalance());
	}


	public static void printAccount(Account a) {
		System.out.printf("%5d $%9.2f %5.2f%% %29s\n", a.getID(), a.getBalance(), a.getAnnualInterestRate(), a.getDateCreated());
	}
}