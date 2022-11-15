# frozen_string_literal: true

gem 'minitest', '~> 5.4'
require 'minitest/autorun'
require 'minitest/pride'
require_relative './Challenge46'

# class for testing
class RobotTest < Minitest::Test
  def test_movement
    input = [10, 5, -2]
    expected = { x: -5, y: 12 }
    assert_equal expected, Robot.new.robot_position(input)
  end

  def test_zero_movement
    input = [0, 0, 0, 0, 0]
    expected = { x: 0, y: 0 }
    assert_equal expected, Robot.new.robot_position(input)
  end

  def test_initial_position
    input = [10, 10, 10, 10]
    expected = { x: 0, y: 0 }
    assert_equal expected, Robot.new.robot_position(input)
  end

  def test_only_vertical_movement
    input = [5, 10, -5, 10, 5]
    expected = { x: 0, y: 15 }
    assert_equal expected, Robot.new.robot_position(input)
  end

  def test_only_horizontal_movement
    input = [10, -5, 10, 5, 10, -5, 10]
    expected = { x: 15, y: 0 }
    assert_equal expected, Robot.new.robot_position(input)
  end

  def test_empty_list
    input = []
    expected = { x: 0, y: 0 }
    assert_equal expected, Robot.new.robot_position(input)
  end
end
