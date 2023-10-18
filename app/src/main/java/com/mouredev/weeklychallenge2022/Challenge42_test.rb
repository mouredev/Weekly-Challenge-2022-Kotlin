# frozen_string_literal: true

require_relative './Challenge42'

TESTS = {
  input: [
    '-10.1 °C',
    '-10°C',
    '20 °F',
    '20.45°F',
    '0 °C',
    '-0°C',
    '-234 °F',
    '-234.7638°F',
    '125',
    '-234.sdf.23467 °F',
    '-234°F687234F'
  ],
  output: [
    { temp: 13.82, units: '°F' },
    { temp: 14, units: '°F' },
    { temp: -6.666666667, units: '°C' },
    { temp: -6.416666667, units: '°C' },
    { temp: 32, units: '°F' },
    { temp: 32, units: '°F' },
    { temp: -147.77777777, units: '°C' },
    { temp: -148.20211111, units: '°C' },
    { msg: 'not valid' },
    { msg: 'not valid' },
    { msg: 'not valid' }
  ]
}.freeze

TESTS[:input].each_with_index do |test, index|
  print "\noriginal: ", test, "\n"
  new_temp = temperature_convert(test)
  print new_temp, "\n"
  print 'expected:', TESTS[:output][index], "\n"
end
