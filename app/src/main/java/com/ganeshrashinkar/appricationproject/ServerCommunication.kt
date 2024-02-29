package com.ganeshrashinkar.appricationproject

import android.content.Context
import android.service.autofill.UserData
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.ganeshrashinkar.appricationproject.database.eitities.UserClass
import com.ganeshrashinkar.appricationproject.view.fragments.UserListFragment
import com.google.gson.Gson
import org.json.JSONObject


class ServerCommunication(val context:Context) {
    val gson:Gson=Gson()
    fun getUsers(fragment: UserListFragment){
        val uri="https://dummyjson.com/users";
        val request=StringRequest(Request.Method.GET,uri,object: Response.Listener<String>{
            override fun onResponse(response: String?) {
                Log.e("response",response?:"");
                val jsonObject=JSONObject(response);
                val jsonArray=jsonObject.getJSONArray("users");
                val size=jsonArray.length();
                val list:MutableList<UserClass> = mutableListOf()
                for(i in 0..size-1){
                    val user=gson.fromJson(jsonArray.getJSONObject(i).toString(),UserClass::class.java)
                    Log.e("tag",user.toString())
                    list.add(user)
                }
                fragment.showUsers(list)
                fragment.insertUsers(list)
            }

        }
        ,object :Response.ErrorListener{
                override fun onErrorResponse(error: VolleyError?) {
                    Toast.makeText(context, "Connection Error...", Toast.LENGTH_SHORT).show()
                }

            }
        )
        Volley.newRequestQueue(context).add(request);
    }
}