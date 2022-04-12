package pl.edu.pwsztar;

import java.util.Map;
import java.util.Optional;

// TODO: Prosze dokonczyc implementacje oraz testy jednostkowe
// TODO: Prosze nie zmieniac nazw metod - wszystkie inne chwyty dozwolone
// TODO: (prosze jedynie trzymac sie dokumentacji zawartej w interfejsie BankOperation)
class Bank implements BankOperation {

    private final AccountStorage accountStorage;
    private int accountNumber = 1;

    public Bank(){
        this.accountStorage = new AccountStorage();
    }

    public int createAccount() {
        Account account = new Account(accountNumber);
        accountStorage.append(account);
        accountNumber++;
        return account.getAccountNumber();
    }

    public int deleteAccount(int accountNumber) {
        if ( accountStorage.contains(accountNumber) ){
            Optional<Account> optionalAccount = accountStorage.getAccount(accountNumber);
            if( optionalAccount.isPresent() ){
                int accountBalance = optionalAccount.get().getAccountBalance();
                accountStorage.remove(accountNumber);
                return accountBalance;
            }
        }
        return -1;
    }

    public boolean deposit(int accountNumber, int amount) {
        if( amount > 0 ){
            if (accountStorage.contains(accountNumber)) {
                Optional<Account> optionalAccount = accountStorage.getAccount(accountNumber);
                if (optionalAccount.isPresent()) {
                    Account account = optionalAccount.get();
                    account.setAccountBalance(account.getAccountBalance() + amount);
                    accountStorage.replace(accountNumber, account);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean withdraw(int accountNumber, int amount) {
        if( amount > 0 ){
            if (accountStorage.contains(accountNumber)) {
                Optional<Account> optionalAccount = accountStorage.getAccount(accountNumber);
                if (optionalAccount.isPresent()) {
                    Account account = optionalAccount.get();
                    if( account.getAccountBalance() >= amount ) {
                        account.setAccountBalance(account.getAccountBalance() - amount);
                        accountStorage.replace(accountNumber, account);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean transfer(int fromAccount, int toAccount, int amount) {
        if( amount > 0 ){
            if ( accountStorage.contains(fromAccount) && accountStorage.contains(toAccount) ) {
                Optional<Account> optionalFromAccount = accountStorage.getAccount(fromAccount);
                Optional<Account> optionalToAccount = accountStorage.getAccount(toAccount);
                if (optionalFromAccount.isPresent() && optionalToAccount.isPresent()) {
                    Account fromAcc = optionalFromAccount.get();
                    Account toAcc = optionalToAccount.get();
                    if( fromAcc.getAccountBalance() >= amount ) {
                        fromAcc.setAccountBalance(fromAcc.getAccountBalance() - amount);
                        toAcc.setAccountBalance(toAcc.getAccountBalance() + amount);
                        accountStorage.replace(fromAccount, fromAcc);
                        accountStorage.replace(toAccount, toAcc);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int accountBalance(int accountNumber) {
        if ( accountStorage.contains(accountNumber) ) {
            Optional<Account> optionalAccount = accountStorage.getAccount(accountNumber);
            if (optionalAccount.isPresent()) {
                Account account = optionalAccount.get();
                return account.getAccountBalance();
            }
        }
        return -1;
    }

    public int sumAccountsBalance() {
        int balanceSum = 0;
        Map<Integer, Account> storage = accountStorage.getStorage();
        for( Account acc : storage.values() ){
            balanceSum += acc.getAccountBalance();
        }
        return balanceSum;
    }
}
