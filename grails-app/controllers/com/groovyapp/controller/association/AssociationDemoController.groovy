package com.groovyapp.controller.association

import com.groovyapp.domain.association.Location
import com.groovyapp.domain.association.Parents
import com.groovyapp.domain.association.Student
import com.groovyapp.domain.association.Subjects

/**
 * Created by user on 7/11/2016.
 */
class AssociationDemoController {

    def index() {
        render "Association Demo..."
    }

    def manyToOneDemo() {
        try {
            def student = new Student(name: 'Mic', location: new Location(name: "Kolkata"))
            student = student.save(flush: true, failOnError: true)
            render("Added Student:" + student)
        }
        catch (e) {
            e.printStackTrace()
        }

    }

    def manyToOneDemoFetch() {
        try {

            def location = Location.get(params.id)
            render("Fetched location:" + location + " For student:" + location.student.name)
        }
        catch (e) {
            e.printStackTrace()
        }

    }

    def oneToOneDemo() {
        try {
            def student = new Student(name: params.name, location: new Location(name: params.location.name), parents: new Parents(father: params.parents.father.name, mother: params.parents.mother.name))
            student = student.save(flush: true, failOnError: true)
            render("Added Student:" + student)
        }
        catch (e) {
            e.printStackTrace()
        }

    }

    def oneToOneDemoFetch() {
        try {
            def parents = Parents.get(params.id)
            render("Fetched Parent:" + parents.father + "-" + parents.mother + "\n Student ID:" + parents.studentId + "- name:" + parents.student.name + "\n" + "Location ID:" + parents.student.locationId + "- name:" + parents.student.location.name)

        }
        catch (e) {
            e.printStackTrace()
        }
    }

    def oneToManyDemo() {
        try {

           /* def subject1 = new Subjects(name:'Maths')
            def subject2 = new Subjects(name:'Chem')

            subject1.save(flush: true, failOnError: true)
            subject2.save(flush: true, failOnError: true)

            println "Subjects Persisted!!!!"*/

            def subject1 = new Subjects(params.subjects)
            println "Subjects is $subject1"

            def student = new Student(name: params.name, location: new Location(name: params.location.name), parents: new Parents(father: params.parents.father.name, mother: params.parents.mother.name))
            student = student
                    .addToSubjects(name:'Maths')
                    .addToSubjects(name:'Chemistry')
                    .save(flush: true, failOnError: true)

            if (student.hasErrors()) {
                student.errors.allErrors.each {
                    println it
                }
            }

                render("Added Student:" + student)
        }
        catch (e) {
            e.printStackTrace()
        }
    }


}
