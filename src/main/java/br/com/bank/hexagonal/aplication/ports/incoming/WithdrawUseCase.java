package br.com.bank.hexagonal.aplication.ports.incoming;

import java.math.BigDecimal;

public interface WithdrawUseCase {
    
    Boolean withdraw(Long id, BigDecimal value);
}
