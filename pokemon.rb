# frozen_string_literal: false

# provides methods to do battles between 2 pokemon
class PokemonBattle
  BASE_DAMAGE = 50

  # chart at https://pokemondb.net/type
  EFFECTIVENESS_CHART = {
    :fire => {
      :fire => 0.5,
      :water => 0.5,
      :electric => 1,
      :grass => 2
    },
    :water => {
      :fire => 2,
      :water => 0.5,
      :electric => 1,
      :grass => 0.5
    },
    :electric => {
      :fire => 1,
      :water => 2,
      :electric => 0.5,
      :grass => 0.5
    },
    :grass => {
      :fire => 0.5,
      :water => 2,
      :electric => 1,
      :grass => 0.5
    }
  }

  def effectiveness(attacking_type, defending_type)
    EFFECTIVENESS_CHART[attacking_type][defending_type]
  end

  def calculate_damage(attacking_type, attacking_attack, defending_type, defending_attack)
    # BASE_DAMAGE * (attack/defense) * effectiveness
    BASE_DAMAGE * (attacking_attack / defending_attack) * effectiveness(attacking_type, defending_type)
  end
end
