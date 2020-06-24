package com.jrp.cra.dao;

import com.jrp.cra.entites.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface IUserAccountRepository extends CrudRepository<UserAccount,Long> {
}
