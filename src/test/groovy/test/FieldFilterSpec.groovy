package test

import spock.lang.Specification

class FieldFilterSpec extends Specification {

    def "Filter object fields"() {
        given:
        def fieldFilter = new FieldFilter()
        def student = new Student(firstName: "Ole", lastName: "Olsen", mobile: "99999999", age: 15)
        def allowedFieldList = ["firstName", "age"]
        def filteredStudent = new Student()

        when:
        filteredStudent = fieldFilter.filter(student, allowedFieldList)

        then:
        filteredStudent.getFirstName() == "Ole"
        filteredStudent.getLastName() == null
        filteredStudent.getMobile() == null
        filteredStudent.getAge() == 15

    }

    def "Filter list of objects"() {
        given:
        def fieldFilter = new FieldFilter()
        def student1 = new Student(firstName: "Ole1", lastName: "Olsen1", mobile: "99999999", age: 15)
        def student2 = new Student(firstName: "Ole2", lastName: "Olsen2", mobile: "99999998", age: 14)
        def student3 = new Student(firstName: "Ole3", lastName: "Olsen3", mobile: "99999997", age: 13)
        def studentList = [student1, student2, student3]
        def allowedFieldList = ["firstName", "age"]
        def filteredStudentList = []

        when:
        filteredStudentList = fieldFilter.filterList(studentList, allowedFieldList)

        then:
        filteredStudentList[0].getFirstName() == "Ole1"
        filteredStudentList[0].getLastName() == null
        filteredStudentList[0].getMobile() == null
        filteredStudentList[0].getAge() == 15

        filteredStudentList[1].getFirstName() == "Ole2"
        filteredStudentList[1].getLastName() == null
        filteredStudentList[1].getMobile() == null
        filteredStudentList[1].getAge() == 14

        filteredStudentList[2].getFirstName() == "Ole3"
        filteredStudentList[2].getLastName() == null
        filteredStudentList[2].getMobile() == null
        filteredStudentList[2].getAge() == 13

    }
}
