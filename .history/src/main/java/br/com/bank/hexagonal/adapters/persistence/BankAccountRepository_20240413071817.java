package br.com.bank.hexagonal.adapters.persistence;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.bank.hexagonal.aplication.domain.BankAccount;
import br.com.bank.hexagonal.aplication.ports.outgoing.LoadAccountPort;
import br.com.bank.hexagonal.aplication.ports.outgoing.SaveAccountPort;

@Component
public class BankAccountRepository implements LoadAccountPort, SaveAccountPort{

    private SpringDataBankAccountRepository repository;

    public BankAccountRepository(SpringDataBankAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<BankAccount> load(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(BankAccount account) {
        repository.save(account);        
    }
    
}
