package com.kineduchallenge.core.database.dao

interface BaseDao<T> {

    fun deleteAll()

    fun add(data: T)

    fun get(id: Int): T

    fun getAll(): List<T>
}