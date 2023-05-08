package com.example.myquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList:ArrayList<Question>?=null
    private var mSelectedOption: Int = 0
    private var mUserName: String?=null
    private var mCorrectAnswers:Int=0

    private var progressBar: ProgressBar?=null
    private var tvProgress: TextView?=null
    private var tvQuestion: TextView?=null
    private var ivImage: ImageView?=null
    private var btnSubmit: Button? = null

    private var tvOptionOne: TextView?=null
    private var tvOptionTwo: TextView?=null
    private var tvOptionThree: TextView?=null
    private var tvOptionFour: TextView?=null
   // initializing the variables of all the views

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setting the resources to the variables
        mUserName=intent.getStringExtra(Constants.USER_NAME)

        setContentView(R.layout.activity_quiz_questions)
        progressBar=findViewById(R.id.progress_bar)
        tvProgress=findViewById(R.id.tv_progress)
        tvQuestion=findViewById(R.id.tv_question)
        ivImage=findViewById(R.id.iv_image)
        btnSubmit=findViewById(R.id.btn_submit)

        tvOptionOne=findViewById(R.id.tv_optionOne)
        tvOptionTwo=findViewById(R.id.tv_optionTwo)
        tvOptionThree=findViewById(R.id.tv_optionThree)
        tvOptionFour=findViewById(R.id.tv_optionFour)

       tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
       btnSubmit?.setOnClickListener(this)
//setting up the listeners
        mQuestionsList = Constants.getQuestions()
        //Fetch the questions from the constants array
        setQuestion()

    }

    private fun setQuestion() {
        //Log.i("QuestionsList size is", "${questions.size}")

       // for (i in questions)
            //Log.e("Questions", i.question)

        //setting the question, option and the image to the variables created to default
        defaultOptionsView()
        // set the next question
        val question: Question = mQuestionsList!![mCurrentPosition - 1]
        //setting the progress
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestion?.text = question.question
        //set options
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour
        //set the image
        ivImage?.setImageResource(question.image)
        //setting the text on the button
        if(mCurrentPosition== mQuestionsList!!.size)
            btnSubmit?.text = "FINISH"
        else
            btnSubmit?.text="SUBMIT"
    }
    private fun defaultOptionsView(){

        //arraylist of textview and adding the current options to it
        val options = ArrayList<TextView>()
        tvOptionOne?.let{
            //lambda
            options.add(0,it)
        }
        tvOptionTwo?.let{
            options.add(1,it)
        }
        tvOptionThree?.let{
            options.add(2,it)
        }
        tvOptionFour?.let{
            options.add(3,it)
        }
        //setting the default border for none of the options selected
        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background= ContextCompat.getDrawable(this@QuizQuestionsActivity,R.drawable.default_option_border)
        }
    }
    private fun selectedOptionView(tv:TextView, selectedOptionNum: Int)
    {
        defaultOptionsView()
        // setting the selected option to the required view
        mSelectedOption = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background= ContextCompat.getDrawable(this, R.drawable.selected_option_button)

    }
    override fun onClick(view: View?) {
        //decides what happens on click
        when(view?.id){
            R.id.tv_optionOne->{
                tvOptionOne?.let{
                    selectedOptionView(it,1)
                }
            }
            R.id.tv_optionTwo->{
                tvOptionTwo?.let{
                    selectedOptionView(it,2)
                }
            }
            R.id.tv_optionThree->{
                tvOptionThree?.let{
                    selectedOptionView(it,3)
                }
            }
            R.id.tv_optionFour->{
                tvOptionFour?.let{
                    selectedOptionView(it,4)
                }
            }//decides what happens to our dear button
            R.id.btn_submit->{
                if(mSelectedOption==0)
                {
                    mCurrentPosition++
                    when{
                        mCurrentPosition<=mQuestionsList!!.size->{
                            setQuestion()
                        }
                        else->{
                            Toast.makeText(this@QuizQuestionsActivity,"You have reached the end!",Toast.LENGTH_LONG).show()
                            val intent= Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWER,mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionsList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val quest=mQuestionsList?.get(mCurrentPosition-1)

                    if(quest!!.correctAnswer!=mSelectedOption){
                        answerView(mSelectedOption, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(quest.correctAnswer, R.drawable.correct_option_border_bg)
                    if(mCurrentPosition==mQuestionsList!!.size){
                        btnSubmit?.text="FINISH"
                    }else{
                        btnSubmit?.text="GO TO NEXT QUESTION"
                    }
                    mSelectedOption= 0
                }
            }
        }
    }
    private fun answerView(answer:Int, drawableView:Int)
    {
        when(answer){
            1->{
                tvOptionOne?.background=ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
            2->{
                tvOptionTwo?.background=ContextCompat.getDrawable(
                    this@QuizQuestionsActivity,
                    drawableView
                )
            }
            3->{
                tvOptionThree?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4->{
                tvOptionFour?.background=ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }

        }
    }
}