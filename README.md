# Auth
Authentication module

# Uses
Add in Application class

``` 
//register to get the success response
EventBus.register(this)

var endPoint = EndPoint.Builder()
                .baseUrl("your_base_url")
                .login("auth/authenticate")
                .forgotPassword("password/reset")
                .resetPassword("password/reset")
                .build()
AuthConfig.setEndpoint(endPoint)
```

```
 @Subscribe
    fun onSuccess(event: AuthEvent) {
        when (event) {
            is LoginSuccess -> {
                var baseResponse: BaseResponse<User> = Gson().fromJson(event.result.string(),
                        getType(BaseResponse::class.java, User::class.java))
                this.startActivity(Intent(this, DashboardActivity::class.java))
            }
        }
    }
```

# Deserialize Response Body BaseResponse<T> 
```
class BaseResponse<R> {
    @SerializedName("body")
    val body: R? = null
}
```

```
var baseResponse: BaseResponse<User> = Gson().fromJson(event.result.string(), getType(BaseResponse::class.java, User::class.java))
Log.d("login success", "called " + baseResponse.body?.firstName)
this.startActivity(Intent(this, DashboardActivity::class.java))
```


```
private fun getType(rawClass: Class<*>, parameterClass: Class<*>): Type {
        return object : ParameterizedType {
            override fun getRawType(): Type {
                return rawClass
            }

            override fun getOwnerType(): Type? {
                return null
            }

            override fun getActualTypeArguments(): Array<Type> {
                return arrayOf(parameterClass)
            }
        }
    }
```
