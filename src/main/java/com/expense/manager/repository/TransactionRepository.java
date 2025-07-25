package com.expense.manager.repository;

import com.expense.manager.models.Transactions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends CrudRepository<Transactions, Long> {

    @Query(value = "select c.name,sum(t.amount) from transactions t join category c on t.category_id = c.id\n" +
            "\t\t\twhere c.expense_type = 1 and t.user_id = :no\n" +
            " and t.local_date <= :endTime and t.local_date >= :startTime" +
            "            group by c.id,c.name ", nativeQuery = true)
    List<Object[]> getExpenses(@Param("no") String no, @Param("endTime") LocalDate endTime, @Param("startTime") LocalDate startTime);

    @Query(value = "select sum(amount) from transactions where  user_id = :no and category_id = 7 and local_date <= :endTime and local_date >= :startTime ", nativeQuery = true)
    Long getIncomeTotal(@Param("no") String no, @Param("endTime") LocalDate endTime, @Param("startTime") LocalDate startTime);
}
