package id.icena.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import id.icena.sample.data.datasource.local.UserLocalDataSource
import id.icena.sample.data.datasource.remote.UserRemoteDataSource
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
    private val userRepository: UserRepository by lazy {
        UserRepository(remoteDataSource, localDataSource)
    }
    private val presenter: MainPresenter by lazy {
        MainPresenter(this, userRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_click).apply {
            setOnClickListener {
                presenter.onGetUser()
            }
        }
    }

    // show data
    override fun onSuccessGetUser(user: User) {
        Toast.makeText(this, user.toString(), Toast.LENGTH_SHORT).show()
    }
}