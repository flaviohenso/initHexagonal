package br.com.bank.hexagonal.adapters.persistence;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.bank.hexagonal.aplication.domain.BankAccount;

@Repository
public class SpringDataAccountMemoryImpl implements SpringDataBankAccountRepository {

    public void save(BankAccount account) {
        // Implementation not shown
    }

    public Optional<BankAccount> findById(Long id) {
        // Implementation not shown
        return Optional.of(new BankAccount(id, new BigDecimal(200)));
    }
}
