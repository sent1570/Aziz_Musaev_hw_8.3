package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFirstBinding

//Оксфордский университет (Великбритания)
//Гарвардский Университет(США)
//Tsinghua University(China)
//The University of Tokyo(Япония)
//Университет Торонто(Канада)
//Australian National University(Австралия)
//Technische Universität München(Германия)
//Université PSL (Paris Sciences & Lettres)(Франция)
//Delft University of Technology(Нидерланд)
//University of Zurich (Швецария)
//	Lomonosov Moscow State University (Россия)


class FirstFragment : Fragment() {

    private lateinit var binding:FragmentFirstBinding
    private lateinit var list:ArrayList<FirstModel>
    private lateinit var adapter: FirstAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        adapter = FirstAdapter(list,this::onClick)
        binding.recyclerview.adapter = adapter

    }

    private fun onClick(pos:Int){
        val bundle = Bundle()
        bundle.putSerializable("key",list[pos])
        findNavController().navigate(R.id.secondFragment,bundle)
    }

    private fun loadData() {
        list = ArrayList()
        list.add(FirstModel(R.drawable.australia,"Australian National University",1))
        list.add(FirstModel(R.drawable.canada,"Университет Торонто",2))
        list.add(FirstModel(R.drawable.chine,"Tsinghua University",3))
        list.add(FirstModel(R.drawable.france,"Université PSL (Paris Sciences & Lettres)",4))
        list.add(FirstModel(R.drawable.german,"Technische Universität München",5))
        list.add(FirstModel(R.drawable.janap,"The University of Tokyo",6))
        list.add(FirstModel(R.drawable.niderland,"Delft University of Technology",7))
        list.add(FirstModel(R.drawable.russia,"Lomonosov Moscow State University",8))
        list.add(FirstModel(R.drawable.shvezaria,"University of Zurich",9))
        list.add(FirstModel(R.drawable.united_kindom,"Оксфордский университет",10))
        list.add(FirstModel(R.drawable.usa,"Гарвардский Университет",11))
    }
}