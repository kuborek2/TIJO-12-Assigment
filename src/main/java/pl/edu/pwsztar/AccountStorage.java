package pl.edu.pwsztar;

import java.util.ArrayList;
import java.util.Optional;

public class AccountStorage {

    private ArrayList<Account> storage;
    private ArrayList<Integer> accountList;
    private static AccountStorage single_instance = null;

    private AccountStorage() {
        this.storage = new ArrayList<>();
    }

    public static AccountStorage getInstance()
    {
        if (single_instance == null)
            single_instance = new AccountStorage();

        return single_instance;
    }

    public void append(Account account){
        this.storage.add(account);
        this.accountList.add(account.getAccountNumber());
    }

    /**
     * Removes account from accoutn storage
     * @param accountNumber
     * @return 1 if succesfull, -1 if not
     */
    public int remove(int accountNumber){
        if( this.accountList.contains(accountNumber) ){
            this.storage.remove(this.accountList.indexOf(accountNumber));
            this.accountList.remove(accountNumber);
            return 1;
        }
        return -1;
    }

    public Boolean contains(int accountNumber){
        if( this.accountList.contains(accountNumber) ){
            return true;
        }
        return false;
    }

    public Optional<Account> getAccount(int accountNumber){
        try {
            if( this.accountList.contains(accountNumber) ){
                Optional<Account> = this.storage.get((this.accountList.indexOf(accountNumber)));
                return ;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional<null>;
    }
}
