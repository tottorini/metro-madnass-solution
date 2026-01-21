package org.example.bank;

import java.util.HashMap;
import java.util.Map;

public class ExampleBank {
    
    private class Account {
        public String accountNumber;
        public long balance;

        public Account(String accountNumber) {
			this.accountNumber = accountNumber;
			this.balance = 0;
		}

    }

    private Map<String, Account> accounts = new HashMap<String, Account>();

    private Account getAccount(String accountNumber) {
		return accounts.get(accountNumber);
    }

    public String openAccount() {
		Account newAccount = new Account(String.format("47328000-%08d", accounts.size() + 1));
		accounts.put(newAccount.accountNumber, newAccount);
		return newAccount.accountNumber;
	}

    public boolean closeAccount(String accountNumber)  {
		if(getAccount(accountNumber).balance == 0) {
			accounts.remove(accountNumber);
			return true;
		} else {
			return false;
		}
	}

    public long getBalance(String accountNumber) {
		return getAccount(accountNumber).balance;
	}

    public void deposit(String accountNumber, long amount) {
		getAccount(accountNumber).balance += amount;
	}

    public void transfer(String sourceAcc, String targetAcc, long am) {
		if(am <= 0) 
			throw new IllegalArgumentException("Amount not positive");
		
		Account source = getAccount(sourceAcc);
		Account target = getAccount(targetAcc);
		source.balance -= am; 
		target.balance += am;
	}
}
