package com.ajayrockstarindevops.model


/**
 * Created by Ajay on 6/14/2018.
 */
class Blog {
    var title: String? = null
    var description: String? = null
    //  var image: String? = null

    constructor() {}
    constructor(title: String, description: String) {
        this.title = title
        this.description = description
        //  this.image = image
    }
}