package com.example.medplus

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coordinate_layout.R
import com.example.coordinate_layout.databinding.ActivityMainBinding
import com.example.coordinate_layout.databinding.BottomsheetDialogBinding
import com.example.medplus.adapters.MainViewPagerAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    lateinit var binding: ActivityMainBinding
    lateinit var categoryAdapter:CategoryAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    private val tabTxt = arrayOf(
        "call",
        "c_chat",
        "c_status"
    )
    var list = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        linearLayoutManager=LinearLayoutManager(this)
        categoryAdapter=CategoryAdapter(this,list)
//        navController = findNavController(R.id.host)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.categoryRv.layoutManager= GridLayoutManager(this,2)
        binding.categoryRv.adapter=categoryAdapter
        list.add("s")
        list.add("l")
        list.add("l")
        list.add("l")
        list.add("l")

        binding.mainViewPager.adapter=MainViewPagerAdapter(this)
//        TabLayoutMediator(binding.mainTabLayout,binding.mainViewPager){ tab,position ->
//            tab.setText(tabTxt[position])
//        }.attach()

        binding.searchBar.setOnClickListener {
            navController.navigate(R.id.searchFragment)
                    }
        binding.tvLocation.setOnClickListener {
            val dialog = BottomSheetDialog(this)
            val bottomSheetBinding = BottomsheetDialogBinding.inflate(layoutInflater)
            bottomSheetBinding.idBtnDismiss.setOnClickListener {
                Log.e("TAG", "dismiss: working", )
                dialog.dismiss()
            }
            Log.e("TAG", "bottomsheet: working", )
            dialog.apply {
                setCancelable(true)
                setContentView(bottomSheetBinding.root)
                show()
            }
        }
    }
}