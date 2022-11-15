package com.example.PR6_20012011109

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import androidx.core.view.WindowCompat
import com.example.PR6_20012011109.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window,false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initVideoPlayer()
        binding.btnSwitch.setOnClickListener{
            Intent(this,youtubeActivity::class.java).apply { startActivity(this) }

        }
    }
    private fun initVideoPlayer(){
        var mediaController = MediaController(this)
        var uri=Uri.parse("android.resource://"+packageName+"/"+R.raw.thestoryoflight)
        binding.MyVideoView2.setMediaController(mediaController)
        mediaController.setAnchorView(binding.MyVideoView2)
        binding.MyVideoView2.setVideoURI(uri)
        binding.MyVideoView2.requestFocus()
        binding.MyVideoView2.start()

    }
}
