package br.com.bank.hexagonal.adapters.persistence;

import java.util.Optional;

import br.com.bank.hexagonal.aplication.domain.BankAccount;

public interface SpringDataBankAccountRepository {

    Optional<BankAccount> findById(Long id);

    void save(BankAccount account);
}
