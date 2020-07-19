package a.suman.bppcmarketplace.Cart.WishList.View
import a.suman.bppcmarketplace.Cart.WishList.ViewModel.WishListViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import a.suman.bppcmarketplace.R
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bppcmarketplace.GetWishListQuery
import kotlinx.android.synthetic.main.fragment_wish_list.*


class WishListFragment : Fragment() {

    private lateinit var wishListViewModel:WishListViewModel

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?

    ): View? {

       val view = inflater.inflate(R.layout.fragment_wish_list, container, false)
       Log.d("Called Wishlist","Called WishList")

        wishListViewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(activity!!.application)
        ).get(WishListViewModel::class.java)

        wishListViewModel.getWishList()
        Log.d("Called","wishlist called")
        return view
    }


       override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


            val wishListAdapter = WishListAdapter()
            wishList_recycler_view.layoutManager = LinearLayoutManager(context)
            wishList_recycler_view.adapter = wishListAdapter

            Log.d("Called Wishlist", "adapter")

            wishListViewModel.wishListLiveData.observe(viewLifecycleOwner, Observer {
            wishListAdapter.setData(it as List<GetWishListQuery.Wishlist>)
                Log.d("Called Wishlist", "Set data")
       }
       )
   }
}




