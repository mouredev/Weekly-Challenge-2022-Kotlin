# frozen_string_literal: true

gem 'minitest', '~> 5.4'
require 'minitest/autorun'
require 'minitest/pride'
require_relative './Challenge48'

# class for testing
class YearTest < Minitest::Test
  def test_valid_date_in_adevent
    input = Time.parse('2022-12-12T12:34:52+01:00')
    result = Year.new.adevent(input)
    expected = { gift: %w[ebooks ecourses games],
                 time_left: { years: 0, months: 0, days: 0, hours: 12, minutes: 25, seconds: 7 } }
    assert_includes(expected[:gift], result[:gift])
    assert_equal expected[:time_left], result[:time_left]
  end

  def test_valid_date_before_adevent
    input = Time.parse('2020-11-12T10:20:32+00:00')
    result = Year.new.adevent(input)
    expected = { time_left: { years: 2, months: 0, days: 18, hours: 12, minutes: 39, seconds: 28 } }
    assert_equal expected[:time_left], result[:time_left]
  end

  def test_valid_date_after_adevent
    input = Time.parse('2022-12-30T17:08:00+00:00')
    result = Year.new.adevent(input)
    expected = { time_left: { years: 0, months: 0, days: 5, hours: 18, minutes: 8, seconds: 1 } }
    assert_equal expected[:time_left], result[:time_left]
  end

  def test_valid_date_in_adevent_other_timezone
    input = Time.parse('2022-12-23T00:34:12-05:00')
    result = Year.new.adevent(input)
    expected = { gift: %w[ebooks ecourses games],
                 time_left: { years: 0, months: 0, days: 0, hours: 18, minutes: 25, seconds: 47 } }
    assert_includes(expected[:gift], result[:gift])
    assert_equal expected[:time_left], result[:time_left]
  end

  def test_valid_date_before_adevent_other_timezone
    input = Time.parse('2010-12-23T00:34:12+01:00')
    result = Year.new.adevent(input)
    expected = { time_left: { years: 11, months: 11, days: 8, hours: 23, minutes: 25, seconds: 48 } }
    assert_equal expected[:time_left], result[:time_left]
  end

  def test_valid_date_after_adevent_other_timezone
    input = Time.parse('2030-12-23T00:34:12+14:00')
    result = Year.new.adevent(input)
    expected = { time_left: { years: 7, months: 11, days: 27, hours: 11, minutes: 34, seconds: 13 } }
    assert_equal expected[:time_left], result[:time_left]
  end
end
