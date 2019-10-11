package com.firstapp.robinpc.tongue_twisters_deluxe.ui.tathastu.popup

import android.content.DialogInterface
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.firstapp.robinpc.tongue_twisters_deluxe.R
import kotlinx.android.synthetic.main.layout_subscribe_tathastu_dialog.*

class SubscribeTathastuDialogFragment: DialogFragment() {

    private lateinit var subscribeClickListener: SubscribeClickListener

    companion object {
        const val DIALOG_DIM_AMOUNT = 0.90f
        fun newInstance() = SubscribeTathastuDialogFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.layout_subscribe_tathastu_dialog, container)
        setDialogWindow()
        setDialogProperties()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup() {
        setViews()
        setClickListeners()
    }

    private fun setViews() {
        parentLayout.clipToOutline = true
    }

    private fun setClickListeners() {
        subscribeTv.setOnClickListener {
            if(::subscribeClickListener.isInitialized)
                subscribeClickListener.onSubscribeClicked()

            dismiss()
        }
    }

    private fun setDialogWindow() {
        dialog?.window?.let {
            it.setDimAmount(DIALOG_DIM_AMOUNT)
            it.setGravity(Gravity.CENTER)
            it.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            it.setBackgroundDrawableResource(android.R.color.transparent)
        }
    }

    private fun setDialogProperties() {
        dialog?.let {
            it.setCancelable(false)
            it.setCanceledOnTouchOutside(false)
        }
    }

    override fun onDismiss(dialog: DialogInterface) {
        if(::subscribeClickListener.isInitialized)
            subscribeClickListener.onSubscribeDismissed()

        super.onDismiss(dialog)
    }

    fun setSubscribeClickListener(subscribeClickListener: SubscribeClickListener) {
        this.subscribeClickListener = subscribeClickListener
    }

    interface SubscribeClickListener {
        fun onSubscribeClicked()
        fun onSubscribeDismissed()
    }
}