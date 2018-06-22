package com.ajayrockstarindevops.model

import java.util.HashMap

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

    constructor(date: String, title: String, content: String, name: String) {
        this.title = title
        this.content = content
        this.name = name
        this.date = date
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
