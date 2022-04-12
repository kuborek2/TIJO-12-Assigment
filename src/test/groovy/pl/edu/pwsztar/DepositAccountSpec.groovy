package pl.edu.pwsztar

import spock.lang.Specification

/**
 * https://tomaszgadek.com
 */
class DepositAccountSpec extends Specification {

    def static bank

    def setupSpec() {
        bank = new Bank()
    }

    def "should check deposit amount"() {

        given:
            4.times {
                bank.createAccount()
            }

            def deletedAccountNumber = bank.createAccount()
            bank.deleteAccount(deletedAccountNumber)
        expect:
            bank.deposit(1, 100) == true
            bank.deposit(2, 300) == true
            bank.deposit(3, 400) == true
            bank.deposit(4, 500) == true
            bank.deposit(4, 450) == true
            bank.deposit(1, -5) == false
            bank.deposit(deletedAccountNumber, 900) == false
    }
}
