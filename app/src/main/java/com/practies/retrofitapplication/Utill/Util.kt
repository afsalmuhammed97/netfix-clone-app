package com.practies.retrofitapplication.Utill

import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar

import com.practies.retrofitapplication.Result
import com.practies.retrofitapplication.api.Resource

fun <A:Activity>Activity.startNewActivity(activity: Class<A>){
    Intent(this,activity).also {
        it.flags=Intent.FLAG_ACTIVITY_NEW_TASK or             Intent.FLAG_ACTIVITY_CLEAR_TASK
          startActivity(intent)

    }

    fun View.visible(isVisible:Boolean){
        visibility=if (isVisible) View.VISIBLE else    View.GONE
    }


    fun View.enable(isEnable:Boolean){
        isEnabled= isEnable
        alpha= if (isEnable) 1f else  0.5f
    }
}

fun View.snackBar(message:String,action: (() ->Unit )?=null){
    val snackbar=Snackbar.make(this, message,Snackbar.LENGTH_LONG)
    action?.let {
        snackbar.setAction("Retry"){
            it()
        }
    }
 snackbar.show()
}

fun Fragment.handleApiError(failure: Resource.Failure, retry:(() ->Unit) ?=null ){
     when{
         failure.isNetworkError == true -> requireView().snackBar("Pleas check your Internet connection !!",retry)

         else ->{
             val error=failure.errorBody?.toString().toString()
             requireView().snackBar(error)
         }

     }


}


fun Fragment.loadImage(img: Result,imageView:ImageView){

    Glide.with(requireContext())
                .load("http://image.tmdb.org/t/p/w500${img.backdrop_path}")    //poster_path
                //.centerCrop()
                .fitCenter()
               .into(imageView)


}