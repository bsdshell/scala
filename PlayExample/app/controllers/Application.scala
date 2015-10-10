package controllers
import model.{Code, DB, Person}
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._
import play.api.libs.json.Json

object Application extends Controller {

  def index = Action {
    play.Logger.info("call index = Action");
    Ok(views.html.index("Scala sucks"))
  }

  val whatForm: Form[Person] = Form{
    mapping(
    "name" -> text
    )(Person.apply)(Person.unapply)
  }

  val codeForm: Form[Code] = Form{
    mapping(
    "name" -> text
    )(Code.apply)(Code.unapply)
  }

  def display = Action{
    implicit request =>
      Ok("cool")
  }

  def getImages(imgName:String) = Action {
    implicit request =>
    Ok("getImages")
  }

  def postCode = Action{
    implicit request =>
      val what = codeForm.bindFromRequest.get
      DB.save(what)
      Redirect(routes.Application.display)
      //Ok(Json.toJson(code))
  }

  def getCode = Action {
    implicit request =>
      val code = DB.query[Code].fetch
      Ok("getCode get called")
      Ok(Json.toJson(code))
  }

  def addPerson = Action {
    implicit request =>
    val person = whatForm.bindFromRequest.get
    DB.save(person)
      Redirect(routes.Application.display)
  }

  def getPersons = Action {
    implicit request =>
    val persons = DB.query[Person].fetch
    Ok("get persons method")
    Ok(Json.toJson(persons))
  }

  def upload = Action(parse.multipartFormData) { request =>
    request.body.file("picture").map { picture =>
      import java.io.File
      val filename = picture.filename
      val contentType = picture.contentType
      picture.ref.moveTo(new File("/tmp/" + filename))
      Ok("File uploaded" + contentType + " filename=" + filename)
    }.getOrElse {
      Redirect(routes.Application.index).flashing(
        "error" -> "Missing file"
      )
    }
  }
}
