# Auth
Authentication module

# Uses
Add in Application class

## Step 1
Add config on applcations ```onCreate()```
``` 
var endPoint = EndPoint.Builder()
                .baseUrl("your_base_url")
                .login("auth/authenticate")
                .forgotPassword("password/reset")
                .resetPassword("password/reset")
                .build()
AuthConfig.setEndpoint(endPoint)
```
## Step 2
Register event to get response
```
EventBus.register(this)
```
Get Response as:
```
 @Subscribe
    fun onSuccess(event: AuthEvent) {
        when (event) {
            is LoginSuccess -> {
               // your result
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
var gson = Gson()
var baseResponse: BaseResponse<User> = Gson().fromJson(event.result.string(), gson.getType(BaseResponse::class.java, User::class.java))
Log.d("login success", "called " + baseResponse.body?.firstName)
this.startActivity(Intent(this, DashboardActivity::class.java))
```
