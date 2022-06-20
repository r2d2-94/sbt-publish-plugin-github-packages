import xerial.sbt.Sonatype.GitHubHosting

/*
 * Copyright 2022 Mohit Bajaj
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

name := "sbt-publish-plugin-github-packages"
version := "0.0.0-alpha4"
ThisBuild / organization := "io.github.r2d211"
ThisBuild / sbtPlugin := true
ThisBuild / sbtVersion := "1.6.2"
enablePlugins(SbtPlugin)

scmInfo := Some(
  ScmInfo(
    url("https://github.com/r2d211/sbt-publish-plugin-github-packages"),
    "scm:git@github.com:r2d211/sbt-github-packages.git"))

developers := List(
  Developer(id="r2d211", name="Mohit", email="bajajmohit11@gmail.com", url=url("https://github.com/r2d211")))

// open source licenses that apply to the project
licenses := Seq("APL2" -> url("https://www.apache.org/licenses/LICENSE-2.0.txt"))
sonatypeCredentialHost := "s01.oss.sonatype.org"
publishTo := sonatypePublishToBundle.value
publishMavenStyle := true

sonatypeProfileName := "io.github.r2d211"
sonatypeProjectHosting := Some(GitHubHosting("r2d211", "sbt-publish-plugin-github-packages", "bajajmohit11@gmail.com"))

scriptedLaunchOpts ++= Seq("-Dplugin.version=" + version.value)
scriptedBufferLog := true