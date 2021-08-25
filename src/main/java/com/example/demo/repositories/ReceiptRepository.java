package com.example.demo.repositories;

import com.example.demo.models.Receipt;
import org.springframework.data.repository.CrudRepository;

public interface ReceiptRepository extends CrudRepository<Receipt, Long> {

    void deleteByTransactionId(Long transactionId);

    Receipt findByTransactionId(Long transactionId);

    boolean existsByTransactionId(Long transactionId);
}
