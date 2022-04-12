package pl.edu.pwsztar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AccountStorage {

    private Map<Integer, Account> storage;
/*    private static AccountStorage single_instance = null;*/

    public AccountStorage() {
        this.storage = new HashMap<>();
    }

/*    public static AccountStorage getInstance()
    {
        if (single_instance == null)
            single_instance = new AccountStorage();

        return single_instance;
    }*/

    public Map<Integer, Account> getStorage() {
        return storage;
    }

    public void append(Account account){
        this.storage.put(account.getAccountNumber(), account);
    }

    /**
     * Removes account from accoutn storage
     * @param accountNumber
     * @return 1 if succesfull, -1 if not
     */
    public int remove(int accountNumber){
        if( this.storage.containsKey(accountNumber) ){
            this.storage.remove(accountNumber);
            return 1;
        }
        return -1;
    }

    public Boolean contains(int accountNumber){
        if( this.storage.containsKey(accountNumber) ){
            return true;
        }
        return false;
    }

    public Boolean replace(int accountNumber, Account account){
        if( this.storage.containsKey(accountNumber) ){
            this.storage.replace(accountNumber,account);
            return true;
        }
        return false;
    }

    public Optional<Account> getAccount(int accountNumber){
        try {
            if( this.storage.containsKey(accountNumber) ){
                Optional<Account> account = Optional.of(this.storage.get(accountNumber));
                return account;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.of(null);
    }

}
