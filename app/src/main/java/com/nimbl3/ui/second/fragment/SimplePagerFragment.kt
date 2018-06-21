package com.nimbl3.ui.second.fragment

import android.view.ViewGroup
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import com.nimbl3.R
import com.nimbl3.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_screen_slide_page.*

class SimplePagerFragment : Fragment() {

    lateinit var data: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            data = it.getString(ARG_DATA)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_screen_slide_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pagerTextView.text = data
    }

    companion object {
        @JvmStatic
        fun newInstance(data: String): SimplePagerFragment {
            return SimplePagerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_DATA, data)
                }
            }
        }
    }
}
private const val ARG_DATA = "ARG_DATA"