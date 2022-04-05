package pl.edu.pwsztar;

// TODO: Prosze dokonczyc implementacje oraz testy jednostkowe
// TODO: Prosze nie zmieniac nazw metod - wszystkie inne chwyty dozwolone
// TODO: (prosze jedynie trzymac sie dokumentacji zawartej w interfejsie BankOperation)
class Bank implements BankOperation {

    private final AccountStorage accountStorage;
    private int accountNumber = 1;

    public Bank(){
        this.accountStorage = AccountStorage.getInstance();
    }

    public int createAccount() {
        Account account = new Account(accountNumber);
        accountStorage.append(account);
        accountNumber++;
        return account.getAccountNumber();
    }

    public int deleteAccount(int accountNumber) {
        if ( accountStorage.contains(accountNumber) ){
            int accountBalance = accountStorage.getAccount(accountNumber).getAccountBalance();
            accountStorage.remove(accountNumber);
            return accountBalance;
        }
        return -1;
    }

    public boolean deposit(int accountNumber, int amount) {
        return false;
    }

    public boolean withdraw(int accountNumber, int amount) {
        return false;
    }

    public boolean transfer(int fromAccount, int toAccount, int amount) {
        return false;
    }

    public int accountBalance(int accountNumber) {
        return 0;
    }

    public int sumAccountsBalance() {
        return 0;
    }
}
