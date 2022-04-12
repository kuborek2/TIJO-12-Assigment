package pl.edu.pwsztar

import spock.lang.Specification

/**
 * https://tomaszgadek.com
 */
class WithdrawAccountSpec extends Specification {

    def static bank

    def setupSpec() {
        bank = new Bank()
    }

    def "should check withdraw amount"() {

        given:
            2.times {
                bank.createAccount()
            }

            def deletedAccountNumber = bank.createAccount()
            bank.deleteAccount(deletedAccountNumber)

        when:
            bank.deposit(1, 100)
            bank.deposit(2, 50)

        then:
            bank.withdraw(1, 50) == true
            bank.withdraw(2, 50) == true
            bank.withdraw(1, 1) == true
            bank.withdraw(2, 1) == false
            bank.withdraw(2, -100) == false
            bank.withdraw(3, 49) == false
        and:
            bank.accountBalance(1) == 49
            bank.accountBalance(2) == 0
            bank.accountBalance(3) == BankOperation.ACCOUNT_NOT_EXISTS
        and:
            bank.sumAccountsBalance() == 49
    }
}
