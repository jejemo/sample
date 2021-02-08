package id.icena.sample.data.repository

import id.icena.sample.data.datasource.UserDataSource
import id.icena.sample.data.mapper.UserMapper
import id.icena.sample.domain.model.User

@Suppress("IMPLICIT_CAST_TO_ANY")
class UserRepository(
    private val apiDataSource: UserDataSource.Remote,
    private val localDataSource: UserDataSource.Local,
    private val mapper: UserMapper
) {
    fun getUser(): User? {
        return if (localDataSource.getUser() != null) {
            mapper.mappingLocalToDomain(localDataSource.getUser()!!)
        } else {
            // save data api to local
            val user = mapper.mappingApiToLocal(apiDataSource.getUser())
            localDataSource.saveUserAsObject(user)

            mapper.mappingApiToDomain(apiDataSource.getUser())
        }
    }

    fun getUsers(): List<User>? {
        return localDataSource.getUsers()?.map {
            mapper.mappingLocalToDomain(it)!!
        }
    }

    fun saveUser(user: User) {
        val size = localDataSource.getUsers()?.size ?: 0
        val index = if (size != 0) localDataSource.getUsers()?.get(size - 1)?.id else 0

        val userMapper = mapper.mappingDomainToLocal(user, index.toString().toInt() + 1)

        // save data domain to local
        localDataSource.saveUserAsList(userMapper)
    }
}