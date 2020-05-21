package ferit.bozidarkelava.myapplication

import ferit.bozidarkelava.myapplication2.InspiringPerson
import java.text.FieldPosition

//singleton
object PeopleRepository {

    val famousPersons: MutableList<InspiringPerson>

    init {
        famousPersons = obtainFamousPersons()
    }
    private fun obtainFamousPersons(): MutableList<InspiringPerson> { //kad sam stavio getFamousePersons() za ime funkcije - ne radi????

        //isti citati se nalaze u strings.xml, prvo sam imao problem s dohvacanjem stringova zbog znakova ".", "'", "?"
        //nakon toga problem zbog sdk verzije
        //nakon rjesavanja ovih problema, nisam mogao dohvatiti resurse buduci da se nalaze u klasi koja nasljedjuje Activity
        //bilo bi potrebno refaktoriranje koda s konstruktorom koji prima  Context
        val DennisR= arrayOf("Im not a person who particularly had heros when growing up",
                                            "I fix things now and then, more often tweak HTML and make scripts to do things",
                                            "Over the past several years, Ive been more in a managerial role")
        val markZ = arrayOf("The thing that we are trying to do at facebook is just help people connect and communicate more efficiently",
                            "We are running the company to serve more people",
                            "The question isnt What do we want to know about people, Its, What do people want to tell about themselves")
        val LawE = arrayOf("It’s Microsoft versus mankind, with Microsoft having only a slight lead",
                                        "If an innovative piece of software comes along, Microsoft copies it and makes it part of Windows. This is not innovation; this is the end of innovation",
                                        "Sometimes there is no happy choice, only one less griveous than the others")

        //slična situacija je ovdije, kada u konstruktor klase InspiringPerson predam npr. za sliku getSystem().getString(R.string.imageMark)
        //dobijem kao "hint" string iz resursa strings.xml, ali ne radi
        return mutableListOf(
            InspiringPerson(
                1,
                "https://upload.wikimedia.org/wikipedia/commons/2/23/Dennis_Ritchie_2011.jpg",
                "Dennis Ritchier",
                "September 9, 1941 – c. October 12, 2011",
                "Dennis MacAlistair Ritchie was an American computer scientist. He created the C programming language and, with long-time colleague Ken Thompson, the Unix operating system and B programming language",
                DennisR
            ),
            InspiringPerson(
                2,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/Mark_Zuckerberg_F8_2018_Keynote_%28cropped_2%29.jpg/800px-Mark_Zuckerberg_F8_2018_Keynote_%28cropped_2%29.jpg",
               "Mark Zuckerburg",
                "May 14, 1984",
                "Mark Elliot Zuckerberg is an American internet entrepreneur and philanthropist. He is known for co-founding Facebook, Inc.",
                markZ
            ),
            InspiringPerson(
                3,
               "https://upload.wikimedia.org/wikipedia/commons/thumb/0/00/Larry_Ellison_picture.png/220px-Larry_Ellison_picture.png",
                "Lawrence Ellison",
                ">August 17, 1944",
                "Lawrence Joseph Ellison is an American business magnate, investor, and philanthropist who is a co-founder and the executive chairman and chief technology officer (CTO) of Oracle Corporation.[<",
                LawE
            )
        )
    }

    fun getPerson(index: Int): InspiringPerson? = famousPersons.find {
        famousPersons -> famousPersons.index == index
    }

    fun addPerson(newPerson: InspiringPerson) {
        famousPersons.add(newPerson)
    }

    fun remove (index: Int) = famousPersons.removeAll()
    {
        famousPersonsersons -> famousPersonsersons.index == index
    }

    fun editPeople (inspiringPerson: InspiringPerson, index: Int) {
        this.famousPersons[index].name = inspiringPerson.name;
        this.famousPersons[index].birthday = inspiringPerson.birthday;
        this.famousPersons[index].description = inspiringPerson.description;
        this.famousPersons[index].image = inspiringPerson.image;
        this.famousPersons[index].quotes = inspiringPerson.quotes;
    }

    fun get(position: Int): Int {
        var mPosition = 0
            for (i in 0.. famousPersons.size-1)
            {
                if (famousPersons[i].index == position)
                    mPosition = i
            }
        return mPosition
    }

}