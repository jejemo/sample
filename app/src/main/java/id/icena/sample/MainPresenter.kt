package id.icena.sample

import id.icena.sample.data.repository.UserRepository
import id.icena.sample.domain.model.User

class MainPresenter(private var view: MainContract.View?, private val repository: UserRepository) :
    MainContract.Presenter {

    override fun onGetUser() {
        // it's like if not null, then . . .
        repository.getUser()?.let {
            view?.onSuccessGetUser(it)
        } ?: view?.onError("No have data")
    }

    override fun onDestroy() {
        view = null
    }

    override fun saveUser(user: User) {
        repository.saveUser(user)

        // show data
        repository.getUsers()?.let {
            view?.onSuccessGetUsers(it)
        } ?: view?.onError("No have data")
    }
}