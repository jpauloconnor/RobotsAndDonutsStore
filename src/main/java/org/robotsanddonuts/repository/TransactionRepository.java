package org.robotsanddonuts.repository;

import org.robotsanddonuts.beans.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

}
