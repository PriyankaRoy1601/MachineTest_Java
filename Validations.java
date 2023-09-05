package com.nissan.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Validations {

	default long ValidNumber(String acno) {
		String accno = String.valueOf(acno);
		try {
			BufferedReader AccountValid = new BufferedReader(new InputStreamReader(System.in));

			// creating pattern using regular expression
			Pattern patternBalance = Pattern.compile("[^0-9.-]");

			do {
				Matcher matcherBalance = patternBalance.matcher(accno);
				boolean balanceFinder = matcherBalance.find();

				if (balanceFinder) {
					System.out.print("Incorrect account number. Please re-enter: ");
					accno = AccountValid.readLine();
				} else if (accno.length() != 9) {
					System.out.print("Account number is 9 digits. Please re-enter: ");
					accno = AccountValid.readLine();
				} else {
					break;
				}
			} while (true);

		} catch (Exception e) {
			System.out.println("Invalid account number");
		}

		long accountNo = Long.valueOf(accno).longValue();

		return accountNo;
	}

	default long MobileValidation(String mbno) {
		try {
			BufferedReader MobileValid = new BufferedReader(new InputStreamReader(System.in));

			// creating pattern using regular expression
			Pattern patternBalance = Pattern.compile("[^0-9.-]");

			do {
				Matcher matcherBalance = patternBalance.matcher(mbno);
				boolean balanceFinder = matcherBalance.find();

				if (balanceFinder) {
					System.out.print("Incorrect mobile number. Please re-enter: ");
					mbno = MobileValid.readLine();
				} else if (mbno.length() != 10) {
					System.out.print("Mobile number is 10 digits. Please re-enter: ");
					mbno = MobileValid.readLine();
				} else {
					break;
				}
			} while (true);

		} catch (Exception e) {
			System.out.println("Invalid mobile number");
		}

		long mobNo = Long.valueOf(mbno).longValue();

		return mobNo;

	}

	default String NameValidation(String Name) {
		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Pattern pattern = Pattern.compile("[^A-Za-z ]");
			do {
				Matcher matcher = pattern.matcher(Name);
				boolean finder = matcher.find(); // find() returns false if the string matches the pattern
				if (finder) {
					System.out.print("Name must contain only alphabets. Please re-enter name: ");
					Name = br.readLine();
				} else if (Name.length() > 30) {
					System.out.print("Name contains more than 30 characters. Please re-enter name: ");
					Name = br.readLine();
				} else {
					break;
				}
			} while (true);
		} catch (Exception e) {
			System.out.println("Invalid name");
		}
		return Name;
	}

	default double BalanceValidation(String Bal) {
		try {
			BufferedReader BalanceValid = new BufferedReader(new InputStreamReader(System.in));

			// creating pattern using regular expression
			Pattern patternBalance = Pattern.compile("[^0-9.-]");

			do {
				Matcher matcherBalance = patternBalance.matcher(Bal);
				boolean balanceFinder = matcherBalance.find();

				if (balanceFinder) {
					System.out.print("Incorrect balance. Please re-enter balance: ");
					Bal = BalanceValid.readLine();
				} else {
					break;
				}
			} while (true);

		} catch (Exception e) {
			System.out.println("Invalid balance number");
		}

		double balance = Double.valueOf(Bal).longValue();

		return balance;

	}

	default int TestInteger(String s) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			// creating pattern using regular expression
			Pattern patternBalance = Pattern.compile("[^0-9.-]");

			do {
				Matcher matcherBalance = patternBalance.matcher(s);
				boolean balanceFinder = matcherBalance.find();

				if (balanceFinder) {
					System.out.print("Incorrect value. Please re-enter: ");
					s = br.readLine();

				} else {
					break;
				}
			} while (true);

		} catch (Exception e) {
			System.out.println("Invalid number");
		}

		int k = Integer.parseInt(s);
		return k;

	}
	
	default char CheckOption(String s) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			// creating pattern using regular expression
			Pattern patternBalance = Pattern.compile("[^yYnN]");

			do {
				Matcher matcherBalance = patternBalance.matcher(s);
				boolean balanceFinder = matcherBalance.find();

				
				if(s.length()>2){
					System.out.print("Must be a single alphabet. Please re-enter: ");
					s = br.readLine();
				}
				else if (balanceFinder) {
					System.out.print("Incorrect option. Please re-enter: ");
					s = br.readLine();

				} 
				
						else {
					break;
				}
			} while (true);

		} catch (Exception e) {
			System.out.println("Invalid choice");
		}

		char k=s.charAt(0);
		return k;

		
	}
	
}
