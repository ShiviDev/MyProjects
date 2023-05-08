package com.example.myquizapp

object Constants {
    const val USER_NAME: String ="user_name"
    const val TOTAL_QUESTIONS: String="total_questions"
    const val CORRECT_ANSWER:String="correct_answers"
    fun getQuestions(): ArrayList<Question>{
        val questionsList= ArrayList<Question>()
        val que1= Question(1,"Guess the flower", R.drawable.carnations_min_300x200,
            "Carnation", "Peony", "Petunia", "Geranium",1)
        questionsList.add(que1)
        val que2= Question(2,"Guess the flower", R.drawable.daffodil_min_300x200,
            "orchid", "Begonia","Daffodil", "Peony",3)
        questionsList.add(que2)
        val que3 = Question(3,"Guess the flower", R.drawable.daisies_min_300x200,
        "Petunia","Daisies","Jasmine","Clematis",2)
        questionsList.add(que3)
        val que4 = Question(4,"Guess the flower",R.drawable.iris_min_356x220,
        "Iris","Violet","Lilac","Gladiolus",1)
        questionsList.add(que4)
        val que5 = Question(5,"Guess the flower",R.drawable.marigolds_min_300x170,
        "Marigold","Ranunculus","Chrysanthemum","Rose",1)
        questionsList.add(que5)
        val que6 = Question(6,"Guess the flower",R.drawable.tulips_min_300x200,
        "Ranunculus","Rose","Tulip","Petunia",3)
        questionsList.add(que6)
        return questionsList
    }
}