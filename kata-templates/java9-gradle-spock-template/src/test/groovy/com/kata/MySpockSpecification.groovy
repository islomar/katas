package com.kata

import spock.lang.Specification
import spock.lang.Subject

class MySpockSpecification extends Specification {

    @Subject
    private MyClass sut = new MyClass()

    def "This should describe the specification being tested"() {

        when:
            String salutation = sut.sayHello("Paquito")

        then:
            salutation == "Hello, Paquito"
            salutation org.hamcrest.Matchers.equalTo("Hello, Paquito")
    }


    def "Another example using a Hamcrest matcher"() {

        given:
            def myList = new ArrayList<String>()

        when:
            myList.add("one")

        then:
            myList org.hamcrest.Matchers.contains("onex")
    }

}
