package pl.edu.pwsztar

import spock.lang.Specification
import spock.lang.Unroll

class DeleteAccountSpec extends Specification {

    static BankOperation bank;

    def setupSpec() {
        bank = new Bank();
    }

    @Unroll
    def "should delete account #user and return #accountBalance"() {

        given: "the acount is being created"
            bank.createAccount()

        when: "the account is deleted"
            def accountBalance = bank.deleteAccount(accountNumber);

        then: "check account balance"
            accountBalance == 0

        where:
        user   | accountNumber
        'John' | 1
        'Tom'  | 2
        'Mike' | 3
        'Todd' | 4
    }

    @Unroll
    def "should delete account #user and return -1"() {

        when: "the account is deleted"
            def accountBalance = bank.deleteAccount(fakeAccountNumber);

        then: "check account balance"
            accountBalance == Bank.ACCOUNT_NOT_EXISTS

        where:
        user   | accountNumber  | fakeAccountNumber
        'John' | 1              | 0
        'Tom'  | 2              | -1
        'Mike' | 3              | 4
        'Todd' | 4              | 8
    }

    @Unroll
    def "should delete account #user and return account Balance"() {

        given: "create account and deposit money"
            bank.createAccount()
            bank.deposit(accountNumber, 100) >> true

        when: "the account is deleted"
            def accountBalance = bank.deleteAccount(accountNumber);

        then: "check account balance"
            accountBalance == 100

        where:
        user   | accountNumber
        'John' | 1
        'Tom'  | 2
        'Mike' | 3
        'Todd' | 4
    }



}
