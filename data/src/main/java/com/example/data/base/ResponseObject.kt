package com.example.data.base


interface ResponseObject <out DomainObject : Any?>{

    fun toDomain():DomainObject
}