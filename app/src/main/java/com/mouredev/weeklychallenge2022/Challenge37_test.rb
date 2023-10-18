# frozen_string_literal: true

require_relative './Challenge37'

TESTS = { input: [%w[19 18], %w[19 0], %w[9 5], %w[3 10], %w[6 13], %w[0 19], %w[5 5]],
          output: [{ years: 6, days: 71 },
                   { years: 35, days: 272 },
                   { years: 2, days: 361 },
                   { years: 10, days: 291 },
                   { years: 6, days: 142 },
                   { years: 35, days: 272 },
                   { years: 0, days: 0 }] }

TESTS[:input].each_with_index do |test, index|
  puts "\noriginal: #{test}"
  date_calc = Main.new(test[0], test[1])
  puts date_calc.execute
  puts "expected: #{TESTS[:output][index]}"
end
