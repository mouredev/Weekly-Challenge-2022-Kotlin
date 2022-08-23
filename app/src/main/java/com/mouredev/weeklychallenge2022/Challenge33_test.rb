# Instrucciones de ejecución disponible en Challenge33.rb

# frozen_string_literal: true

require_relative './Challenge33'

tests = { input: [1924, 1970, 1978, 1910, 1990, 1850, 2060, 10, 60, 1750, 2160, -1, 'test', 0, -246, 4, 1, 2, 3],
          output: [{ animal: 'rat', element: 'wood' },
                   { animal: 'dog', element: 'metal' },
                   { animal: 'horse', element: 'earth' },
                   { animal: 'dog', element: 'metal' },
                   { animal: 'horse', element: 'metal' },
                   { animal: 'dog', element: 'metal' },
                   { animal: 'dragon', element: 'metal' },
                   { animal: 'horse', element: 'metal' },
                   { animal: 'monkey', element: 'metal' },
                   { animal: 'horse', element: 'metal' },
                   { animal: 'monkey', element: 'metal' },
                   { animal: 'monkey', element: 'metal' },
                   { msg: 'test no es un año válido' },
                   { msg: '0 no es un año válido' },
                   { animal: 'rabbit', element: 'wood' },
                   { animal: 'rat', element: 'wood' },
                   { animal: 'rooster', element: 'metal' },
                   { animal: 'dog', element: 'water' },
                   { animal: 'pig', element: 'water' }] }

tests[:input].each_with_index do |test, index|
  chinese_year = Main.new(test)
  year_animal_element = chinese_year.execute
  if year_animal_element[:msg]
    puts "\n#{test} no es un año válido"
  else
    puts "\n#{test}: #{year_animal_element[:animal]} - #{year_animal_element[:element]}"
  end
  puts "expected: #{tests[:output][index]}"
end
