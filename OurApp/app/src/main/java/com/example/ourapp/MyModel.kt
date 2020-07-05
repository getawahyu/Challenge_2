package com.example.ourapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_data")
data class MyModel(
    var nama: String,
    var email: String,
    var telp: String,
    var alamat: String,
    @PrimaryKey var key: String
){
    constructor() : this("","","","",""
    )
}
