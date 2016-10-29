package no.fint.filter.object

import no.fint.filter.object.model.Student
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
        filteredStudent.getFirstName() == "Ole"
        filteredStudent.getLastName() == null
        filteredStudent.getMobile() == null
        filteredStudent.getAge() == 15

    }
}
