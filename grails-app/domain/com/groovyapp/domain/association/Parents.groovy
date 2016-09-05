package com.groovyapp.domain.association

class Parents {

    String father
    String mother

    static belongsTo = [student:Student]
    static constraints = {
    }
}
