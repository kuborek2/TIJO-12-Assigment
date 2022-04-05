package pl.edu.pwsztar;

public class Account {

    private int accountNumber;
    private int accountBalance;

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        this.accountBalance = 0;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountBalance(){
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }
}
