package pl.edu.pwsztar

import spock.lang.Specification

/**
 * https://tomaszgadek.com
 */
class TransactionAccountSpec extends Specification {

    def static bank

    def setupSpec() {
        bank = new Bank()
    }

    def "should check transaction"() {

        given:
            2.times {
                bank.createAccount()
            }

        when:
            bank.deposit(1, 225)
            bank.deposit(2, 950)

        then:
            bank.transfer(1, 2, 25) == true
            bank.accountBalance(1) == 200
            bank.accountBalance(2) == 975
        and:
            bank.transfer(1, 2, 210) == false
            bank.accountBalance(1) == 200
            bank.accountBalance(2) == 975
        and:
            bank.transfer(1, 2, -1) == false
            bank.accountBalance(1) == 200
            bank.accountBalance(2) == 975
        and:
            bank.transfer(1, BankOperation.ACCOUNT_NOT_EXISTS, 200) == false
            bank.accountBalance(1) == 200
            bank.accountBalance(2) == 975
    }
}
