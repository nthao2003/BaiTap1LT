package com.example.baitap1lt

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userInfoAdapter: UserInfoAdapter
    private val userList = mutableListOf<UserInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Khởi tạo RecyclerView và Adapter
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        userInfoAdapter = UserInfoAdapter(userList)
        recyclerView.adapter = userInfoAdapter

        // Tham chiếu đến các thành phần UI
        val btnSave: Button = findViewById(R.id.btnSave)
        val fullNameEditText: EditText = findViewById(R.id.etFullName)
        val emailEditText: EditText = findViewById(R.id.etEmail)
        val phoneEditText: EditText = findViewById(R.id.etPhoneNumber)
        val radioGroup: RadioGroup = findViewById(R.id.rgGender)
        val termsCheckBox: CheckBox = findViewById(R.id.cbTerms)

        // Xử lý khi nhấn nút lưu
        btnSave.setOnClickListener {
            if (termsCheckBox.isChecked) {
                val fullName = fullNameEditText.text.toString()
                val email = emailEditText.text.toString()
                val phoneNumber = phoneEditText.text.toString()

                // Lấy giới tính đã chọn
                val selectedGenderId = radioGroup.checkedRadioButtonId
                val gender = when (selectedGenderId) {
                    R.id.rbMale -> "Nam"
                    R.id.rbFemale -> "Nữ"
                    R.id.rbOther -> "Khác"
                    else -> ""
                }

                // Tạo đối tượng UserInfo và thêm vào danh sách
                val newUser = UserInfo(fullName, email, phoneNumber, gender)
                userList.add(newUser)

                // Cập nhật RecyclerView
                userInfoAdapter.notifyDataSetChanged()

                // Xóa các trường nhập liệu
                fullNameEditText.text.clear()
                emailEditText.text.clear()
                phoneEditText.text.clear()
                radioGroup.clearCheck()
                termsCheckBox.isChecked = false
            }
        }
    }
}
