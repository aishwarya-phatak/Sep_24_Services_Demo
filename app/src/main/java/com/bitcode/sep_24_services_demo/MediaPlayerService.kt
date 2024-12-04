package com.bitcode.sep_24_services_demo

import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.IBinder
import android.util.Log
import android.widget.Toast

class MediaPlayerService : Service() {
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var uri : Uri

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(this,"onCreate Method of Service Class is Called",Toast.LENGTH_LONG).show()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this,"onStartCommand Method Called $intent -- $flags -- $startId", Toast.LENGTH_LONG).show()

        Log.e("tag","onStartCommand Method Called $intent -- $flags -- $startId")
        if (intent != null) {
           var path = intent.getStringExtra("file_path")
            uri = Uri.parse(path)
        }

        mediaPlayer = MediaPlayer.create(this,uri)
        mediaPlayer.isLooping = true
        mediaPlayer.start()

        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
        Toast.makeText(this,"onBind Method Called",Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"onDestroy Method Called",Toast.LENGTH_LONG).show()
        mediaPlayer.stop()
    }
}