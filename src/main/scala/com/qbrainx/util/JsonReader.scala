package com.qbrainx.util
import com.qbrainx.model.{Student, Students}
import spray.json.DefaultJsonProtocol._
import spray.json._
import scala.io.Source
import scala.util.{Failure, Success, Try}

object JsonReader {

  def readFileToJson(path: String): String = {
    Try(Source.fromFile(path)) match {
      case Success(source: Source) =>
        source.getLines().mkString
      case Failure(exception) =>
         "Couldn't read the message" + exception.getMessage
    }
  }
  implicit val studentJsonFormat: RootJsonFormat[Student] =
    jsonFormat4(Student)

  implicit val studentsJsonFormat: RootJsonFormat[Students] = jsonFormat1(Students)


  def convertToMember(student : String): Student = {
    student.parseJson.convertTo[Student]
  }

  def convertToMembers(students: String ): Students = {
    students.parseJson.convertTo[Students]
  }


}
