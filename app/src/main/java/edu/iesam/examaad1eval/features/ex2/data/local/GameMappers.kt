package edu.iesam.examaad1eval.features.ex2.data.local

import edu.iesam.examaad1eval.features.ex2.domain.Game

fun Game.toEntity(): GameEntity {
    return GameEntity(this.id, this.title, this.player)
}

fun GameEntity.toDomain(): Game {
    return Game(this.id, this.title, this.player)
}