package br.com.bank.hexagonal.adapters.persistence;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.bank.hexagonal.aplication.domain.BankAccount;

@Repository
public class SpringDataAccountMysqlImpl {

    public Optional<BankAccount> findById(Long id) {
        return Optional.of(new BankAccount(id, new BigDecimal(100)));
    }

    public void save(BankAccount account) {
    }

}
