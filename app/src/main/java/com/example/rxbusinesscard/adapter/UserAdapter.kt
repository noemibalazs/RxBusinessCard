package com.example.rxbusinesscard.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rxbusinesscard.R
import com.example.rxbusinesscard.data.User
import com.example.rxbusinesscard.utils.ColorRepository

class UserAdapter(val myUsers: List<User>) : RecyclerView.Adapter<UserAdapter.UserVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserVH(view)
    }

    override fun getItemCount(): Int {
        return myUsers.size
    }

    override fun onBindViewHolder(holder: UserVH, position: Int) {
        holder.itemView.setBackgroundColor(Color.parseColor(ColorRepository().colors[position]))
        holder.bind(myUsers[position])
    }

    inner class UserVH(view: View): RecyclerView.ViewHolder(view){
        val companyName = view.findViewById<TextView>(R.id.company_name)
        val companyMotto = view.findViewById<TextView>(R.id.company_bs)
        val userName = view.findViewById<TextView>(R.id.user_name)
        val userMotto = view.findViewById<TextView>(R.id.user_motto)
        val userEmail = view.findViewById<TextView>(R.id.user_email)
        val userSite = view.findViewById<TextView>(R.id.user_site)

        fun bind(user: User){
            companyName.text = user.company.name
            companyMotto.text = user.company.bs
            userName.text = user.name
            userEmail.text = user.email
            userSite.text = user.webSite
            userMotto.text = user.company.catchPhrase
        }
    }
}