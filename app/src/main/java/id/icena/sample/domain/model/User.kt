package id.icena.sample.domain.model

data class User(
    val id: Int,
    val name: String,
    val age: Int,
    val isFromApi: Boolean?
)