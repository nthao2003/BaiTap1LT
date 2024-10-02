package com.example.baitap1lt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserInfoAdapter(private val userList: List<UserInfo>) : RecyclerView.Adapter<UserInfoAdapter.UserInfoViewHolder>() {

    class UserInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fullNameTextView: TextView = itemView.findViewById(R.id.tvFullName)
        val emailTextView: TextView = itemView.findViewById(R.id.tvEmail)
        val phoneNumberTextView: TextView = itemView.findViewById(R.id.tvPhoneNumber)
        val genderTextView: TextView = itemView.findViewById(R.id.tvGender)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserInfoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_user_info, parent, false)
        return UserInfoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserInfoViewHolder, position: Int) {
        val currentUser = userList[position]
        holder.fullNameTextView.text = currentUser.fullName
        holder.emailTextView.text = currentUser.email
        holder.phoneNumberTextView.text = currentUser.phoneNumber
        holder.genderTextView.text = currentUser.gender
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}
