package a.suman.bppcmarketplace

import a.suman.bppcmarketplace.Cart.CartActivity
import a.suman.bppcmarketplace.Cart.WishList.View.WishListFragment
import a.suman.bppcmarketplace.ChatList.View.ChatListFragment
import a.suman.bppcmarketplace.ProductList.View.ProductListFragment
import a.suman.bppcmarketplace.Profile.View.ProfileFragment
import a.suman.bppcmarketplace.Upload.View.UploadFragment
import a.suman.bppcmarketplace.UsersList.View.UsersListFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ismaeldivita.chipnavigation.ChipNavigationBar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottom_nav: ChipNavigationBar = findViewById(R.id.chipNavigationBar)

        openFragment(ProductListFragment())
        bottom_nav.setItemSelected(R.id.products)

        bottom_nav.setOnItemSelectedListener { id :Int->
            when (id) {
                R.id.products -> {
                    val fragment =
                        ProductListFragment()
                    openFragment(fragment)
                }
                R.id.users -> {
                    val fragment =
                        UsersListFragment()
                    openFragment(fragment)
                }
                R.id.upload -> {
                    val fragment =
                        UploadFragment()
                    openFragment(fragment)
                }
                R.id.profile -> {
                    val fragment =
                        ProfileFragment()
                    openFragment(fragment)
                }
                R.id.wishList -> {
                    val fragment =
                        WishListFragment()
                    openFragment(fragment)
                }
            }
        }
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}




