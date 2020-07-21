package a.suman.bppcmarketplace.Cart.WishList.Model

import a.suman.bppcmarketplace.ApolloConnector
import a.suman.bppcmarketplace.BPPCDatabase
import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.apollographql.apollo.rx2.Rx2Apollo
import com.example.bppcmarketplace.GetWishListQuery
import com.example.bppcmarketplace.ProfileWithProductsQuery
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class WishListRepo(application: Application) {


    lateinit var token: String
    lateinit var disposable: Disposable
    val appDatabase = BPPCDatabase.getBPPCDatabase(application)



        fun getWishListObservable(): Observable<Response<GetWishListQuery.Data>> {
            return Rx2Apollo.from(
                ApolloConnector.setUpApollo().query(
                    GetWishListQuery()
                )
            )
        }

    }

