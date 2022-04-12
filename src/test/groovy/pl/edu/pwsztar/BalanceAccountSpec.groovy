package pl.edu.pwsztar

import spock.lang.Specification

/**
 * https://tomaszgadek.com
 */
class BalanceAccountSpec extends Specification {

    def static bank

    def setupSpec() {
        bank = new Bank()
    }

    def "should check account balance"() {

        given:
            3.times {
                bank.createAccount()
            }

            def deletedAccountNumber = bank.createAccount()
            bank.deleteAccount(deletedAccountNumber)

        when:
            bank.deposit(1, 100)
            bank.deposit(2, 300)

        then:
            bank.accountBalance(1) == 100
            bank.accountBalance(2) == 300
            bank.accountBalance(3) == 0
            bank.accountBalance(deletedAccountNumber) == BankOperation.ACCOUNT_NOT_EXISTS
    }
}
