package com.np.espressotestapp

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {
    private var listener: ILoginFragmentCallBack? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ILoginFragmentCallBack) {
            listener = context
        } else {
            throw RuntimeException("$context must implement ILoginFragmentCallBack")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_login.setOnClickListener {
            listener?.loginClickCallBack()
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface ILoginFragmentCallBack {
        fun loginClickCallBack()
    }

}
