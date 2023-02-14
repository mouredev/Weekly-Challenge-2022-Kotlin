# frozen_string_literal: true

#
# Code available in Challenge41.rb
# run: ruby Challenge41_test.rb
#

require_relative './Challenge41'

TESTS = { input: [['1', '2.0', ''],
                  ['', '2', '3'],
                  ['1.2', '', '3.44'],
                  ['', '', '3'],
                  %w[1 2 3],
                  ['1a', '', '3'],
                  ['1.0', 'ala', '']],
          output: [{ var: 'resistance', val: 0.5 },
                   { var: 'voltage', val: 6.0 },
                   { var: 'current', val: 0.35 },
                   'Invalid values',
                   'Invalid values',
                   'Invalid values',
                   'Invalid values'] }.freeze

TESTS[:input].each_with_index do |test, index|
  print "\noriginal: ", test, "\n"
  ohm = Main.new(test).execute
  puts ohm
  print 'expected: ', TESTS[:output][index], "\n"
end
