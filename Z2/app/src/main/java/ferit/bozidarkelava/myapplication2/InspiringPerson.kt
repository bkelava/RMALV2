package ferit.bozidarkelava.myapplication2

import java.util.*

class InspiringPerson(ordinalNumber: Int, image: String, name: String, birthday: String, description: String, quotes: Array<String>)
{
    val index : Int = ordinalNumber
    var image: String = image
    var name: String = name
    var birthday: String = birthday
    var description: String = description
    var quotes: Array<String> = quotes

    fun getRandomQuote() : String {
        val arraySize = quotes.size - 1
        val indexOfQuote = (0..arraySize).random() //random idenks lise mudrih izreka
        return  quotes[indexOfQuote]
    }

    fun getImageUrl() : String {
        return this.image
    }
}