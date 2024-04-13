package br.com.bank.hexagonal.adapters.web;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping; // Import the RequestMapping class
import org.springframework.web.bind.annotation.RestController;

import br.com.bank.hexagonal.aplication.ports.incoming.DepositUseCase;
import br.com.bank.hexagonal.aplication.ports.incoming.WithdrawUseCase;

/**
 * Controller class for managing bank account operations.
 */
@RestController
@RequestMapping("/account")
public class BankAccountController {
    
    private final DepositUseCase depositUseCase;
    private final WithdrawUseCase withdrawUseCase;

    /**
     * Constructor for BankAccountController.
     * 
     * @param depositUseCase The use case for depositing money into a bank account.
     * @param withdrawUseCase The use case for withdrawing money from a bank account.
     */
    public BankAccountController(DepositUseCase depositUseCase, WithdrawUseCase withdrawUseCase) {
        this.depositUseCase = depositUseCase;
        this.withdrawUseCase = withdrawUseCase;
    }

    /**
     * Endpoint for depositing money into a bank account.
     * 
     * @param id The ID of the bank account.
     * @param amount The amount of money to deposit.
     * @return retorna a respota http mais o obejeto encontrado em formato json
     */
    @PostMapping(value = {"{id}/deposit/{amount}"})
    public ResponseEntity deposit(@PathVariable Long id, @PathVariable BigDecimal amount) {
        //chama o metodo deposit da classe depositUseCase e o retorno é armazenado na variavel deposit e 
        //retorna a resposta http com o objeto encontrado em formato json
        return ResponseEntity.ok(depositUseCase.deposit(id, amount));
    }


    /**
     * Endpoint for withdrawing money from a bank account.
     * 
     * @param id The ID of the bank account.
     * @param amount The amount of money to withdraw.
     */
    @PostMapping(value = {"{id}/withdraw/{amount}"})
    void withdraw(@PathVariable Long id, @PathVariable BigDecimal amount) {
        withdrawUseCase.withdraw(id, amount);
    }
}
