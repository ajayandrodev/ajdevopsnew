package com.ajayrockstarindevops.model

/**
 * Created by Alessandro Barreto on 24/06/2016.
 */
class MapModel {
    var latitude: String? = null
    var longitude: String? = null

    constructor() {}

    constructor(latitude: String, longitude: String) {
        this.latitude = latitude
        this.longitude = longitude
    }
}
