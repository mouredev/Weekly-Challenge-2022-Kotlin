# frozen_string_literal: true

gem 'minitest', '~> 5.4'
require 'minitest/autorun'
require 'minitest/pride'
require_relative './Challenge44'

# class for testing
class BoomerangTest < Minitest::Test
  def test_find_one_boomerang
    input = [3, 2, 2, 1, 2]
    expected = { nro: 1, boomerangs: [[2, 1, 2]] }
    assert_equal expected, Boomerang.new.find_boomerang(input)
  end

  def test_find_two_boomerangs
    input = [5, 4, 3, 2, 3, 2, 1, 5, 2, 8]
    expected = { nro: 2, boomerangs: [[3, 2, 3], [2, 3, 2]] }
    assert_equal expected, Boomerang.new.find_boomerang(input)
  end

  def test_find_zero_boomerangs
    input = [72, 1, 1, 6, 2, -1, 7]
    expected = { nro: 0, boomerangs: [] }
    assert_equal expected, Boomerang.new.find_boomerang(input)
  end

  def test_find_mixed_boomerang
    input = [1, 5, 3, 2, 3, 2, 5, 4]
    expected = { nro: 2, boomerangs: [[3, 2, 3], [2, 3, 2]] }
    assert_equal expected, Boomerang.new.find_boomerang(input)
  end

  def test_empty_input
    input = []
    expected = { nro: 0, boomerangs: [] }
    assert_equal expected, Boomerang.new.find_boomerang(input)
  end
end
