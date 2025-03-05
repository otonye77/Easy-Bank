package com.easybanks.accounts.controller;

import com.easybanks.accounts.constants.AccountConstants;
import com.easybanks.accounts.dto.CustomerDTO;
import com.easybanks.accounts.dto.ResponseDTO;
import com.easybanks.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountController {
    private IAccountService iAccountService;

    @PostMapping("/create")
   public ResponseEntity<ResponseDTO> createAccount(@RequestBody CustomerDTO customerDTO){
        iAccountService.createAccount(customerDTO);
       return ResponseEntity
               .status(HttpStatus.CREATED)
               .body(new ResponseDTO(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));
   }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDTO> fetchAccountDetails(@RequestParam String mobileNumber){
        CustomerDTO customerDto = iAccountService.fetchAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

}
