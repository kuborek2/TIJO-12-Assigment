package pl.edu.pwsztar

import spock.lang.Specification

/**
 * https://tomaszgadek.com
 */
class DeleteAccountSpec extends Specification {

    def static bank

    def setupSpec() {
        bank = new Bank()
    }

    def "should check delete account"() {

        given:
            def deletedAccounts = []

            def firstAccount = bank.createAccount()
            def secondAccount = bank.createAccount()

        when:
            deletedAccounts.add(bank.deleteAccount(firstAccount))
            deletedAccounts.add(bank.deleteAccount(secondAccount))
            deletedAccounts.add(bank.deleteAccount(-1000000))
            deletedAccounts.add(bank.deleteAccount(firstAccount))
            deletedAccounts.add(bank.deleteAccount(secondAccount))
        then:
            deletedAccounts == [0, 0, Bank.ACCOUNT_NOT_EXISTS, Bank.ACCOUNT_NOT_EXISTS, Bank.ACCOUNT_NOT_EXISTS]
    }
}
