package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter account data");
		System.out.print("Number:");
		int number = sc.nextInt();
		System.out.print("Holder:");
		String holder = sc.nextLine();
		sc.nextLine();
		System.out.print("Initial balance:");
		double balanceInitial = sc.nextDouble();
		System.out.print("Withdraw limit:");
		double Withdraw_lim = sc.nextDouble();

		Account account = new Account(number, holder, balanceInitial, Withdraw_lim);

		System.out.println();

		System.out.print("Enter amount for withdraw:");
		double amount = sc.nextDouble();

		try {
			account.withdraw(amount);
			System.out.print("New balance:" + String.format("%.2f", account.getBalance()));

		}

		catch (DomainException e) {

			System.out.println(e.getMessage());

		}

		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}

		sc.close();
	}

}
