package id.icena.sample.data.datasource

import id.icena.sample.data.datasource.local.model.UserLocalEntity
import id.icena.sample.data.datasource.remote.model.UserApiEntity

interface UserDataSource {
    interface Remote {
        fun getUser(): UserApiEntity
    }

    interface Local {
        fun setUser(user: UserApiEntity)
        fun getUser(): UserLocalEntity?
    }
}