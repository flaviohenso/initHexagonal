package br.com.bank.hexagonal.adapters.configuration;

import org.springframework.context.annotation.Configuration;

import br.com.bank.hexagonal.adapters.persistence.BankAccountRepository;
import br.com.bank.hexagonal.aplication.service.BankAccountService;

/**
 * Configuration class for defining beans in the application context.
 */
@Configuration
public class BeanConfiguration {

    /**
     * Creates an instance of the BankAccountService bean.
     * 
     * @param repository The BankAccountRepository dependency.
     * @return The BankAccountService bean.
     */
    public BankAccountService hexagonalApplication(BankAccountRepository repository) {
        return new BankAccountService(repository, repository);
    }
}
