package org.d3if1027.mynotes.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes")
class Notes(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var title: String,
    var subtitle: String,
    var notes: String,
    var priority: String,
    date: String
)