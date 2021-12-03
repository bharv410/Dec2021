package com.example.myfirstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

/**
 * A simple [Fragment] subclass.
 * Use the [DiceRollFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DiceRollFragment : Fragment() {

    lateinit var diceImage : ImageView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_dice_roll,container,false)
        diceImage = view.findViewById(R.id.dice_image)
        val rollButton: TextView = view.findViewById(R.id.roll_dice_action_button)

        rollButton.setOnClickListener {

            val randomInt = (1..6).random()

            val drawableResource = when (randomInt) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }

            var anim = AnimationUtils.loadAnimation(context,R.anim.shake)
            anim.setAnimationListener(object: Animation.AnimationListener {
                override fun onAnimationRepeat(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    diceImage.setImageResource(drawableResource)
                }

                override fun onAnimationStart(animation: Animation?) {
                }

            })
            diceImage.startAnimation(anim)


        }
        return view
    }


}