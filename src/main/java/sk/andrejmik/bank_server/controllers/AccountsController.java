package sk.andrejmik.bank_server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.andrejmik.bank_server.business_logic.interfaces.IAccountProvider;
import sk.andrejmik.bank_server.entities.Account;

@RestController
@RequestMapping("/accounts")
public class AccountsController
{
    private final IAccountProvider mAccountProvider;

    @Autowired
    public AccountsController(IAccountProvider accountProvider)
    {
        mAccountProvider = accountProvider;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, path = "/save")
    public @ResponseBody
    ResponseEntity<Account> save(@RequestBody Account data)
    {
        if (data == null)
        {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        if (mAccountProvider.insert(data))
        {
            return new ResponseEntity<>(data, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
