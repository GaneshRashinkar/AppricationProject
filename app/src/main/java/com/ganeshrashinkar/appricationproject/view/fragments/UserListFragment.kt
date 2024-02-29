package com.ganeshrashinkar.appricationproject.view.fragments

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.ganeshrashinkar.appricationproject.ApplicationClass
import com.ganeshrashinkar.appricationproject.R
import com.ganeshrashinkar.appricationproject.ServerCommunication
import com.ganeshrashinkar.appricationproject.database.eitities.UserClass
import com.ganeshrashinkar.appricationproject.databinding.FragmentUserListBinding
import com.ganeshrashinkar.appricationproject.viemodels.UsersViewmodel
import com.ganeshrashinkar.appricationproject.viemodels.UsersViewmodelFactory
import com.ganeshrashinkar.appricationproject.view.adapters.AdapterUsers


class UserListFragment : Fragment() {
    lateinit var mBinding:FragmentUserListBinding
    val userViewModel:UsersViewmodel by viewModels {
        UsersViewmodelFactory((requireActivity().application as ApplicationClass).userRepository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding= FragmentUserListBinding.inflate(layoutInflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userViewModel.allUsers.observe(viewLifecycleOwner){
            if(it.isNotEmpty()){
                showUsers(it)
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.action_refresh){
           val serverCommunication=ServerCommunication(requireContext())
            serverCommunication.getUsers(this)
        }
        return super.onOptionsItemSelected(item)
    }

    fun showUsers(list:MutableList<UserClass>){

        mBinding.rvUsers.layoutManager=GridLayoutManager(requireContext(),2)
        val adapter=AdapterUsers(requireContext(),list)
        mBinding.rvUsers.adapter=adapter

        }

    fun insertUsers(list:MutableList<UserClass>){
        for(user in list){
            userViewModel.insert(user)
        }
    }
}