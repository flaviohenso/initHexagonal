package br.com.bank.hexagonal.aplication.ports.outgoing;

import br.com.bank.hexagonal.aplication.domain.BankAccount;

public interface SaveAccountPort {
    void save(BankAccount account);
}
