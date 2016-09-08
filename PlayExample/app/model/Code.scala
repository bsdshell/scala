package model

import play.api.libs.json.Json

/**
 * Created by cat on 10/7/15.
 */

case class Code(name: String, name2:String)

object Code{
  implicit val codeFormat = Json.format[Code]
}