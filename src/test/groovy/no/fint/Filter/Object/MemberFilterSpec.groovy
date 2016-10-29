package no.fint.Filter.Object

import no.fint.Filter.Object.TestModel.Student
import spock.lang.Specification


class MemberFilterSpec extends Specification {

    def "Filter object members"() {
        given:
        def memberFilter = new MemberFilter()
        def student = new Student(firstName: "Ole", lastName: "Olsen", mobile: "99999999", age: 15)
        def members = ["firstName", "age"]
        def filteredStudent = new Student()

        when:
        filteredStudent = memberFilter.filter(student, members)

        then:
        filteredStudent.getAge() == 15
    }
}
