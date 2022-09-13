# frozen_string_literal: true

require_relative './Challenge36'

tests = {
  input: [
    [[0, 10, 20, 30, 40], [40, 30, 20, 10, 0]],
    [[50, 40, 30, 20, 10], [10, 20, 30, 40, 50]],
    [[10, 10], [30]]
  ],
  output: ['Good wins', 'Bad wins', 'Tie']
}

tests[:input].each_with_index do |test, index|
  puts "\noriginal: #{test}"
  middle_earth_battle = Main.new(test)
  puts middle_earth_battle.execute
  puts "expected: #{tests[:output][index]}"
end
