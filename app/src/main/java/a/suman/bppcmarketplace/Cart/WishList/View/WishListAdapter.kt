package a.suman.bppcmarketplace.Cart.WishList.View

import a.suman.bppcmarketplace.Cart.WishList.Model.WishListClass
import a.suman.bppcmarketplace.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bppcmarketplace.GetWishListQuery
import kotlinx.android.synthetic.main.recycler_view_wishlist.view.*

class WishListAdapter:RecyclerView.Adapter<WishListAdapter.ViewHolder>() {

    var list: List<GetWishListQuery.Wishlist?> = emptyList()
    override fun onCreateViewHolder(p: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(p.context).inflate(R.layout.recycler_view_wishlist,p,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(list[position])
    }


    fun setData(list:List<GetWishListQuery.Wishlist?>){
        this.list = list
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        fun bindItems(wishlist: GetWishListQuery.Wishlist?) {
            if(wishlist!=null) {
                itemView.product_name.text = wishlist.name
            }
        }

    }
}
