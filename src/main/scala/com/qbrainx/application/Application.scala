package com.qbrainx.application
import com.qbrainx.config.Configure
import com.qbrainx.model.Students
import com.qbrainx.util.{JsonReader, JsonWriter}

import scala.util.{Failure, Success, Try}

object Application extends App {
  val fileContent: Option[String] = Try(JsonReader.readFileToJson(Configure.config.getString("inputpath"))) match {
    case Success(value) => Some(value)
    case Failure(exception) => Option.empty
  }
  if (fileContent.isEmpty) {
    JsonWriter
      .logErrorToFile(Configure.config.getString("errorpath"), "Couldn't read the Json File")
  } else {
    val members: Try[Students] = Try(JsonReader.convertToMembers(fileContent.get))
    members match {
      case Success(value) =>
        JsonWriter.convertMembersToCsv(value, Configure.config.getString("outputpath"),Configure.config.getString("errorpath"))
      case Failure(exception) =>
        JsonWriter
          .logErrorToFile(Configure.config.getString("errorpath"), exception.getMessage)

    }
  }


}
