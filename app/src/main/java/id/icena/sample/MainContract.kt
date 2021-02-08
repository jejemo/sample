package id.icena.sample

import id.icena.sample.domain.model.User

interface MainContract {
    interface View {
        fun onError(msg: String)
        fun onSuccessGetUser(user: User)
        fun onSuccessGetUsers(users: List<User>)
    }

    interface Presenter {
        fun onGetUser()
        fun onDestroy()
        fun saveUser(user: User)
    }
}