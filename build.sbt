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
version := "0.0.0"
ThisBuild / organization := "org.bajaj"
ThisBuild / sbtPlugin := true
ThisBuild / sbtVersion := "1.6.2"
enablePlugins(SbtPlugin)

scmInfo := Some(
  ScmInfo(
    url("https://github.com/r2d2-94/sbt-publish-plugin-github-packages"),
    "scm:git@github.com:r2d2-94/sbt-github-packages.git"))

developers := List(
  Developer(id="r2d2-94", name="Mohit", email="bajajmohit0694@gmail.com", url=url("https://github.com/r2d2-94")))

publishMavenStyle := true
githubOwner := "r2d2-94"
githubRepository := "sbt-publish-plugin-github-packages"
githubTokenSource := TokenSource.GitConfig("github.token") || TokenSource.Environment("GITHUB_TOKEN")

scriptedLaunchOpts ++= Seq("-Dplugin.version=" + version.value)
scriptedBufferLog := true