package id.icena.sample.data.mapper

import android.annotation.SuppressLint
import id.icena.sample.data.datasource.local.model.UserLocalEntity
import id.icena.sample.data.datasource.remote.model.UserApiEntity
import id.icena.sample.domain.model.User
import java.text.SimpleDateFormat
import java.util.*

class UserMapper {

    // mapper domain model to data local model
    fun mappingDomainToLocal(user: User, id: Int): UserLocalEntity {
        return UserLocalEntity(
            id = id,
            name = user.name,
            age = user.age,
            createAt = getCurrentDate()
        )
    }

    // mapper data api model to data local model
    fun mappingApiToLocal(user: UserApiEntity): UserLocalEntity {
        return UserLocalEntity(
            id = 1,
            name = user.name,
            age = user.age,
            createAt = getCurrentDate()
        )
    }

    // mapper data api model to domain model
    fun mappingApiToDomain(result: UserApiEntity): User? {
        return User(
            id = 0,
            name = result.name,
            age = result.age,
            isFromApi = true
        )
    }

    // mapper data local model to domain model
    fun mappingLocalToDomain(result: UserLocalEntity): User? {
        return User(
            id = result.id,
            name = result.name,
            age = result.age,
            isFromApi = false
        )
    }

    // get current date
    @SuppressLint("SimpleDateFormat")
    private fun getCurrentDate(): String {
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        return sdf.format(Date())
    }
}