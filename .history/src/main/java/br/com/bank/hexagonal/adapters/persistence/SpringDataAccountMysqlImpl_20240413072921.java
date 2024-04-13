package br.com.bank.hexagonal.adapters.persistence;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.bank.hexagonal.aplication.domain.BankAccount;

@Repository
public class SpringDataAccountMysqlImpl implements SpringDataBankAccountRepository{

    @Override
    public Optional<BankAccount> findById(Long id) {
        // TODO Auto-generated method stub
        return Optional.of(new BankAccount(id, new BigDecimal(100)));
    }

    @Override
    public void save(BankAccount account) {
        
        
    }
    
}
