package com.easybanks.accounts.service;

import com.easybanks.accounts.dto.CustomerDTO;

public interface IAccountService {
    void createAccount(CustomerDTO customerDTO);
    CustomerDTO fetchAccount(String mobileNumber);
    boolean updateAccount(CustomerDTO customerDTO);
}
