package com.np.espressotestapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ImageFragment : Fragment() {

    private var listener: IImageCallBack? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is IImageCallBack) {
            listener = context
        } else {
            throw RuntimeException("$context must implement ILoginFragmentCallBack")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface IImageCallBack
}
