# frozen_string_literal: true

require_relative './Challenge4'

test = { input: [['triangle', 10, 10],
                 ['rectangle', 10, 10],
                 ['square', 10],
                 ['rectangle', 5, 5],
                 ['triangle', 10, 5]],
         output: [50, 100, 100, 25, 25] }

test[:input].each do |input|
  puts "input: #{input.inspect}"
  calculate_area = Main.new(*input)
  puts calculate_area.execute
end
