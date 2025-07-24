package com.expense.manager.repository;

import com.expense.manager.models.FinAppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<FinAppUser, String> {
}
