package ferit.bozidarkelava.myapplication

import java.util.*

class InspiringPerson (ordinalNumber: Int, image: String, name: String, birthday: String, description: String, quotes: Array<String>)
{

    val index : Int = ordinalNumber
    val image: String = image
    val name: String = name
    val birthday: String = birthday
    val description: String = description
    val quotes: Array<String> = quotes

    fun getRandomQuote() : String {
        val arraySize = quotes.size - 1
        val indexOfQuote = (0..arraySize).random() //random idenks lise mudrih izreka
        return  quotes[indexOfQuote]
    }

    fun getImageUrl() : String {
        return this.image
    }
}