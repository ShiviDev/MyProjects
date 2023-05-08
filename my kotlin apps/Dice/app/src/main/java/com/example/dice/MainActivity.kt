package com.example.dice

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
           // val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            //toast.show()
            rollDice()
        }
    }

    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val myDice = Dice(6)
        val diceRoll= myDice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()


    }
        // Update the screen with the dice roll
        /*val resultTextView : TextView = findViewById(R.id.textView)
        resultTextView.text=myDice.roll().toString()*/
       //to roll 2nd dice
        /* val myDice2=Dice(20)
        val resultTextView2: TextView = findViewById(R.id.textView2)
        resultTextView2.text=myDice2.roll().toString()*/

    }
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}