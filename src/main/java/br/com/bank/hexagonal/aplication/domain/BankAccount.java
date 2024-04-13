package br.com.bank.hexagonal.aplication.domain;

import java.math.BigDecimal;

public class BankAccount {
    
    private Long id;
    private BigDecimal balance;

    public BankAccount(Long id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    /*
     * Withdraws the value from the account balance.
     */
    public boolean withdraw(BigDecimal value) {
        if (balance.compareTo(value) < 0) {
            return false;
        }
        balance = balance.subtract(value);
        return true;
    }

    /*
     * Deposits the value in the account balance.
     */
    public void deposit(BigDecimal value) {
        balance = balance.add(value);
    }


    public Long getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

}
