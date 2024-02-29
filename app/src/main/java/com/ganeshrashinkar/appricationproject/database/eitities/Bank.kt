package com.ganeshrashinkar.appricationproject.database.eitities

data class Bank(
    var cardExpire : String? = null,
    var cardNumber : String? = null,
    var cardType   : String? = null,
    var currency   : String? = null,
    var iban       : String? = null
)
