package ferit.bozidarkelava.myapplication2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ferit.bozidarkelava.myapplication.PeopleRepository
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_edit_person.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentEditPerson : Fragment() {

    var name: String = ""
    var birthdate: String = ""
    var description: String = ""
    var image: String = ""
    var quotes: String = ""
    var index: String = ""

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_edit_person, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnBack: Button = view.findViewById(R.id.btnBackToStart)
        btnBack.setOnClickListener {
            val mContext = activity as AppCompatActivity
            mContext.supportFragmentManager.beginTransaction()
                .replace(R.id.frameEditPersonLayout, FragmentStart()).commit()
        }

        Log.d("INDEX AS STRING", index)
        index = arguments?.getString("KEY").toString()
        Log.d("INDEX", index)
        var mIndex: Int? = index.toIntOrNull()
        Log.d("INDEX AS STRING", mIndex.toString())
        val btnSave: Button = view.findViewById(R.id.btnSave)
        btnSave.setOnClickListener() {
            if (etEditNameLastName.text.toString().trim().isEmpty() ||
                etEditDate.text.toString().trim().isEmpty() ||
                etEditInfo.text.toString().trim().isEmpty() ||
                etEditImage.text.toString().trim().isEmpty() ||
                etEditQuotes.text.toString().trim().isEmpty()
            ) {
                Toast.makeText(activity, "YOU ARE MISSING SOMETHING", Toast.LENGTH_LONG).show()
            } else {
                val name: String = etEditNameLastName.text.toString()
                val birthday: String = etEditDate.text.toString()
                val description: String = etEditInfo.text.toString()
                val image: String = etEditImage.text.toString()
                val position = mIndex?.let { it1 -> PeopleRepository.get(it1) }
                val quotes = etEditQuotes.text.toString().split(";").toTypedArray()

                Log.d("position", position.toString())
                PeopleRepository.editPeople(InspiringPerson(position!!, image, name, birthday, description, quotes), position)
            }
        }
    }
}