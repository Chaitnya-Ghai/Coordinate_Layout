package com.example.medplus.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coordinate_layout.databinding.FragmentHomeBinding
import com.example.medplus.MainActivity
import com.example.medplus.adapters.BestsellerAdapter
import com.example.medplus.interfaces.BestSellerInterface

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(), BestSellerInterface {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var binding: FragmentHomeBinding?=null
    lateinit var mainActivity: MainActivity
    var list = arrayListOf<String>()
    lateinit var bestsellerAdapter: BestsellerAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
//    initialized all the variables till this comment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    mainActivity = activity as MainActivity
    arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding?.root
//        return inflater.inflate(binding?.root, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list.add("23")
        list.add("23")
        list.add("23")
        list.add("23")
        list.add("23")
        list.add("23")
        list.add("23")
        list.add("23")
        list.add("23")
        list.add("23")
        linearLayoutManager=LinearLayoutManager(mainActivity)
        bestsellerAdapter=BestsellerAdapter(mainActivity,list,this)
        binding?.bestSellerRecycler?.layoutManager=GridLayoutManager(mainActivity,4)
        binding?.bestSellerRecycler?.adapter=bestsellerAdapter
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    override fun update(position: Int) {

    }
    override fun delete(position: Int) {

    }
}