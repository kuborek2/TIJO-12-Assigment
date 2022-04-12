package pl.edu.pwsztar

import spock.lang.Specification

/**
 * https://tomaszgadek.com
 */
class BalanceSumAccountSpec extends Specification {

    def static bank

    def setupSpec() {
        bank = new Bank()
    }

    def "should check sum account balance"() {
        given:
            def amounts = [100, 175, 25, 15, 210, 655, 119]
            def accounts = [1, 2, 3, 4, 5, 6, 7, 8]

            7.times {
                def accountNumber = bank.createAccount()
                bank.deposit(accountNumber, amounts[it])
            }

            def deletedAccountNumber = bank.createAccount()
            bank.deleteAccount(deletedAccountNumber)

        when:
            def allAccountsBalance = 0
            accounts.each {
                def balance = bank.accountBalance(it)
                allAccountsBalance += (balance == -1 ? 0 : balance)
            }

        then:
            allAccountsBalance == amounts.sum()
    }
}
