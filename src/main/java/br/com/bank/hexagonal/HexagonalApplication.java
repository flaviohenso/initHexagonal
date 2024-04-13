package br.com.bank.hexagonal;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.bank.hexagonal.adapters.persistence.BankAccountRepository;
import br.com.bank.hexagonal.aplication.domain.BankAccount;

/**
 * The main class for the Hexagonal Application.
 */
@SpringBootApplication
public class HexagonalApplication {

    /**
     * The main method that starts the Spring Boot application.
     * 
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(HexagonalApplication.class, args);
    }

    /**
     * A bean that initializes the data for the application.
     * 
     * @param repository The repository for bank accounts.
     * @return A CommandLineRunner instance.
     */
    @Bean
    public CommandLineRunner bootstrapData(BankAccountRepository repository) {
        return (args) -> {
            BigDecimal initialBalance = BigDecimal.valueOf(1000);
            BankAccount bankAccount = new BankAccount(0L, initialBalance);
            repository.save(bankAccount);
        };
    }

}
