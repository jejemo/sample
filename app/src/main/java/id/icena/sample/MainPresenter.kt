package id.icena.sample

import id.icena.sample.data.repository.UserRepository

class MainPresenter(private var view: MainContract.View?, private val repository: UserRepository) :
    MainContract.Presenter {
    override fun onGetUser() {
        // it's like if not null, then
        repository.getUser()?.let {
            view?.onSuccessGetUser(it)
        }
    }

    override fun onDestroy() {
        view = null
    }
}