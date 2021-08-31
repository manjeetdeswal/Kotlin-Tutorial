package com.mddstudio.test69.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Subs")
data class Subscriber(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var email: String
)
