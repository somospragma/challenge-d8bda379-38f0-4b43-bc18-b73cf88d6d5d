package com.pragma.transactions;

import com.pragma.transactions.domain.TransactionService;
import com.pragma.transactions.infrastructure.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;
import static org.mockito.Mockito.when;

public class TransactionServiceTest {
    @Test
    public void testProcessTransaction() {
        TransactionRepository repository = Mockito.mock(TransactionRepository.class);
        TransactionService service = new TransactionService(repository);
        when(repository.saveTransaction("web", 100.0, UUID.randomUUID().toString())).thenReturn(Mono.just("Transaction processed"));
        service.processTransaction("web", 100.0, UUID.randomUUID().toString()).subscribe();
    }
}