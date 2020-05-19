import com.ibm.icu.text.PluralRules
import com.ibm.icu.util.ULocale

object PluralizationExample {

  def main(args: Array[String]): Unit = {
    Seq("uk", "en").foreach { lang =>
      val locale = ULocale.forLanguageTag(lang)

      val pluralRules = PluralRules.forLocale(locale)

      println(s"Messages for $lang:")
      (0 to 25).foreach { number =>
        val key = s"$lang.message.${pluralRules.select(number)}"
        println(messages(key)(number))
      }
    }
  }

  val messages = Map(
    "uk.message.one" -> ((number: Int) => s"$number книжка"),
    "uk.message.few" -> ((number: Int) => s"$number книжки"),
    "uk.message.many" -> ((number: Int) => s"$number книжок"),
    "uk.message.other" -> ((number: Int) => s"$number книжок"),

    "en.message.one" -> ((number: Int) => s"$number book"),
    "en.message.many" -> ((number: Int) => s"$number books"),
    "en.message.other" -> ((number: Int) => s"$number books")
  )
}
