package ferit.bozidarkelava.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFamousPersons.layoutManager =  LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        btnAdd.setOnClickListener(){
            val intent : Intent = Intent(this@MainActivity,PersonsAdderActivity::class.java)
            startActivity(intent)
        }

        val personClick = object : quoteOnClick {
            override fun getQuote(index: Int) {
                val famousePerson = PeopleRepository.getPerson(index)
                if (famousePerson != null) {
                    Toast.makeText(applicationContext, famousePerson.getRandomQuote(), Toast.LENGTH_LONG).show()
                }
            }
        }

        rvFamousPersons.adapter = InspiringPersonAdapter(PeopleRepository.famousPersons, personClick, this)

        btnExit.setOnClickListener(){
            ActivityCompat.finishAffinity(this)
            finish()
            System.exit(-1)
        }

    }
}
