package model

data class User(
    val nickName: String,
    val email: String,
    val pictureUrl: String? = null,
    val isEditable: Boolean = false
)