package com.example.qr_code_scanner


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import android.widget.TextView
import me.dm7.barcodescanner.zbar.Result
import me.dm7.barcodescanner.zbar.ZBarScannerView

class ScannerActivity : AppCompatActivity(), ZBarScannerView.ResultHandler {

    private lateinit var zBarView: ZBarScannerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        zBarView = ZBarScannerView(this)
        setContentView(zBarView)
    }


    override fun onResume() {
        super.onResume()
        zBarView.setResultHandler(this)
        zBarView.startCamera()
    }

    override fun onPause() {
        super.onPause()
        zBarView.stopCamera()

    }

    override fun handleResult(result: Result?) {

        setContentView(R.layout.activity_main)
        var tAnswer:TextView = findViewById(R.id.answer)
        tAnswer.text = result?.contents

        Log.d("Mylog", "Result:${result?.contents}")
    }

}