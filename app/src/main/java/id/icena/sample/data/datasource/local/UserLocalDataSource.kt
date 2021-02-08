package id.icena.sample.data.datasource.local

import id.icena.sample.data.datasource.UserDataSource
import id.icena.sample.data.datasource.local.model.UserLocalEntity

class UserLocalDataSource : UserDataSource.Local {

    private var user: UserLocalEntity? = null
    private val listUser: MutableList<UserLocalEntity> = mutableListOf()

    override fun saveUserAsObject(user: UserLocalEntity) {
        this.user = user
    }

    override fun saveUserAsList(userLocalEntity: UserLocalEntity) {
        listUser.add(userLocalEntity)
    }

    override fun getUser(): UserLocalEntity? = user

    override fun getUsers(): List<UserLocalEntity>? = listUser
}