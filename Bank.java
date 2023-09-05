package com.nissan.app;

import java.util.*;

import com.nissan.model.*;

public class Bank {
	static ArrayList<Customer> c = new ArrayList<Customer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer cm = new Customer();
		Scanner sc = new Scanner(System.in);
		String person, temp;
		char choice = 'n', option = 'n';
		int ch = 0;
		int index;
		long acno;
		do {
			System.out.println("Are you an Administrator or Customer(A/C):");
			person = sc.next();
			if (person.equals("A") || person.equals("a")) {
				do {
					index = -1;
					System.out.println("Hello Administrator");
					System.out.println("Main Menu");
					System.out.println("1.Add a new customer");
					System.out.println("2.Update Customer Details");
					System.out.println("3.Delete a Customer");
					System.out.println("4.Display all Customers");
					System.out.println("5.Display detail of a Specific Customer");
					System.out.println("Enter your choice:");
					String s = sc.next();
					ch = cm.TestInteger(s);
					switch (ch) {
					case 1:
						System.out.println("ENTER CUSTOMER DETAILS");
						Customer n = new Customer();
						n.AddCustomer();
						c.add(n);
						break;

					case 2:
						System.out.println("2.Update Customer details");
						System.out.println("Enter account number to be Updated:");
						temp = sc.next();
						acno = cm.ValidNumber(temp);
						index = FindIndex(acno);
						if (index < 0)
							System.out.println("Details not found");
						else
							c.get(index).Update();

						break;

					case 3:
						System.out.println("Delete a Customer");
						System.out.println("Enter the account number to be deleted:");
						temp = sc.next();
						acno = cm.ValidNumber(temp);
						index = FindIndex(acno);
						if (index < 0)
							System.out.println("Details not found");
						else
							c.get(index).Delete(c, index);
						break;

					case 4:
						System.out.println("Display all customers");
						for (int k = 0; k < c.size(); k++)
							System.out.println(c.get(k));
						break;

					case 5:
						System.out.println("Display detail of a Specific Customer");
						System.out.println("Enter account number:");
						temp = sc.next();
						acno = cm.ValidNumber(temp);
						index = FindIndex(acno);
						if (index < 0)
							System.out.println("Account number not found..!!!");
						else
							System.out.println(c.get(index));
						break;
					default:
						System.out.println("Wrong choice");

					}
					System.out.println("Do you want to continue as administrator(y/n):");
					option = sc.next().charAt(0);
				} while (option == 'y' || option == 'Y');
			} else if (person.equals("C") || person.equals("c")) {

				do {
					index = -1;
					System.out.println("Hello Customer");
					System.out.println("Main Menu");
					System.out.println("1.Deposit Money");
					System.out.println("2.Withdraw Money");
					System.out.println("3.Display Balance of a Customer");
					System.out.println("4.Transfer money");
					System.out.println("Enter your choice:");
					String s = sc.next();
					ch = cm.TestInteger(s);
					switch (ch) {
					case 1:
						System.out.println("Deposit Money");
						System.out.println("Enter account no:");
						temp = sc.next();
						acno = cm.ValidNumber(temp);
						index = FindIndex(acno);
						if (index < 0)
							System.out.println("Details not found");
						else
							c.get(index).Deposit();
						break;

					case 2:
						System.out.println("Withdraw Money");
						System.out.println("Enter Account number:");
						temp = sc.next();
						acno = cm.ValidNumber(temp);
						index = FindIndex(acno);
						if (index < 0)
							System.out.println("Details not found");
						else
							c.get(index).Withdraw();
						break;

					case 3:
						System.out.println("Display Balance of a Customer");
						System.out.println("Enter Account number:");
						temp = sc.next();
						acno = cm.ValidNumber(temp);
						index = FindIndex(acno);
						if (index < 0)
							System.out.println("Details not found");
						else
							System.out.println("Balance:" + c.get(index).balance);
						break;

					case 4:
						System.out.println("Transfer money");
						cm.Transfer(c);

					default:
						System.out.println("Wrong choice");
					}
					System.out.println("Do you want to continue as Customer(y/n):");
					option = sc.next().charAt(0);
				} while (option == 'y' || option == 'y');
			} else
				System.out.println("Wrong choice");

			System.out.println("Do you want to continue(y/n):");
			choice = sc.next().charAt(0);
		} while (choice == 'y' || choice == 'Y');

	}

	private static int FindIndex(long acno) {
		// TODO Auto-generated method stub
		for (int j = 0; j < c.size(); j++)
			if (c.get(j).accountNo == acno)
				return j;

		return -1;
	}

}
