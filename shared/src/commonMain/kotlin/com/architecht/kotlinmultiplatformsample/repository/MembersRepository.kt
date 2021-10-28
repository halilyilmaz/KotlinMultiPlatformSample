package com.architecht.kotlinmultiplatformsample.repository

import com.architecht.db.Member
import com.architecht.db.SampleDB
import com.architecht.db.User
import com.squareup.sqldelight.Query
import com.squareup.sqldelight.db.SqlDriver

class MembersRepository(databaseDriverFactory: DatabaseDriverFactory) {
    private val database: SampleDB = SampleDB(databaseDriverFactory.createDriver())

    init {
        
    }

    fun fetchAllMembers() : Query<Member> {
        val members = database.sampleDBQueries.selectAll()
        return members
    }

    fun insertMember(id: Long, name: String, avatar: String) {
        database.sampleDBQueries.insertItem(id, name, avatar)
    }

    fun select(id: Long) : Member? {
        val member = database.sampleDBQueries.selectOneOfById(id)
        return member.executeAsOneOrNull()
    }

    fun deleteAllMembers() {
        database.sampleDBQueries.deleteAll()
    }

    fun insertUser(name: String, lastName: String) {
        database.sampleDBQueries.insertUser(name, lastName)
    }

    fun selectAllUsers() : List<User> {
        return database.sampleDBQueries.selectAllUser().executeAsList()
    }
}