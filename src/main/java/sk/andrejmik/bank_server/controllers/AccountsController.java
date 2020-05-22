package sk.andrejmik.bank_server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.andrejmik.bank_server.business_logic.interfaces.IAccountProvider;
import sk.andrejmik.bank_server.entities.Account;

import java.util.List;

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

    @RequestMapping(method = RequestMethod.POST, path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
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

    @RequestMapping(method = RequestMethod.GET, path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<List<Account>> getAll()
    {
        List<Account> accounts = mAccountProvider.getAll();
        if (accounts.isEmpty())
        {
            return new ResponseEntity<>(accounts, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/detail/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Account> detail(@PathVariable("id") String accountId)
    {
        Account account = mAccountProvider.get(accountId);
        if (account == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/remove/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity remove(@PathVariable("id") String accountId)
    {
        if (mAccountProvider.delete(accountId))
        {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
