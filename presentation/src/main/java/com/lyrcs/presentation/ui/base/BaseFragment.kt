package com.lyrcs.presentation.ui.base

import android.app.ProgressDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.lyrcs.domain.common.ResultState
import com.lyrcs.presentation.R
import dagger.android.support.DaggerFragment

abstract class BaseFragment : DaggerFragment() {

    private var mProgressDialog: ProgressDialog? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    protected open fun initView() {

    }

    protected fun getBaseActivity(): AppCompatActivity = activity as AppCompatActivity

    protected fun setEnabledBackButton(enabled: Boolean) {
        getBaseActivity().supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(enabled)
            setDisplayShowHomeEnabled(enabled)
        }
    }

    protected fun showLoading() {
        hideLoading()
        if (mProgressDialog == null) {
            mProgressDialog = ProgressDialog(activity)
            mProgressDialog?.show()
        } else {
            mProgressDialog?.show()
        }
        if (mProgressDialog?.window != null) {
            mProgressDialog?.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        mProgressDialog?.setContentView(R.layout.progress_dialog)
        mProgressDialog?.isIndeterminate = true
        mProgressDialog?.setCancelable(true)
        mProgressDialog?.setCanceledOnTouchOutside(false)
    }

    protected fun hideLoading() = mProgressDialog?.cancel()

    protected fun showErrorDialog() {
        context?.apply {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Error")
            builder.setMessage("Something went wrong, please try again.")
            builder.setPositiveButton("OK") { _, _ -> }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }

    protected fun <T>handleResult(resultState: ResultState<T>,
                                       success: () -> Unit,
                                       error: () -> Unit) {
        when(resultState) {
            is ResultState.Loading -> showLoading()
            is ResultState.Success -> success()
            is ResultState.Error -> error()
        }
    }

}