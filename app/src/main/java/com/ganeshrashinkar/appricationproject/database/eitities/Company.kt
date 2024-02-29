package com.ganeshrashinkar.appricationproject.database.eitities

data class Company(
    var address    : Address? = Address(),
    var department : String?  = null,
    var name       : String?  = null,
    var title      : String?  = null
)
