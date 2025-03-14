package com.example.ourapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random


class Playing : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_try)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Transitions
        val defeatTransition = Intent(this, DefeatTab::class.java)


        // counts
        var clickcount = 0

        // Scoring
        val scoreboard = findViewById<TextView>(R.id.scoreBoard)
        var addingScore = 0
        scoreboard.text = "0"
        var lives = 2

        // Elements
        val iSaw1 = findViewById<ImageView>(R.id.isaw1)
        val iSaw2 = findViewById<ImageView>(R.id.isaw2)
        val iSaw3 = findViewById<ImageView>(R.id.isaw3)
        val iSaw4 = findViewById<ImageView>(R.id.isaw4)
        val iSaw5 = findViewById<ImageView>(R.id.isaw5)
        val iSaw6 = findViewById<ImageView>(R.id.isaw6)
        val iSaw7 = findViewById<ImageView>(R.id.isaw7)
        val iSaw8 = findViewById<ImageView>(R.id.isaw8)
        val life = findViewById<TextView>(R.id.life)
        life.text = "3"
        val btn = findViewById<Button>(R.id.btn)


        // Game Resetting
        val isawCollection : MutableList<ImageView> = mutableListOf()
        // Functions
        fun indicator(): Boolean{
            return Random.nextBoolean()
        }
        fun checkToRestore(){
            if(clickcount >= 8) {
                for (isaw in isawCollection) {
                    isaw.visibility = View.VISIBLE
                }
                isawCollection.clear()
                clickcount = 0
            }
        }

        //Score Points
        val minScore = 0
        val maxScore = 33

        btn.setOnClickListener{
            iSaw1.visibility = View.VISIBLE
            iSaw2.visibility = View.VISIBLE
            iSaw3.visibility = View.VISIBLE
            iSaw4.visibility = View.VISIBLE
            iSaw5.visibility = View.VISIBLE
            iSaw6.visibility = View.VISIBLE
            iSaw7.visibility = View.VISIBLE
            iSaw8.visibility = View.VISIBLE
        }

        iSaw1.setOnClickListener{
            if (indicator()) {
                val putVal = (minScore..maxScore).random()
                addingScore += putVal
                scoreboard.text = addingScore.toString()
                iSaw1.visibility = View.INVISIBLE
                isawCollection.add(iSaw1)
                clickcount++
                checkToRestore()
            }else {
                if (lives != 0) {
                    life.text = lives--.toString()
                    iSaw2.visibility = View.INVISIBLE
                    isawCollection.add(iSaw2)
                    clickcount++
                    checkToRestore()
                    addingScore += 0
                }else {
                    startActivity(defeatTransition)
                }
            }
        }
        iSaw2.setOnClickListener{
            if (indicator()) {
                val putVal = (minScore..maxScore).random()
                addingScore += putVal
                scoreboard.text = addingScore.toString()
                iSaw2.visibility = View.INVISIBLE
                isawCollection.add(iSaw2)
                clickcount++
                checkToRestore()
                addingScore += 0
            }else {
                if (lives != 0) {
                    life.text = lives--.toString()
                    iSaw2.visibility = View.INVISIBLE
                    isawCollection.add(iSaw2)
                    clickcount++
                    checkToRestore()
                }else {
                    startActivity(defeatTransition)
                }
            }
        }
        iSaw3.setOnClickListener{
            if (indicator()) {
                val putVal = (minScore..maxScore).random()
                addingScore += putVal
                scoreboard.text = addingScore.toString()
                iSaw3.visibility = View.INVISIBLE
                isawCollection.add(iSaw3)
                clickcount++
                checkToRestore()
                addingScore += 0
            }else {
                if (lives != 0) {
                    life.text = lives--.toString()
                    iSaw3.visibility = View.INVISIBLE
                    isawCollection.add(iSaw3)
                    clickcount++
                    checkToRestore()
                }else {
                    startActivity(defeatTransition)
                }
            }
        }
        iSaw4.setOnClickListener{
            if (indicator()) {
                val putVal = (minScore..maxScore).random()
                addingScore += putVal
                scoreboard.text = addingScore.toString()
                iSaw4.visibility = View.INVISIBLE
                isawCollection.add(iSaw4)
                clickcount++
                checkToRestore()
                addingScore += 0
            }else {
                if (lives != 0) {
                    life.text = lives--.toString()
                    iSaw4.visibility = View.INVISIBLE
                    isawCollection.add(iSaw4)
                    clickcount++
                    checkToRestore()
                    addingScore += 0
                }else {
                    startActivity(defeatTransition)
                }
            }
        }
        iSaw5.setOnClickListener{
            if (indicator()) {
                val putVal = (minScore..maxScore).random()
                addingScore += putVal
                scoreboard.text = addingScore.toString()
                iSaw5.visibility = View.INVISIBLE
                isawCollection.add(iSaw5)
                clickcount++
                checkToRestore()
                addingScore += 0
            }else {
                if (lives != 0) {
                    life.text = lives--.toString()
                    iSaw5.visibility = View.INVISIBLE
                    isawCollection.add(iSaw5)
                    clickcount++
                    checkToRestore()
                }else {
                    startActivity(defeatTransition)
                }
            }
        }
        iSaw6.setOnClickListener{
            if (indicator()) {
                val putVal = (minScore..maxScore).random()
                addingScore += putVal
                scoreboard.text = addingScore.toString()
                iSaw6.visibility = View.INVISIBLE
                isawCollection.add(iSaw6)
                clickcount++
                checkToRestore()
                addingScore += 0
            }else {
                if (lives != 0) {
                    life.text = lives--.toString()
                    iSaw6.visibility = View.INVISIBLE
                    isawCollection.add(iSaw6)
                    clickcount++
                    checkToRestore()
                }else {
                    startActivity(defeatTransition)
                }
            }
        }
        iSaw7.setOnClickListener{
            if (indicator()) {
                val putVal = (minScore..maxScore).random()
                addingScore += putVal
                scoreboard.text = addingScore.toString()
                iSaw7.visibility = View.INVISIBLE
                isawCollection.add(iSaw7)
                clickcount++
                checkToRestore()
                addingScore += 0
            }else {
                if (lives != 0) {
                    life.text = lives--.toString()
                    iSaw7.visibility = View.INVISIBLE
                    isawCollection.add(iSaw7)
                    clickcount++
                    checkToRestore()
                }else {
                    startActivity(defeatTransition)
                }
            }
        }
        iSaw8.setOnClickListener {
            if (indicator()) {
                val putVal = (minScore..maxScore).random()
                addingScore += putVal
                scoreboard.text = addingScore.toString()
                iSaw8.visibility = View.INVISIBLE
                isawCollection.add(iSaw8)
                clickcount++
                checkToRestore()
                addingScore += 0
            }else {
                if (lives != 0) {
                    life.text = lives--.toString()
                    iSaw8.visibility = View.INVISIBLE
                    isawCollection.add(iSaw8)
                    clickcount++
                    checkToRestore()
                    addingScore += 0
                }else {
                    startActivity(defeatTransition)
                }
            }
        }
    }
}