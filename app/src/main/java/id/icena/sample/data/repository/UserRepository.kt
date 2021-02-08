package id.icena.sample.data.repository

import id.icena.sample.data.datasource.UserDataSource
import id.icena.sample.data.datasource.local.model.UserLocalEntity
import id.icena.sample.data.datasource.remote.model.UserApiEntity
import id.icena.sample.domain.model.User

class UserRepository(
    private val apiDataSource: UserDataSource.Remote,
    private val localDataSource: UserDataSource.Local
) {
    fun getUser(): User? {
        return if (localDataSource.getUser() != null) {
            mappingLocalToDomain(localDataSource.getUser()!!)
        } else {
            // save data api to local
            localDataSource.setUser(apiDataSource.getUser())

            mappingApiToDomain(apiDataSource.getUser())
        }
    }

    // mapper data api model to domain model
    private fun mappingApiToDomain(result: UserApiEntity): User? {
        return User(
            id = 0,
            name = result.name,
            age = result.age,
            isFromApi = true
        )
    }

    // mapper data local model to domain model
    private fun mappingLocalToDomain(result: UserLocalEntity): User? {
        return User(
            id = result.id,
            name = result.name,
            age = result.age,
            isFromApi = false
        )
    }
}