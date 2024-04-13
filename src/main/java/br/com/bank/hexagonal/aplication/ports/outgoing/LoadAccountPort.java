package br.com.bank.hexagonal.aplication.ports.outgoing;

import java.util.Optional;

import br.com.bank.hexagonal.aplication.domain.BankAccount;

public interface LoadAccountPort {
    Optional<BankAccount> load(Long id);
}
