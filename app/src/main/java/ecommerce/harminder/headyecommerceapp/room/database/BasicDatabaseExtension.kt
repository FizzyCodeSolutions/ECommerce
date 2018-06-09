package ecommerce.harminder.headyecommerceapp.room.database

import android.arch.persistence.room.Room
import android.content.Context


var database: CategoryDB? = null
fun dbInstance(context: Context): CategoryDB {

    if (database != null) return database!!

    database = Room.databaseBuilder(context,
            CategoryDB::class.java, "Ecommerce.db")
            .build()

    return database!!


}