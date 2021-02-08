package id.icena.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import id.icena.sample.data.datasource.local.UserLocalDataSource
import id.icena.sample.data.datasource.remote.UserRemoteDataSource
import id.icena.sample.data.mapper.UserMapper
import id.icena.sample.data.repository.UserRepository
import id.icena.sample.domain.model.User

class MainActivity : AppCompatActivity(), MainContract.View {

    // lol manually injection
    private val remoteDataSource: UserRemoteDataSource by lazy {
        UserRemoteDataSource()
    }
    private val localDataSource: UserLocalDataSource by lazy {
        UserLocalDataSource()
    }
    private val userMapper: UserMapper by lazy {
        UserMapper()
    }
    private val userRepository: UserRepository by lazy {
        UserRepository(remoteDataSource, localDataSource, userMapper)
    }
    private val presenter: MainPresenter by lazy {
        MainPresenter(this, userRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_click).apply {
            setOnClickListener {
                val user = User(
                    id = 0,
                    name = "Jupri Istomo",
                    age = 22,
                    isFromApi = null
                )
                presenter.saveUser(user)
                presenter.onGetUser()
            }
        }
    }

    override fun onError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    // show data
    override fun onSuccessGetUser(user: User) {
        Toast.makeText(this, user.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun onSuccessGetUsers(users: List<User>) {
        Log.d("TAG", "onSuccessGetUsers: $users")
    }
}