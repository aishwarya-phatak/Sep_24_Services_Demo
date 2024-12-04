package com.bitcode.sep_24_services_demo

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bitcode.sep_24_services_demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var intent : Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
//        /storage/emulated/0/Music/song_1.mp3
        activityMainBinding.btnStartService.setOnClickListener {
            intent = Intent(this,MediaPlayerService::class.java)
            intent.putExtra("file_path",activityMainBinding.edtFilePath.text.toString())
            startService(intent)
        }

        activityMainBinding.btnStopService.setOnClickListener {
            stopService(intent)
        }
    }
}