package com.qbrainx.util
import scala.io.Source
import scala.util.{Failure, Success, Try}

class JsonReader {

  def readFileToJson(path: String): String = {
    Try(Source.fromFile(path)) match {
      case Success(source: Source) =>
        source.getLines().mkString
      case Failure(exception) =>
         "Couldn't read the message" + exception.getMessage
    }
  }



}
