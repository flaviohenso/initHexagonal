package br.com.bank.hexagonal.aplication.ports.incoming;

import java.math.BigDecimal;

import br.com.bank.hexagonal.aplication.domain.BankAccount;

public interface DepositUseCase {

    BankAccount deposit(Long id, BigDecimal value);
}
