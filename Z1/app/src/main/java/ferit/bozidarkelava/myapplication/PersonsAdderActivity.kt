package ferit.bozidarkelava.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_persons_adder.*

class PersonsAdderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persons_adder)
        btnAdd.setOnClickListener() {
            if (etIdentifier.text.toString().trim().isEmpty() ||
                etNameLastName.text.toString().trim().isEmpty() ||
                etDate.text.toString().trim().isEmpty() ||
                etInfo.text.toString().trim().isEmpty()||
                etImage.text.toString().trim().isEmpty() ||
                etQuotes.text.toString().trim().isEmpty() ) {
                Toast.makeText(this, "YOU ARE MISSING SOMETHING", Toast.LENGTH_LONG).show()
            }
            else {
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

        btnBack.setOnClickListener() {
            val intent : Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
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
