package com.block.androidui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.block.androidui.widget.ButtonActivity
import com.block.androidui.widget.ChronometerActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WidgetListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WidgetListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var rvWidget: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_widget_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvWidget = view.findViewById(R.id.rv_widget)
        rvWidget.layoutManager = GridLayoutManager(requireContext(), 3)
        val data = mutableListOf<ViewIntro>()
        data.add(ViewIntro("TextView", "文本"))
        data.add(ViewIntro("Button", "按钮", R.drawable.ic_btn_icon))
        data.add(ViewIntro("EditText", "输入框"))
        data.add(ViewIntro("ImageView", "图片"))
        data.add(ViewIntro("Chronometer", "计时器", R.drawable.ic_chronometer_icon))
        val adapter = WidgetListAdapter(data)
        adapter.setOnItemClick(object : OnItemClick {
            override fun onItemClick(position: Int) {
                when (position) {
                    1 -> requireActivity().startActivity(Intent(requireActivity(), ButtonActivity::class.java))
                    4 -> requireActivity().startActivity(Intent(requireActivity(), ChronometerActivity::class.java))
                }
            }
        })
        rvWidget.adapter = adapter

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment WidgetListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) = WidgetListFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
    }
}