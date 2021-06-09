package pl.edu.pwsztar;

// TODO: Prosze dokonczyc implementacje oraz testy jednostkowe
// TODO: Prosze nie zmieniac nazw metod - wszystkie inne chwyty dozwolone
// TODO: (prosze jedynie trzymac sie dokumentacji zawartej w interfejsie BankOperation)
class Bank implements BankOperation {

    private int accountNumber = 0;

    public int createAccount() {
        return ++accountNumber;
    }

    public int deleteAccount(int accountNumber) {
        return 0;
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
