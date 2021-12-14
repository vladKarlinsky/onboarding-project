package com.example.movielistgenerator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.movielistgenerator.model.RecommenderViewModel
import sdk.pendo.io.Pendo


class MainFragment : Fragment(), View.OnClickListener {

    lateinit var inputField : EditText
    lateinit var navController: NavController
    private val sharedViewModel : RecommenderViewModel by activityViewModels()

    // Pendo SDK values

    val visitorId = "vlad developer"
    val  accountId = "Regular account"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        inputField = view.findViewById(R.id.inputField) as EditText
        view.findViewById<Button>(R.id.enterRandomComb).setOnClickListener(this)

        // Pendo SDK init
        // send Visitor Level Data
        val visitorData: HashMap<String, Any> = HashMap()
        visitorData["age"] = 24
        visitorData["country"] = "Israel"

        // send Account Level Data
        val accountData: HashMap<String, Any> = HashMap()
        accountData["Tier"] = 1
        accountData["Size"] = "Enterprise"


        Pendo.startSession(
            visitorId,
            accountId,
            visitorData,
            accountData
        )

    }
    override fun onClick(v: View?) {
        sharedViewModel.setUserInput(inputField.text.toString())
        sharedViewModel.getMoviesList()
        navController.navigate(R.id.action_mainFragment_to_resultFragment)
    }

}