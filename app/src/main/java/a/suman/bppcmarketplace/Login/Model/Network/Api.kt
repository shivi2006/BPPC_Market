package a.suman.bppcmarketplace.Login.Model.Network

import a.suman.bppcmarketplace.BasicUserData
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {
    @FormUrlEncoded
    @POST("auth/authenticate/")
    fun authWithBackend(@Field("id_token") token: String): Single<BasicUserData>
}