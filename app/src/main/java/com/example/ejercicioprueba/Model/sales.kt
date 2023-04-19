package com.example.ejercicioprueba.Model

import java.io.Serializable
import java.sql.Timestamp

class sales: Serializable {
    lateinit var tittle: String
    lateinit var user_email: String
    lateinit var total_value: Number
    lateinit var date: Timestamp

}