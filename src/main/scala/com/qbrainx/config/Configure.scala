package com.qbrainx.config

import com.typesafe.config.{Config, ConfigFactory}

object Configure {

  val config: Config = ConfigFactory.load().getConfig("jsontocsv")


}
