package com.vuztask.utils

import android.app.ProgressDialog
import android.content.Context

object DialogUtils {

    private var progressDialog: ProgressDialog? = null

    val isProgressShowing: Boolean
        @Synchronized get() = if (progressDialog == null) false else progressDialog!!.isShowing

    @Synchronized
    fun showLoadingDialog(context: Context) {
        if (progressDialog == null || !progressDialog!!.isShowing) {
            progressDialog = ProgressDialog(context)
            progressDialog!!.setMessage("Loading ...")
            progressDialog!!.setCancelable(false)
            progressDialog!!.show()
        }
    }

    @Synchronized
    fun dismissProgressDialog() {
        if (isProgressShowing)
            progressDialog!!.dismiss()
    }
}