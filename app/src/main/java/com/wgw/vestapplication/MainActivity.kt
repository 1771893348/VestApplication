package com.wgw.vestapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.wgw.vestapplication.bean.AppConfigBean
import com.wgw.vestapplication.net.ApiCallBack
import com.wgw.vestapplication.net.ApiserviceModel
import com.wgw.vestapplication.net.retrofit.RetrofitUtils
import com.wgw.vestapplication.net.retrofit.api.ApiService
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

   fun getAppConfig(view:View){
       when(view.id){
           R.id.btn_getappconfig->{
//               RetrofitUtils.getInstance().createService(ApiService::class.java).getAppConfig("ceshiqianggeng777")
//                   .subscribeOn(Schedulers.io())
//                   .observeOn(AndroidSchedulers.mainThread())
//                   .subscribe {
//                    Log.d("wgw_=====","===="+it.success)
//                   }
               ApiserviceModel().getAppConfig("ceshiqianggeng777", object:ApiCallBack{
                   override fun onHttpSuccess(data: Any?) {
                       var app:AppConfigBean = data as AppConfigBean
                       Log.d("wgw_onHttpSuccess","===="+app.getSuccess())
                   }

                   override fun onHttpFail(failMsg: Any?) {
                   }

               })
               Toast.makeText(this,"获取APP信息配置",Toast.LENGTH_LONG).show()
           }
           R.id.btn_toast->{Toast.makeText(this,"Hello boys",Toast.LENGTH_LONG).show()}
       }

   }
}
