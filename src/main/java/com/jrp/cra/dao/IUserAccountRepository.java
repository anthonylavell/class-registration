package com.jrp.cra.dao;

import com.jrp.cra.entites.UserAccount;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUserAccountRepository extends PagingAndSortingRepository<UserAccount,Long> {
}
