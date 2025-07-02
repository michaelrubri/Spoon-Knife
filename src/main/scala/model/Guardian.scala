/*
 * Copyright (c) 2025 "Maze Escape"
 * Licensed under the MIT License
 */

package model

/**
 * Represents the NPC character ruled by the system.
 */
trait Guardian extends Entity:

  /**
   * The current position of the guardian.
   */
  def position: (Int, Int)

  /**
   * Moves the guardian towards the player.
   *
   * @param target - the position of the player.
   */
  def intercept(target: (Int, Int)): Unit

object Guardian:
  def apply(initialPosition: (Int, Int)): Guardian =
    GuardianImpl(initialPosition)

private case class GuardianImpl(private var _position: (Int, Int)) extends Guardian:
  override def position: (Int, Int) = _position
  override def intercept(target: (Int, Int)): Unit =
    val dx = target._1 - _position._1
    val dy = target._2 - _position._2
    (dx, dy) match
      case (0, 0) => ()
      case (dx, dy) if math.abs(dx) > math.abs(dy) =>
        _position = (_position._1 + dx.sign, _position._2)
      case (_, dy) =>
        _position = (_position._1, _position._2 + dy.sign)
