package io.r2d211

import sbt.Keys._
import sbt._


/**
 * Plugin to publish plugin to maven style github packages.
 * Add io.r2d211.PblshPlgnGHPckgsPlugin#ghPckgPomConsistency in a plugin project settings
 * to publish the plugin project.
 * Add io.r2d211.PblshPlgnGHPckgsPlugin#addGHSbtPlugin(sbt.librarymanagement.ModuleID)
 * in plugins.sbt of the referencing project to be able to resolve plugin published
 * via io.r2d211.PblshPlgnGHPckgsPlugin#ghPckgPomConsistency
 */
object  extends sbt.AutoPlugin {

  def ghPckgPomConsistency: Seq[Setting[_]] = Seq(
    moduleName := {
      sbtGhPluginModuleName(moduleName.value,
        (pluginCrossBuild / sbtBinaryVersion).value)
    },
    projectID := {
      sbtPluginExtraArtibutes(projectID.value)
    },
  )

  def sbtGhPluginModuleName(n: String, sbtV: String): String =
    s"""${n}_sbt${if (sbtV == "1.0") "1" else if (sbtV == "2.0") "2" else sbtV}"""

  def sbtPluginExtraArtibutes(m: ModuleID): ModuleID =
    m.withExtraAttributes(Map.empty)
      .withCrossVersion(CrossVersion.binary)

  def addGHSbtPlugin(m: ModuleID): Setting[Seq[ModuleID]] =
    libraryDependencies += {
      val sbtV = (pluginCrossBuild / sbtBinaryVersion).value
      sbtPluginExtraArtibutes(m)
        .withName(sbtGhPluginModuleName(m.name, sbtV))
    }

}