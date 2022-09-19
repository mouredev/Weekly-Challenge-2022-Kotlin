# frozen_string_literal: true

require_relative './Challenge38'

TESTS = { input: %w[00010101 1111 0000 10100101 00000001],
          output: [21, 15, 0, 165, 1] }.freeze

TESTS[:input].each_with_index do |test, index|
  puts "\norigina: #{test}"
  puts binary_to_decimal(test)
  puts "expected: #{TESTS[:output][index]}"
end
