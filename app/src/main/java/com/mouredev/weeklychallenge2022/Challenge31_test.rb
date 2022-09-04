# frozen_string_literal: true

require_relative './Challenge31'

test = { input: [4, 20, 1800, 1900, 2100, 2200, 2300, 2500, 2000, 2400] }

test[:input].each do |year|
  puts "Year input: #{year}"
  year_to_test = Main.new(year)
  puts year_to_test.execute
end
