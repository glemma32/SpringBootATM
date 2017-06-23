package ATM;


import org.springframework.data.repository.CrudRepository;

import ATM.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction,Long> {

}
