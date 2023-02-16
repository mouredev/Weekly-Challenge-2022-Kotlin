# frozen_string_literal: true

require_relative './Challenge40'

TESTS = { input: [1, 2, 3, 4, 0],
          output: [[[1]],
                   [[1], [1, 1]],
                   [[1], [1, 1], [1, 2, 1]],
                   [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1]],
                   'no valid height'] }.freeze

TESTS[:input].each_with_index do |test, index|
  print "\noriginal:", test, "\n"
  Main.new(test).execute
  print "\nexpected:", TESTS[:output][index], "\n"
end

# test private method in class
# pascal_triangle = PascalTriangle.new.send(:cell, 4, 2)
# puts "private pascal_triangle: #{pascal_triangle}"
