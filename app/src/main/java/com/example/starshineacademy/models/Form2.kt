package com.example.starshineacademy.models

class Form2 {
    var fullname:String = ""
    var guardianname:String = ""
    var guardianphonenumber:String = ""
    var gender:String = ""
    var kcpemarks:String = ""
    var imageUrl:String = ""
    var id:String = ""

    constructor(firstname:String,guardianname:String,guardianphonenumber:String,gender:String,kcpemarks:String,id:String){
        this.fullname = firstname
        this.guardianname = guardianname
        this.guardianphonenumber = guardianphonenumber
        this.gender = gender
        this.kcpemarks = kcpemarks
        this.imageUrl = imageUrl
        this.id = id

    }
    constructor()
}