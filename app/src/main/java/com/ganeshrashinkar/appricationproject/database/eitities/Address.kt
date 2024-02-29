package com.ganeshrashinkar.appricationproject.database.eitities

data class Address (  var address     : String?      = null,
                      var city        : String?      = null,
                      var coordinates : Coordinates? = Coordinates(),
                      var postalCode  : String?      = null,
                      var state       : String?      = null)