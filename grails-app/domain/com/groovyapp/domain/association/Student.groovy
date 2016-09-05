package com.groovyapp.domain.association

class Student {

    String name
    Location location

    static hasOne = [parents:Parents]
    static hasMany = [subjects:Subjects]
    static constraints = {
    }
}
