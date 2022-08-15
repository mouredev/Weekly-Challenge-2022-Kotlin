# frozen_string_literal: true

# Instrucciones de ejecución disponibles en Challenge32.rb

require_relative './Challenge32'

tests = { input: [[3, 36, 23, 61, 12, 23],
                  [82, 1, 5, 12, 3, 3, 4, 4],
                  [78, 23, 8, 8, 9, 10, 12, 1, 0, -1],
                  [1, 2, 3, 4, 5, 6, 7, 9, 8]],
          output: [36, 12, 23, 8] }

tests[:input].each_with_index do |test, index|
  second_biggest = Main.new(test)
  puts "\noriginal: #{test} \nsecond biggest: #{second_biggest.execute} \nexpected: #{tests[:output][index]}"
end
