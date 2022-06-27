package com.mouredev.weeklychallenge2022

/*
 * Challenge #25
 * By Jose Rodolfo Rojas
 * Rock, Paper, Scissors game
 * @jrodolforojas
 */

const Movements = {
  ROCK: 'R',
  PAPER: 'P',
  SCISSORS: 'S',
}

const winners = {
  	[Movements.PAPER]: Movements.ROCK,
  	[Movements.SCISSORS]: Movements.PAPER,
  	[Movements.ROCK]: Movements.SCISSORS
}

const rockPaperScissorsGame = (game) => {
  let draws = 0
  let player1Wins = 0
  let player2Wins = 0

  game.forEach(play => {
    const player1Movement = play[0]
    const player2Movement = play[1]

    if (player1Movement === player2Movement) {
      draws++
    }
    if (winners[player1Movement] === player2Movement) {
      player1Wins++
    }
    if (winners[player2Movement] === player1Movement) {
      player2Wins++
    }
  })

  if (player1Wins > player2Wins) return 'Player 1'
  if (player2Wins > player1Wins) return 'Player 2'
  return 'Draw'
}

rockPaperScissorsGame([["R","S"], ["S","R"], ["S","S"]]) // Draw
rockPaperScissorsGame([["R","S"], ["P","R"], ["S","S"]]) // Player 1
rockPaperScissorsGame([["R","R"], ["P","S"], ["R","P"]]) // Player 2