package ferit.bozidarkelava.myapplication2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ferit.bozidarkelava.myapplication.PeopleRepository
import kotlinx.android.synthetic.main.fragment_add.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentAdd : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View  = inflater.inflate(R.layout.fragment_add, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnBacktoStart: Button = view.findViewById(R.id.btnBack)
        btnBacktoStart.setOnClickListener {
            val context = activity as AppCompatActivity
            context.supportFragmentManager.beginTransaction().replace(R.id.addFrameLayout, FragmentStart()).commit()
        }
        var btnAdd: ImageView =view.findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener {
            if (etIdentifier.text.toString().trim().isEmpty() ||
                etNameLastName.text.toString().trim().isEmpty() ||
                etDate.text.toString().trim().isEmpty() ||
                etInfo.text.toString().trim().isEmpty() ||
                etImage.text.toString().trim().isEmpty() ||
                etQuotes.text.toString().trim().isEmpty()
            ) {
                Toast.makeText(activity, "YOU ARE MISSING SOMETHING", Toast.LENGTH_LONG).show()
            } else {
                val identifierString: String = etIdentifier.text.toString()
                val identifier: Int = identifierString.toInt()
                val name: String = etNameLastName.text.toString()
                val birtdate: String = etDate.text.toString()
                val information: String = etInfo.text.toString()
                val imageURL: String = etImage.text.toString()
                val quotes = etQuotes.text.toString().split(";").toTypedArray()

                val newPerson =
                    InspiringPerson(identifier, imageURL, name, birtdate, information, quotes)

                PeopleRepository.addPerson(newPerson)
                reset()
            }
        }
    }

    private fun reset() {
        etIdentifier.setText("")
        etIdentifier.setText("")
        etNameLastName.setText("")
        etDate.setText("")
        etInfo.setText("")
        etImage.setText("")
        etQuotes.setText("")
    }
}
