package br.com.bank.hexagonal.aplication.service;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bank.hexagonal.aplication.domain.BankAccount;
import br.com.bank.hexagonal.aplication.ports.incoming.DepositUseCase;
import br.com.bank.hexagonal.aplication.ports.incoming.WithdrawUseCase;
import br.com.bank.hexagonal.aplication.ports.outgoing.LoadAccountPort;
import br.com.bank.hexagonal.aplication.ports.outgoing.SaveAccountPort;

@Service
public class BankAccountService implements DepositUseCase, WithdrawUseCase {

    private LoadAccountPort loadAccountPort;
    private SaveAccountPort saveAccountPort;

    /**
     * Constructs a new BankAccountService with the specified LoadAccountPort and
     * SaveAccountPort.
     *
     * @param loadAccountPort the port for loading bank accounts
     * @param saveAccountPort the port for saving bank accounts
     */
    @Autowired
    public BankAccountService(LoadAccountPort loadAccountPort, SaveAccountPort saveAccountPort) {
        this.loadAccountPort = loadAccountPort;
        this.saveAccountPort = saveAccountPort;
    }

    /**
     * Deposits the specified value into the bank account with the given ID.
     *
     * @param id    the ID of the bank account
     * @param value the value to deposit
     */
    @Override
    public BankAccount deposit(Long id, BigDecimal value) {
        BankAccount account = loadAccountPort.load(id)
                .orElseThrow(NoSuchElementException::new);
        account.deposit(value);
        saveAccountPort.save(account);
        return account;
    }

    /**
     * Withdraws the specified value from the bank account with the given ID.
     *
     * @param id    the ID of the bank account
     * @param value the value to withdraw
     * @return true if the withdrawal was successful, false otherwise
     */
    @Override
    public Boolean withdraw(Long id, BigDecimal value) {
        BankAccount account = loadAccountPort.load(id)
                .orElseThrow(NoSuchElementException::new);
        if (account.withdraw(value)) {
            saveAccountPort.save(account);
            return true;
        }
        return false;
    }
}
