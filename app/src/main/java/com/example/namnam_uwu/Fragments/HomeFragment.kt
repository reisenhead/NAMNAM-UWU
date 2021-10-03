package com.example.namnam_uwu.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.namnam_uwu.Adapters.*
import com.example.namnam_uwu.UI.*
import com.example.namnam_uwu.R
import kotlinx.android.synthetic.main.fragment_home.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val recyclerView2 = view.findViewById<RecyclerView>(R.id.recyclerView2)
        val adapter = CustomAdapter()


        //view.recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        view.recyclerView2.layoutManager = GridLayoutManager(activity,2)
        recyclerView2.adapter = adapter

        adapter.setOnItemClickListener(object : CustomAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                positionE = position
                num = 0
                num += position * 5
                tittle = titles[position]
                //Toast.makeText(activity, "You clicked on Item no. $position", Toast.LENGTH_SHORT).show()
                changeFragment(ProductFragment())
            }

        })



        return view
    }

    fun changeFragment(fragment: Fragment){
        var fr = getFragmentManager()?.beginTransaction()
        fr?.replace(R.id.fragment_container, fragment)
        fr?.commit()
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
}