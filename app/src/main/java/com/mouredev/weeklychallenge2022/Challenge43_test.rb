# frozen_string_literal: true

# testing code with possible input

gem 'minitest', '~> 5.4'
require 'minitest/autorun'
require 'minitest/pride'
require_relative './Challenge43'

# class for testing
class TrickOrTreatTest < Minitest::Test
  def test_trick_person
    input = { option: 'trick', children: [{ name: 'Javier', age: 10, height: 120 }] }
    expected = [8]
    assert_equal expected, TrickOrTreat.new.trick_or_treat(input).map(&:size)
  end

  def test_treat_person
    input = { option: 'treat', children: [{ name: 'Sebastián', age: 12, height: 140 }] }
    expected = [16]
    assert_equal expected, TrickOrTreat.new.trick_or_treat(input).map(&:size)
  end

  def test_many_tricks
    input = { option: 'trick', children: [{ name: 'Sebastián', age: 12, height: 140 },
                                          { name: 'Javier', age: 10, height: 120 }] }
    expected = [9, 8]
    assert_equal expected, TrickOrTreat.new.trick_or_treat(input).map(&:size)
  end

  def test_many_treats
    input = { option: 'treat', children: [{ name: 'Sebastián', age: 12, height: 140 },
                                          { name: 'Javier', age: 10, height: 120 }] }
    expected = [16, 13]
    assert_equal expected, TrickOrTreat.new.trick_or_treat(input).map(&:size)
  end

  def test_treats_extremes
    input = { option: 'treat', children: [{ name: 'Moe', age: 1, height: 80 },
                                          { name: 'Wolfeschlegelsteinhausenbergerdorff', age: 118, height: 272 }] }
    expected = [5, 44]
    assert_equal expected, TrickOrTreat.new.trick_or_treat(input).map(&:size)
  end

  def test_tricks_extremes
    input = { option: 'trick', children: [{ name: 'Moe', age: 1, height: 80 },
                                          { name: 'Wolfeschlegelsteinhausenbergerdorff', age: 118, height: 272 }] }
    expected = [1, 25]
    assert_equal expected, TrickOrTreat.new.trick_or_treat(input).map(&:size)
  end
end
