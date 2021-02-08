package id.icena.sample

import id.icena.sample.domain.model.User

interface MainContract {
    interface View {
        fun onSuccessGetUser(user: User)
    }

    interface Presenter {
        fun onGetUser()
        fun onDestroy()
    }
}