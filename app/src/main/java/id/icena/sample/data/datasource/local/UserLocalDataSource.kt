package id.icena.sample.data.datasource.local

import android.annotation.SuppressLint
import id.icena.sample.data.datasource.UserDataSource
import id.icena.sample.data.datasource.local.model.UserLocalEntity
import id.icena.sample.data.datasource.remote.model.UserApiEntity
import java.text.SimpleDateFormat
import java.util.*

class UserLocalDataSource : UserDataSource.Local {

    private var user: UserLocalEntity? = null

    @SuppressLint("SimpleDateFormat")
    override fun setUser(user: UserApiEntity) {
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())

        this.user = UserLocalEntity(
            id = 1,
            name = user.name,
            age = user.age,
            createAt = currentDate
        )
    }

    override fun getUser(): UserLocalEntity? = user
}