package controllers

import model.{DB, Person}
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._
import play.api.libs.json.Json

object Application extends Controller {

  def index = Action {
    play.Logger.info("call index = Action");
    Ok(views.html.index("Scala sucks"))
  }

  val personForm: Form[Person] = Form{
    mapping(
    "name" -> text
    )(Person.apply)(Person.unapply)
  }

  def display = Action{
    implicit request =>
      Ok("cool")
  }

  def addPerson = Action {
    implicit request =>
    val person = personForm.bindFromRequest.get
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
