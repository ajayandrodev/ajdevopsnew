package com.ajayrockstarindevops.model

import java.util.*

class Note {

    var id: String? = null
    var title: String? = null
    var content: String? = null
    var name: String? = null
    var date: String? = null

    constructor() {}

    /*
        constructor(id: String, title: String, content: String, name: String) {
            this.id = id
            this.title = title
            this.content = content
            this.name = name
        }
    */
    constructor(content: String) {
        this.content = content
    }


    constructor(date: String, title: String, content: String, name: String) {
        this.title = title
        this.content = content
        this.name = name
        this.date = date
    }

    fun toMapFag(): Map<String, Any> {
        val result = HashMap<String, Any>()
        result.put("content", content!!)

        return result
    }


    fun toMap(): Map<String, Any> {

        val result = HashMap<String, Any>()
        result.put("date", date!!)
        result.put("title", title!!)
        result.put("content", content!!)
        result.put("name", name!!)

        return result
    }
}
