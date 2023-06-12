# frozen_string_literal: true

gem 'minitest', '~> 5.4'
require 'minitest/autorun'
require 'minitest/pride'
require_relative './Challenge45'

# class for testing
class WaterContainerTest < Minitest::Test
  def test_no_water_contained
    input = [1, 2, 3, 4, 3, 2, 1]
    expected = 0
    assert_equal expected, WaterContainer.new.calculate_saved_water(input)
  end

  def test_max_water_contained
    input = [4, 0, 0, 0, 4]
    expected = 12
    assert_equal expected, WaterContainer.new.calculate_saved_water(input)
  end

  def test_some_water_contained
    input = [4, 0, 3, 6, 1, 3]
    expected = 7
    assert_equal expected, WaterContainer.new.calculate_saved_water(input)
  end

  def test_container_without_walls
    input = [0, 0, 0, 0, 0, 0, 0]
    expected = 0
    assert_equal expected, WaterContainer.new.calculate_saved_water(input)
  end

  def test_no_container
    input = []
    expected = 0
    assert_equal expected, WaterContainer.new.calculate_saved_water(input)
  end

  def test_no_space_for_water
    input = [4, 4, 4, 4, 4, 4, 4]
    expected = 0
    assert_equal expected, WaterContainer.new.calculate_saved_water(input)
  end

  def test_special_case
    input = [0, 1, 2, 1, 0, 1, 0]
    expected = 1
    assert_equal expected, WaterContainer.new.calculate_saved_water(input)
  end

  def test_no_space_for_water2
    input = [4, 4, 4, 6, 4, 4, 4]
    expected = 0
    assert_equal expected, WaterContainer.new.calculate_saved_water(input)
  end
end
