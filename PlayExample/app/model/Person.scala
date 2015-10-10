package model

import play.api.libs.json.Json

/**
 * Created by cat on 10/1/15.
 */
case class Person(name: String)

object Person{
  //implicit val personFormat = Json.format[Person]
  implicit val whatFormat = Json.format[Person]

}