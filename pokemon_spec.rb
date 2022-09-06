require './pokemon'

RSpec.describe 'pokemon damage' do
  it 'creates a PokemonBattle class' do
    pokemon_battle = PokemonBattle.new
    expect(pokemon_battle).to be_kind_of(PokemonBattle)
  end

  it 'responds correctly to effectiveness method' do
    pokemon_battle = PokemonBattle.new
    expect(pokemon_battle).to respond_to(:effectiveness)
  end

  it 'checks whether effectiveness is correctly obtained' do
    pokemon_battle = PokemonBattle.new
    effectiveness = pokemon_battle.effectiveness(:grass, :water)
    expect(effectiveness).to eq(2)
  end

  it 'checks whether grass pokemon attack vs water pokemon is correctly calculated' do
    pokemon_battle = PokemonBattle.new
    damage = pokemon_battle.calculate_damage(:grass, 40, :water, 10)
    expect(damage).to eq(400)
  end

  it 'checks whether fire pokemon attack vs fire pokemon is correctly calculated' do
    pokemon_battle = PokemonBattle.new
    damage = pokemon_battle.calculate_damage(:fire, 30, :fire, 15)
    expect(damage).to eq(50)
  end
end
