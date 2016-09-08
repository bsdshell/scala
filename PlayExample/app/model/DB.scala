package model

import sorm._
/**
 * Created by cat on 10/1/15.
 */
object DB extends Instance (entities = Seq(Entity[Person](), Entity[Code]()), url="jdbc:h2:mem:test" )
