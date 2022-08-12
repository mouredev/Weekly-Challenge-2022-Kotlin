# frozen_string_literal: true

# Instrucciones de ejecución disponible en Challenge6.rb

require_relative './Challenge6'

tests = { input: ['Hola mundo', 'Hello world', 'here goes some text to be inverted'],
          output: ['odnum aloH', 'dlrow olleH', 'detrevni eb ot txet emos seog ereh'] }

tests[:input].each_with_index do |test, index|
  puts "\noriginal: #{test}"
  inverted_string = Main.new(test)
  puts "resp: #{inverted_string.execute}"
  puts "expected: #{tests[:output][index]}"
end
