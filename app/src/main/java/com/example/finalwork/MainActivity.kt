package com.example.finalwork

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalwork.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.main_content.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var adapter: MyAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.navView.setNavigationItemSelectedListener(this)
        var list = ArrayList<ListItem>()

        list.addAll(fillArras(resources.getStringArray(R.array.sodegda),
            resources.getStringArray(R.array.sodegda_content),getImageId(R.array.sodegda_image_array)))

        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(list,this)
        rcView.adapter = adapter


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {

            R.id.id_sodegda -> {
                Toast.makeText(this, "Спецодежда", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArras(resources.getStringArray(R.array.sodegda),
                    resources.getStringArray(R.array.sodegda_content),getImageId(R.array.sodegda_image_array)))
            }
            R.id.id_sobuv -> {
                Toast.makeText(this, "Спецобувь", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArras(resources.getStringArray(R.array.sobuv),
                    resources.getStringArray(R.array.sobuv_content),getImageId(R.array.sobuv_image_array)))
            }
            R.id.id_siz -> {
                Toast.makeText(this, "Средства защиты", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArras(resources.getStringArray(R.array.siz),
                    resources.getStringArray(R.array.siz_content),getImageId(R.array.siz_image_array)))
            }
            R.id.id_medforma -> {
                Toast.makeText(this, "Медформа", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArras(resources.getStringArray(R.array.medforma),
                    resources.getStringArray(R.array.medforma_content),getImageId(R.array.medforma_image_array)))
            }


        }

        return true
    }

    fun fillArras(titleArray:Array<String>,contentArray:Array<String>,imageArray:IntArray):List<ListItem>
    {
        var listItemArray = ArrayList<ListItem>()
        for(n in 0..titleArray.size - 1)
        {
            var listItem = ListItem(imageArray[n],titleArray[n],contentArray[n])
            listItemArray.add(listItem)
        }
        return listItemArray
    }

    fun getImageId(imageArrayId:Int):IntArray
    {
        var tArray:TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)
        for(i in ids.indices)
        {
            ids[i] = tArray.getResourceId(i,0)
        }
        tArray.recycle()
        return ids
    }


}