package com.example.starshineacademy.models

class user {
    var name:String = ""
    var email:String = ""
    var password:String = ""
    var id:String = ""

    constructor(name: String, email: String, password: String, id: String) {
        this.name = name
        this.email = email
        this.password = password
        this.id = id
    }

    constructor()
}