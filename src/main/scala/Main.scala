/*
 * Copyright (c) 2025 "Maze Escape"
 * Licensed under the MIT License
 */

object Main extends App:

  import model._
  val player = Player((0, 0), 5, 0)
  val guardian_1 = Guardian((-5, -5))
  val guardian_2 = Guardian((5, 5))

  player.move(Direction.Up)
  guardian_1.intercept(player.position)
  guardian_2.intercept(player.position)
  player.move(Direction.Up)
  guardian_1.intercept(player.position)
  guardian_2.intercept(player.position)
  player.move(Direction.Up)
  guardian_1.intercept(player.position)
  guardian_2.intercept(player.position)

  println(player.position)
  println(guardian_1.position)
  println(guardian_2.position)