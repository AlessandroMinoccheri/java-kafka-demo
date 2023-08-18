import spock.lang.Specification

class FooTest extends Specification {
    def "test something"() {
        given:
        def value = 2

        when:
        def result = value * 2

        then:
        result == 4
    }
}