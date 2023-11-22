package com.example.multimedia

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.MediaController
import android.widget.VideoView
import java.io.File

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val videoView1 = findViewById<VideoView>(R.id.simpleVideoView)
// Opción 1: Archivo en disco (Nota: android.permission.WRITE_EXTERNAL_STORAGE)
        val clip = File(Environment.getExternalStorageDirectory(), "video.mp4")
        videoView1.setVideoPath(clip.path);
        //reproducir(videoView1)
// Opción 2: Archivo en directorio res/raw (Nota: no debemos escribir la extensión)
        val videoView2 = findViewById<VideoView>(R.id.VideoView2)
        videoView2.setVideoURI(Uri.parse("android.resource://$packageName/raw/libro"))
        //reproducir(videoView2)
// Opción 3: Archivo en Internet (Nota: android.permission.INTERNET)
        val videoView3 = findViewById<VideoView>(R.id.VideoView3)
        videoView3.setVideoPath("https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4")
        reproducir(videoView3)
    }

    private fun reproducir(videoView: VideoView) {
        val mediaController = MediaController(this)
        mediaController.setMediaPlayer(videoView)
        videoView.setMediaController(mediaController)
        videoView.requestFocus()
        videoView.start()
    }

}