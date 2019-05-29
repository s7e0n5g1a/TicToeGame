package com.example.tictoegame

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val players = arrayOf("Kółko", "Krzyżyk")
    val random: Int = (0..1).random()
    var whoseTurn = players[random]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        settings()

    }
    fun settings () {

        turnKrzyzyk.isEnabled = false
        turnKolko.isEnabled = false

        var buttons = arrayOf(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13,
            b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25)

        startGame.setOnClickListener {
            start()
            startGame.isClickable=false
            startGame.visibility=INVISIBLE
        }

        for (item: Button in buttons) {
            item.setOnClickListener {
                if (validation() == true) {
                    item.setText(whoseTurn)
                    changeTurn()
                }

            }
        }
    }

    fun changeTurn () {

        if ( whoseTurn == players[0]) {
            whoseTurn = players[1]
            turnKolko.isEnabled = false
            turnKrzyzyk.isEnabled = true
            turnKrzyzyk.isChecked = true
        }
        else if ( whoseTurn == players[1]) {
            whoseTurn = players[0]
            turnKrzyzyk.isEnabled = false
            turnKolko.isEnabled = true
            turnKolko.isChecked = true
        }
    }
    fun start () {
        changeTurn()
    }
    fun validation(): Boolean {
        return false
    }


}