# frozen_string_literal: true

require_relative './Challenge30'

TEST = ['first text',
        'word',
        '',
        '       ',
        'some really long text to test the framing application',
        'here  goes       another  example to test the app'].freeze

TEST.each_with_index do |test, index|
  puts "\nTest#{index + 1}"
  puts "input: #{test}"
  framing = Main.new(test)
  framing.execute
end
