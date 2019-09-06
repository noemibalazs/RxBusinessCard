package com.example.rxbusinesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rxbusinesscard.R
import com.example.rxbusinesscard.adapter.UserAdapter
import com.example.rxbusinesscard.data.User
import com.example.rxbusinesscard.network.RetrofitService
import com.jakewharton.threetenabp.AndroidThreeTen
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import org.threeten.bp.Instant
import org.threeten.bp.ZoneId
import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {

    private var disposable: CompositeDisposable ?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AndroidThreeTen.init(this)

        disposable = CompositeDisposable()
        setRv()
        loadData()

        getObservedDay()
    }


    private fun setRv(){
        myRecycler.setHasFixedSize(true)
    }

    private fun loadData(){
        disposable?.add(

            RetrofitService.getRetrofitService().getUsers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::populateAdapter)
        )
    }

    private fun populateAdapter(users: List<User>){
        myRecycler.adapter = UserAdapter(users)
    }

    private fun getObservedDay(){
        val zoneDate = ZonedDateTime.ofInstant(Instant.now(), ZoneId.systemDefault())
        val date = DateTimeFormatter.RFC_1123_DATE_TIME.format(zoneDate)
        myCard.text = date.take(date.length - 5)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.clear()
    }
}
