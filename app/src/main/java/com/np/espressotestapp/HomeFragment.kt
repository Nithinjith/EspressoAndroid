package com.np.espressotestapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private var listener: IHomeCallBack? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_list.setOnClickListener { listener?.listClickCallBack() }
        btn_detail.setOnClickListener { listener?.detailClickCallBack() }
        btn_exit.setOnClickListener { listener?.exitFromAppCallBack() }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is IHomeCallBack) {
            listener = context
        } else {
            throw RuntimeException("$context must implement ILoginFragmentCallBack")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface IHomeCallBack {
        fun listClickCallBack()
        fun detailClickCallBack()
        fun exitFromAppCallBack()
    }
}
