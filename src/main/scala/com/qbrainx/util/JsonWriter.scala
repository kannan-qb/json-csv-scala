package com.qbrainx.util

import com.qbrainx.model.{Student, Students}

import java.io.PrintWriter
import scala.util.{Failure, Success, Try}

object JsonWriter {

  def convertMembersToCsv(students: Students, outputPath: String,errorPath: String): Any = {
    val fieldMembersNames: Iterator[String] = students.student.head.productElementNames
    val fieldValue: List[Student] = students.student
    Try(new PrintWriter(outputPath)) match {
      case Success(value) => {
        val header: String = fieldMembersNames.foldRight("")((prev, current) => prev + "," + current)
        value.println(header)
        Try(fieldValue.map(f => {
          val mobileValue: String = f.mobile match {
            case None => ","
            case Some(value) => value.toString + ","
          }
          val rowValue =   f.fName + ","+  f.lName + ","+ f.id + ","+ mobileValue
          value.println(rowValue)
        }))
        value.close()
      }
    }
  }

  def logErrorToFile(path: String, errorMessage: String): Unit = {
    Try(new PrintWriter(path)) match {
      case Success(value) => value.println(errorMessage)
        value.close()
      case Failure(exception) => println(exception.getMessage)
    }
  }
}

