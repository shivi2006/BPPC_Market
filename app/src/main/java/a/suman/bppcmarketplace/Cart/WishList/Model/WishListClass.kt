package a.suman.bppcmarketplace.Cart.WishList.Model



data class WishListClass(
    var name: String?,
    var expectedPrice: Int,
    var description: String,
    var images: List<String?>?,
    var seller: String?

)
