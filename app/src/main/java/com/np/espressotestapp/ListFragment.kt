package com.np.espressotestapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {
    private lateinit var adapter: ListAdapter
    private var listener: IListCallBack? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is IListCallBack) {
            listener = context
        } else {
            throw RuntimeException("$context must implement ILoginFragmentCallBack")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface IListCallBack

    private fun setAdapter() {
        adapter = ListAdapter(context = this!!.context!!, itemList = getItemList())
        rv_item_recycler.adapter = adapter
        rv_item_recycler.layoutManager = LinearLayoutManager(
            context,
            RecyclerView.VERTICAL, false
        )
    }

    private fun getItemList(): List<ListModel> {
        var itemList = arrayListOf<ListModel>()
        itemList.add(ListModel(userName = "Nithinjith", userDescription = "Android Developer"))
        itemList.add(ListModel(userName = "Rijo", userDescription = "iOS Developer"))
        itemList.add(ListModel(userName = "Vijith", userDescription = "Creative Designer"))
        itemList.add(ListModel(userName = "Ben", userDescription = "Product Owner"))
        return itemList
    }

}
