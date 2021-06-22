package com.example.androidcalculator

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.androidcalculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.btn0.setOnClickListener{setTextFields("0")}
        bindingClass.btn1.setOnClickListener{setTextFields("1")}
        bindingClass.btn2.setOnClickListener{setTextFields("2")}
        bindingClass.btn3.setOnClickListener{setTextFields("3")}
        bindingClass.btn4.setOnClickListener{setTextFields("4")}
        bindingClass.btn5.setOnClickListener{setTextFields("5")}
        bindingClass.btn6.setOnClickListener{setTextFields("6")}
        bindingClass.btn7.setOnClickListener{setTextFields("7")}
        bindingClass.btn8.setOnClickListener{setTextFields("8")}
        bindingClass.btn9.setOnClickListener{setTextFields("9")}
        bindingClass.btnDot.setOnClickListener{setTextFields(".")}


        bindingClass.btnMinus.setOnClickListener{setTextFields("-")}
        bindingClass.btnPlus.setOnClickListener{setTextFields("+")}
        bindingClass.btnDiv.setOnClickListener{setTextFields("/")}
        bindingClass.btnMultip.setOnClickListener{setTextFields("*")}
        bindingClass.btnLeftPar.setOnClickListener{setTextFields("(")}
        bindingClass.btnRightPar.setOnClickListener{setTextFields(")")}

        bindingClass.btnAC.setOnClickListener{
        bindingClass.operation.text=""
        bindingClass.operation.text=""}

        bindingClass.btnBack.setOnClickListener{
            var str = bindingClass.operation.text.toString()
            if (str.isNotEmpty())
                bindingClass.operation.text = str.substring(0,str.length-1)
            bindingClass.result.text=""

        }

        bindingClass.btnEqual.setOnClickListener{
            try {
                var ex = ExpressionBuilder(bindingClass.operation.text.toString()).build()
                var result = ex.evaluate()

                var longRes = result.toLong()
                if (result== longRes.toDouble())
                    bindingClass.result.text = longRes.toString()
                else
                    bindingClass.result.text = result.toString()
            }
            catch(e:Exception) {
                Log.d("Error", "message: ${e.message}")
            }
        }
    }

    fun setTextFields(str: String)
    {
        if(bindingClass.result.text != "") {
            bindingClass.operation.text = bindingClass.result.text
            bindingClass.result.text = ""
        }
        bindingClass.operation.append(str)
    }
}