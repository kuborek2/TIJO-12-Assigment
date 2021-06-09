package pl.edu.pwsztar

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class CreateAccountSpec extends Specification {

    static BankOperation bank;

    def setupSpec() {
        bank = new Bank();
    }

    @Unroll
    def "should create account number #accountNumber for #user"() {

        when: "the account is created"
            def number = bank.createAccount()
        then: "check account number"
            number == accountNumber

        where:
            user   | accountNumber
            'John' | 1
            'Tom'  | 2
            'Mike' | 3
            'Todd' | 4
    }
}
