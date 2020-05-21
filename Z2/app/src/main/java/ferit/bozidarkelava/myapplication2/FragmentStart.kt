package ferit.bozidarkelava.myapplication2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ferit.bozidarkelava.myapplication.PeopleRepository
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_edit_person.*
import kotlinx.android.synthetic.main.fragment_start.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentStart : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View  = inflater.inflate(R.layout.fragment_start, container, false)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lateinit var communicator: Communicator
        communicator = activity as Communicator

        val btnAdd: Button = view.findViewById(R.id.btnAddNewPerson)
        btnAdd.setOnClickListener {
            val mContext = activity as AppCompatActivity
            mContext.supportFragmentManager.beginTransaction().replace(R.id.startFrameLayout, FragmentAdd()).commit()
        }

        val personClick = object : quoteOnClick {
            override fun getQuote(index: Int) {
                val mContext = activity as AppCompatActivity
                val famousePerson = PeopleRepository.getPerson(index)
                if (famousePerson != null) {
                    Toast.makeText(mContext, famousePerson.getRandomQuote(), Toast.LENGTH_LONG).show()
                }
            }

            override fun delete(position: Int) {
                PeopleRepository.remove(position)
                val mContext = activity as AppCompatActivity  //ova i sljedeca linija koda sluze za refresh fragmenta nnakon brisanja itema
                mContext.supportFragmentManager.beginTransaction().detach(this@FragmentStart).attach(this@FragmentStart).commit()
            }

            override fun edit(index: Int) {
                val mContext = activity as AppCompatActivity
                //val bundle: Bundle = Bundle()
                //val fragment = FragmentStart()
                communicator.passData(index.toString())
                Log.d("TAG",index.toString())
                //mContext.supportFragmentManager.beginTransaction().replace(R.id.startFrameLayout, FragmentEditPerson()).commit()
            }
        }
        val context = activity as AppCompatActivity
        rvFamousPersons.layoutManager =  LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rvFamousPersons.adapter = InspiringPersonAdapter(PeopleRepository.famousPersons, personClick, context)

        btnExit.setOnClickListener {
            ActivityCompat.finishAffinity(Activity())
            System.exit(-1)
        }
    }
}
