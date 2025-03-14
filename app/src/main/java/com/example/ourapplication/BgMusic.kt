package com.example.ourapplication

import android.media.MediaPlayer

class BgMusic private constructor(){
    private lateinit var mediaPlayer: MediaPlayer
    private var isPlaying = true

    

    fun startMusic(){
        mediaPlayer.start()
        mediaPlayer.isLooping = true
    }

    fun pauseMusic(){
        mediaPlayer.pause()
    }

}