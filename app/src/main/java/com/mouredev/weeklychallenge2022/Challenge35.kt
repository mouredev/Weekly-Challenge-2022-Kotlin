

package com.mouredev.weeklychallenge2022


fun main(){
    println("Elija pokemon de ataque:\n"+ "1) Agua \n"+ "2) Fuego \n"+ "3) Planta \n"+  "4) Electricidad")
    var attack:Int= readLine()!!.toInt()
    println("Elija pokemon de defensa:\n"+ "1) Agua \n"+ "2) Fuego \n"+ "3) Planta \n"+  "4) Electricidad")
    var defending:Int= readLine()!!.toInt()
    print("Danio: "+damageCaused(attack,defending,20,10))
}
private fun damageCaused(tipoPokemonAtacante: Int, tipoPokemonDefensa: Int, attack:Int, defending:Int):Double{
    return 50 * (attack / defending) * attackEffectiveness(tipoPokemonAtacante,tipoPokemonDefensa);
}
private fun attackEffectiveness(attackingPokemon: Int, pokemonDefense: Int):Double{
    var damage=0.0
    //Ataque entre pokemon de agua y otro de agua es 0.5, solo en estos pokemos en otros es variable
    if(attackingPokemon==pokemonDefense){ damage= 0.5}
    if(attackingPokemon==(typeOfPokemon.Water.pokemon) && pokemonDefense==(typeOfPokemon.Fire.pokemon)) {damage= 2.0}
    if(attackingPokemon==(typeOfPokemon.Water.pokemon) && pokemonDefense==(typeOfPokemon.Plant.pokemon)) {damage= 0.5}
    if(attackingPokemon==(typeOfPokemon.Water.pokemon) && pokemonDefense==(typeOfPokemon.Electricity.pokemon)) {damage= 0.0}
    if(attackingPokemon==(typeOfPokemon.Fire.pokemon) && pokemonDefense==(typeOfPokemon.Water.pokemon)) {damage= 0.5}
    if(attackingPokemon==(typeOfPokemon.Fire.pokemon) && pokemonDefense==(typeOfPokemon.Plant.pokemon)){ damage= 2.0}
    if(attackingPokemon==(typeOfPokemon.Fire.pokemon) && pokemonDefense==(typeOfPokemon.Electricity.pokemon)){ damage= 0.0}
    if(attackingPokemon==(typeOfPokemon.Plant.pokemon) && pokemonDefense==(typeOfPokemon.Water.pokemon)) {damage= 2.0}
    if(attackingPokemon==(typeOfPokemon.Plant.pokemon) && pokemonDefense==(typeOfPokemon.Fire.pokemon)) {damage= 0.5}
    if(attackingPokemon==(typeOfPokemon.Plant.pokemon) && pokemonDefense==(typeOfPokemon.Electricity.pokemon)) {damage= 0.0}
    if(attackingPokemon==(typeOfPokemon.Electricity.pokemon) && pokemonDefense==(typeOfPokemon.Water.pokemon)) {damage= 0.0}
    if(attackingPokemon==(typeOfPokemon.Electricity.pokemon) && pokemonDefense==(typeOfPokemon.Fire.pokemon)) {damage= 0.0}
    if(attackingPokemon==(typeOfPokemon.Electricity.pokemon) && pokemonDefense==(typeOfPokemon.Plant.pokemon)) {damage= 0.5}
    return damage
}
enum class typeOfPokemon(val pokemon:Int){
    Water(1), Fire(2), Plant(3),Electricity(4)

}
