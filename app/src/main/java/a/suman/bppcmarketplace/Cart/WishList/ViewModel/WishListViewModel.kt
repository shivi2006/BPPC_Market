package a.suman.bppcmarketplace.Cart.WishList.ViewModel

import a.suman.bppcmarketplace.Cart.WishList.Model.WishListClass
import a.suman.bppcmarketplace.Cart.WishList.Model.WishListRepo
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.bppcmarketplace.GetWishListQuery
import io.reactivex.disposables.CompositeDisposable

class WishListViewModel(application: Application):AndroidViewModel(application) {

    val wishListRepo = WishListRepo(application)
    private val compositeDisposable = CompositeDisposable()
    private val wishListMutableLiveData = MutableLiveData<List<GetWishListQuery.Wishlist?>>()
    val wishListLiveData = liveData { emitSource(wishListMutableLiveData) }

    fun getWishList(){
        compositeDisposable.add(wishListRepo.getWishListObservable().subscribe (
            {
                wishListMutableLiveData.postValue(it.data()!!.wishlist)
            print(it) },
            {print("Error")},
            {print("Completed")}
        )
        )
    }
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}