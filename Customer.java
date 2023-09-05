package com.nissan.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends Administrator implements Validations {

	public void Deposit() {
		Customer c = new Customer();
		double amount;
		Scanner sc = new Scanner(System.in);
		System.out.println(this);
		System.out.println("Enter amount to deposit");
		String s = sc.next();
		amount = c.BalanceValidation(s);
		if (amount > 50000) {
			System.out.println("Enter Pan Card no:");
			String pan = sc.next();
			if (pan == this.pan) {
				this.balance += amount;
				System.out.println("Deposited successfully");

			} else
				System.out.println("Wrong Pan details. Try again");
		} else {
			this.balance += amount;
			System.out.println("Deposited successfully");

		}

	}

	public int Withdraw() {
		double AvBalance = this.balance - this.minBalance;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter amount to withdraw:");
		double withdraw = sc.nextDouble();
		if (withdraw > AvBalance) {
			System.out.println("Insufficient funds");

			return 0;
		} else if (withdraw > 50000) {
			System.out.println("Enter Pan Card no:");
			String pan = sc.next();
			if (pan == this.pan) {
				this.balance = this.balance - withdraw;
				System.out.println("Deposited successfully");

			} else {
				System.out.println("Wrong Pan details. Try again");

				return 0;
			}
		} else {
			this.balance = this.balance - withdraw;
			System.out.println("Succesfully withdrawn");
		}

		return 0;

	}

	@Override
	public String toString() {
		return "Customer [accountNo=" + accountNo + ", mobNo=" + mobNo + ", name=" + name + ", accountType="
				+ accountType + ", email=" + email + ", balance=" + balance + ", minBalance=" + minBalance + ", pin="
				+ pin + ", pan=" + pan + "]";
	}

	public int Transfer(ArrayList<Customer> a) {
		long a1;
		String temp;
		long a2;
		Customer c = new Customer();
		int found1 = 0, found2 = 0, i, index1 = -1, index2 = -1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Account number from which money is to be transferred:");
		temp = sc.next();
		a1 = c.ValidNumber(temp);
		System.out.println("Enter Account number to which the money is to be transferred:");
		temp = sc.next();
		a2 = c.ValidNumber(temp);
		for (i = 0; i < a.size(); i++) {
			if (a.get(i).accountNo == a1) {
				found1 = 1;
				index1 = i;
			}
			if (a.get(i).accountNo == a2) {
				found2 = 1;
				index2 = i;
			}
		}
		if (found1 == 0 || found2 == 0) {
			System.out.println("Wrong account details");
			return 0;
		} else {
			double amt;
			System.out.println("Enter amount to be transferred");
			amt = sc.nextDouble();
			if (amt > a.get(index1).balance - a.get(index1).minBalance) {
				System.out.println("Insufficient funds");
				return 0;
			} else {
				a.get(index1).balance = a.get(index1).balance - amt;
				a.get(index2).balance += amt;
				System.out.println("Transferred Amount Successfully");
				return 0;
			}

		}

	}
}
