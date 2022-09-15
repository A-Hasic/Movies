package com.example.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class HomeFragment: Fragment() {

    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.home_fragment,container,false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView).apply {
            adapter = MessageAdapter(mojiFilmovi)


            layoutManager = GridLayoutManager(context, 2)

        }


        view.findViewById<TextInputEditText>(R.id.edittext).doOnTextChanged { text, start, before, count ->
            filtrirajListu(text.toString())
        }
    }



    fun filtrirajListu(rijec: String) {
        recyclerView.adapter = MessageAdapter(mojiFilmovi.filter { movie -> movie.title == rijec })
    }
}

