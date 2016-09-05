package com.groovyapp.domain.association

class Location {

    String name

    static belongsTo = [student:Student]
    static constraints = {
    }
}
