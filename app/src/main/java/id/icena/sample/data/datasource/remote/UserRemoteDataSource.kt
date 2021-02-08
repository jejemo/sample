package id.icena.sample.data.datasource.remote

import id.icena.sample.data.datasource.UserDataSource
import id.icena.sample.data.datasource.remote.model.UserApiEntity

class UserRemoteDataSource : UserDataSource.Remote {
    override fun getUser(): UserApiEntity = UserApiEntity(
        name = "Jupri Istomo",
        age = 22
    )
}