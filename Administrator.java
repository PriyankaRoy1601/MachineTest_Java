package com.nissan.model;

import java.util.*;

public class Administrator implements Validations {
	// data members
	public long accountNo, mobNo;
	public String name, accountType, email;
	public double balance, minBalance;
	public int pin;
	public String pan;

	// Function to Add Customer
	public void AddCustomer() {
		Administrator a = new Administrator();
		String temp;
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		this.accountNo = 100000000 + r.nextInt(900000000);
		System.out.println("Enter Customer Name:");
		temp = sc.next();
		this.name = a.NameValidation(temp);
		System.out.println("Enter AccountType(Savings/Current)");
		this.accountType = sc.next();
		System.out.println("Enter Balance:");
		temp = sc.next();
		this.balance = a.BalanceValidation(temp);
		System.out.println("Enter Minimum Balance:");
		temp = sc.next();
		this.minBalance = a.BalanceValidation(temp);
		System.out.println("Enter Mobile No:");
		temp = sc.next();
		this.mobNo = a.MobileValidation(temp);
		System.out.println("Enter email id:");
		this.email = sc.next();
		System.out.println("Enter Pan no.");
		this.pan = sc.next();
		this.pin = 1000 + r.nextInt(9000);
	}

	// Function to Update the details based on Account number
	public void Update() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Account no:" + this.accountNo);
		System.out.println("Enter new Mobile Number:");
		this.mobNo = sc.nextLong();
		System.out.println("Enter new EmailId:");
		this.email = sc.next();
		System.out.println("Updates successfully");

	}

	// Function to delete the detail
	public int Delete(ArrayList<Customer> a, int index) {
		a.remove(index);
		System.out.println("Details successfully deleted");
		return 0;

	}

	public String Display() {
		return "Administrator [accountNo=" + accountNo + ", mobNo=" + mobNo + ", name=" + name + ", accountType="
				+ accountType + ", email=" + email + ", balance=" + balance + ", minBalance=" + minBalance + ", pin="
				+ pin + ", pan=" + pan + "]";
	}

	public void CustomerDetails(ArrayList<Customer> a) {
		long accno;
		int flag = 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Account number");
		accno = sc.nextLong();
		for (Administrator i : a) {
			if (i.accountNo == accno) {
				i.Display();
				flag = 0;
				break;
			}

		}

		if (flag == 1)
			System.out.println("Customer details not found");

	}

}
