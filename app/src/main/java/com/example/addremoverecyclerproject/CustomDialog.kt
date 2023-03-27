package com.example.addremoverecyclerproject

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.WindowManager
import com.example.addremoverecyclerproject.databinding.ActivityMainBinding
import com.example.addremoverecyclerproject.databinding.DialogCustomBinding

class CustomDialog(val context: Context, val minBinding: ActivityMainBinding) {
    val dialog = Dialog(context)
    var count =0

    fun showDialog(){
        val binding =DialogCustomBinding.inflate(LayoutInflater.from(context))
        dialog.setContentView(binding.root)
        dialog.window?.setLayout(WindowManager.LayoutParams.WRAP_CONTENT,WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()

        binding.btnCancel.setOnClickListener {
            dialog.dismiss()
        }
        binding.btnSave.setOnClickListener {
            count++
            val tvName = binding.edtName.text.toString()
            val tvAge= binding.edtAge.text.toString()
            val tvEmail= binding.edtAge.text.toString()
            var dataVO: DataVO? = null

            if(count%2==0){ dataVO = DataVO(tvName, tvAge, tvEmail, R.drawable.face_man_24) }
            else { dataVO = DataVO(tvName, tvAge, tvEmail, R.drawable.face_woman_24) }
            (context as MainActivity).refreshRecyclerView(dataVO)
        }
    }
}