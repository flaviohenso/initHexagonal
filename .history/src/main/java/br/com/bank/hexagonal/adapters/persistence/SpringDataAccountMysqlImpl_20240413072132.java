package br.com.bank.hexagonal.adapters.persistence;

import java.util.Optional;

import br.com.bank.hexagonal.aplication.domain.BankAccount;

public class SpringDataAccountMysqlImpl implements SpringDataBankAccountRepository{

    @Override
    public Optional<BankAccount> findById(Long id) {
        // TODO Auto-generated method stub
        return 
    }

    @Override
    public void save(BankAccount account) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
    
}
