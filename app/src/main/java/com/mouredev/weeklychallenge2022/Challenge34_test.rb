# Instrucciones de ejecución disponible en Challenge34.rb

# frozen_string_literal: true

require_relative './Challenge34'

tests = { input: [[1, 2, 3, 6, 8, 10],
                  [2, 3, 6, 10],
                  [10, 20],
                  [5, 4, 2, 1],
                  %w[1 a b z],
                  [],
                  5],
          output: [[4, 5, 7, 9],
                   [4, 5, 7, 8, 9],
                   [11, 12, 13, 14, 15, 16, 17, 18, 19],
                   'Not correct input',
                   'Not correct input',
                   'Not correct input',
                   'Not correct input'] }

tests[:input].each_with_index do |test, index|
  input_array = Main.new(test)
  puts "original: #{test}"
  print input_array.execute
  puts "\nexpected: #{tests[:output][index]}\n\n"
end
