package com.ajayrockstarindevops.model

/**
 * Created by Alessandro Barreto on 22/06/2016.
 */
class FileModel {

    var type: String? = null
    var url_file: String? = null
    var name_file: String? = null
    var size_file: String? = null

    constructor() {}

    constructor(type: String, url_file: String, name_file: String, size_file: String) {
        this.type = type
        this.url_file = url_file
        this.name_file = name_file
        this.size_file = size_file
    }
}
