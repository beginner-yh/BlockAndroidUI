package com.block.androidui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.block.androidui.widget.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

const val TYPE_VIEW = 0
const val TYPE_VIEW_GROUP = 1

class WidgetListFragment : Fragment() {

    private var param2: String? = null
    private lateinit var rvWidget: RecyclerView
    private var mType = TYPE_VIEW

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mType = it.getInt(ARG_PARAM1)
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
        if (mType == TYPE_VIEW) {
            data.add(ViewIntro("TextView", "文本"))
            data.add(ViewIntro("Button", "按钮", R.drawable.ic_btn_icon))
            data.add(ViewIntro("EditText", "输入框"))
            data.add(ViewIntro("ImageView", "图片"))
            data.add(ViewIntro("CheckBox", "复选框"))
            data.add(ViewIntro("Chronometer", "计时器", R.drawable.ic_chronometer_icon))
            data.add(ViewIntro("Progress", "进度条"))
            data.add(ViewIntro("Switch", "开关"))
            data.add(ViewIntro("SeekBar", "可拖动进度条", R.drawable.ic_seekbar_icon))
        } else {
            data.add(ViewIntro("FrameLayout", "帧布局"))
            data.add(ViewIntro("LinearLayout", "线性布局"))
            data.add(ViewIntro("ConstraintLayout", "约束布局"))
            data.add(ViewIntro("ScrollView", "滚动视图"))
            data.add(ViewIntro("RelativeLayout", "相对布局"))
            data.add(ViewIntro("CardView", "卡片布局"))
            data.add(ViewIntro("ViewPager", "翻页布局"))
            data.add(ViewIntro("ViewPager2", "新翻页布局"))
            data.add(ViewIntro("ListView", "列表视图"))
            data.add(ViewIntro("RecyclerView", "回收列表"))
            data.add(ViewIntro("FlowLayout", "流布局"))
        }
        val adapter = WidgetListAdapter(data)
        adapter.setOnItemClick(object : OnItemClick {
            override fun onItemClick(position: Int) {
                if(mType == TYPE_VIEW) {
                    when (position) {
                        0 -> requireActivity().startActivity(Intent(requireActivity(), TextViewActivity::class.java))
                        1 -> requireActivity().startActivity(Intent(requireActivity(), ButtonActivity::class.java))
                        5 -> requireActivity().startActivity(Intent(requireActivity(), ChronometerActivity::class.java))
                        8 -> requireActivity().startActivity(Intent(requireActivity(), SeekBarActivity::class.java))
                    }
                }else{
                    when (position) {
                        10 -> requireActivity().startActivity(Intent(requireActivity(), FlowLayoutActivity::class.java))
                    }
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
        @JvmStatic
        fun newInstance(param1: Int, param2: String) = WidgetListFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
    }
}