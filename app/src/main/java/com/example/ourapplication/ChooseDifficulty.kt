package com.example.ourapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ChooseDifficulty : AppCompatActivity() {

    private lateinit var music : ImageView

    private var musicActivity = true

    private var isPlaying = true

    private lateinit var mediaPlayer: MediaPlayer

    private lateinit var transition : Intent

    private lateinit var transitionBack : Intent

    private lateinit var transitionHome : Intent

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_choose_difficulty)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        // Elements
        val difficulty1 = findViewById<ImageView>(R.id.difficulty)
        val difficulty2 = findViewById<ImageView>(R.id.difficulty2)
        val difficulty3 = findViewById<ImageView>(R.id.difficulty3)
        val tenSec = findViewById<TextView>(R.id.tenSec)
        val thirtySec = findViewById<TextView>(R.id.thirtySec)
        val fortySec = findViewById<TextView>(R.id.fortySec)
        val chooseDiffBackBtn = findViewById<ImageView>(R.id.chooseDiffBackBtn)
        val chooseDiffHomeBtn = findViewById<ImageView>(R.id.chooseDiffHomeBtn)

        music = findViewById(R.id.music)

        // Get Extras
        val tenHighScore : Int = intent.getIntExtra("tenHighScore", 0)
        val thirtyHighScore : Int = intent.getIntExtra("thirtyHighScore", 0)
        val fortyHighScore : Int = intent.getIntExtra("fortyHighScore", 0)

        // Storage
        val tenSecScore : Int = sharedPref.getInt("tenSecScore", 0)
        val thirtySecScore : Int = sharedPref.getInt("thirtySecScore", 0)
        val fortySecScore : Int = sharedPref.getInt("fortySecScore", 0)


        if (tenSecScore <= tenHighScore && thirtySecScore <= thirtyHighScore && fortySecScore <= fortyHighScore) {
            editor.apply {
                putInt("tenSecScore", tenHighScore)
                putInt("thirtySecScore", thirtyHighScore)
                putInt("fortySecScore", fortyHighScore)
                apply()
            }
        }

        // Setup HighScore Boards
        tenSec.text = "HIGH SCORE: $tenSecScore"
        thirtySec.text = "HIGH SCORE: $thirtySecScore"
        fortySec.text = "HIGH SCORE: $fortySecScore"

        // Passing to Another Activity
        transition = Intent(this, Playing::class.java)
        transitionBack = Intent(this, HowToPlay::class.java)
        transitionHome = Intent(this,MainActivity::class.java)

        // Music Activity
        musicActivity = intent.getBooleanExtra("musicActivity", true)
        mediaPlayer = MediaPlayer.create(this, R.raw.musicforgame)

        // Start of Background Player
        mediaPlayer.start()
        mediaPlayer.isLooping = true

        if (!musicActivity) {
            isPlaying = false
            mediaPlayer.pause()
            music.setImageResource(R.drawable.baseline_music_off_24)
            transition.putExtra("musicActivity", false)
            transitionBack.putExtra("musicActivity", false)
            transitionHome.putExtra("musicActivity", false)
        }
        music.setOnClickListener{
            if (isPlaying) {
                mediaPlayer.pause()
                isPlaying = false
                musicActivity = false
                transition.putExtra("musicActivity", false)
                transitionBack.putExtra("musicActivity", false)
                transitionHome.putExtra("musicActivity", false)
                music.setImageResource(R.drawable.baseline_music_off_24)
            } else {
                mediaPlayer.start()
                mediaPlayer.isLooping = true
                isPlaying = true
                musicActivity = true
                transition.putExtra("musicActivity", true)
                transitionBack.putExtra("musicActivity", true)
                transitionHome.putExtra("musicActivity", true)
                music.setImageResource(R.drawable.baseline_music_note_24)
            }
        }

        chooseDiffBackBtn.setOnClickListener{
            startActivity(transitionBack)
            mediaPlayer.pause()
            finish()
        }
        chooseDiffHomeBtn.setOnClickListener{
            startActivity(transitionHome)
            mediaPlayer.pause()
            finish()
        }
        difficulty1.setOnClickListener{
            transition.putExtra("difficulty1Bool", true)
            transition.putExtra("reRun", true)
            mediaPlayer.pause()
            startActivity(transition)
            finish()
        }
        difficulty2.setOnClickListener{
            transition.putExtra("difficulty2Bool", true)
            transition.putExtra("reRun", true)
            mediaPlayer.pause()
            startActivity(transition)
            finish()
        }
        difficulty3.setOnClickListener {
            transition.putExtra("difficulty3Bool", true)
            transition.putExtra("reRun", true)
            mediaPlayer.pause()
            startActivity(transition)
            finish()

        }
    }
    override fun onStop(){
        super.onStop()
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
            musicActivity = true
        }
    }
    override fun onResume(){
        super.onResume()
        if (musicActivity){
            mediaPlayer.start()
            mediaPlayer.isLooping = true
        }
    }
}