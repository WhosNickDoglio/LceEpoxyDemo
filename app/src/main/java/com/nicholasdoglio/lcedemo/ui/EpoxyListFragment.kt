package com.nicholasdoglio.lcedemo.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nicholasdoglio.lcedemo.R
import com.nicholasdoglio.lcedemo.data.DataStore
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_epoxy_list.*


class EpoxyListFragment : Fragment() {

    private lateinit var listController: ListController

    private lateinit var disposable: Disposable

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_epoxy_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listController = ListController { getData() }

        swipeRefreshLayout.setOnRefreshListener {
            DataStore.populateListIfEmpty()
            getData()
        }

        recyclerView.setController(listController)

        getData()
    }

    private fun getData() {
        swipeRefreshLayout.isRefreshing = false
        disposable = DataStore.getData()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { listController.setData(it) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        disposable.dispose()
    }
}
