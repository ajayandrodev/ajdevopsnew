package com.ajayrockstarindevops.model


/**
 * Created by Alessandro Barreto on 17/06/2016.
 */
class ChatModel {

    var id: String? = null
    var userModel: UserModel? = null
    var message: String? = null
    var timeStamp: String? = null
    var file: FileModel? = null
    var mapModel: MapModel? = null

    constructor() {}

    constructor(userModel: UserModel, message: String, timeStamp: String, file: FileModel) {
        this.userModel = userModel
        this.message = message
        this.timeStamp = timeStamp
        this.file = file
    }

    constructor(userModel: UserModel, timeStamp: String, mapModel: MapModel) {
        this.userModel = userModel
        this.timeStamp = timeStamp
        this.mapModel = mapModel
    }

    override fun toString(): String {
        return "ChatModel{" +
                "mapModel=" + mapModel +
                ", file=" + file +
                ", timeStamp='" + timeStamp + '\''.toString() +
                ", message='" + message + '\''.toString() +
                ", userModel=" + userModel +
                '}'.toString()
    }
}
