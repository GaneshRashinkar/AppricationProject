package com.ganeshrashinkar.appricationproject.database.eitities

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class UserClass (

    @PrimaryKey(autoGenerate = true)var id : Int?= null,
    var firstName  : String?  = null,
    var lastName   : String?  = null,
    var maidenName : String?  = null,
    var age        : Int?     = null,
    var gender     : String?  = null,
    var email      : String?  = null,
    var phone      : String?  = null,
    var username   : String?  = null,
    var password   : String?  = null,
    var birthDate  : String?  = null,
    var image      : String?  = null,
    var bloodGroup : String?  = null,
    var height     : Int?     = null,
    var weight     : Double?  = null,
    var eyeColor   : String?  = null,
    @Ignore
    var hair       : Hair?    = Hair(),
    var domain     : String?  = null,
    var ip         : String?  = null,
    @Ignore
    var address    : Address? = Address(),
    var macAddress : String?  = null,
    var university : String?  = null,
    @Ignore
    var bank       : Bank?    = Bank(),
    @Ignore
    var company    : Company? = Company(),
    var ein        : String?  = null,
    var ssn        : String?  = null,
    var userAgent  : String?  = null,
    @Ignore
    var crypto     : Crypto?  = Crypto()
        )