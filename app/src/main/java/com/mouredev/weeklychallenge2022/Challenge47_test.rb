# frozen_string_literal: true

gem 'minitest', '~> 5.4'
require 'minitest/autorun'
require 'minitest/pride'
require_relative './Challenge47'

# class for testing
class VowelTest < Minitest::Test
  def test_normal_sentence
    input = 'The quick brown fox jumps over the lazy dog'
    expected = 'o'
    assert_equal expected, Vowel.new.most_repeated_vowels(input)
  end

  def test_empty_sentence
    input = ''
    expected = ''
    assert_equal expected, Vowel.new.most_repeated_vowels(input)
  end

  def test_no_vowels_sentence
    input = 'th nm f ths src fl'
    expected = ''
    assert_equal expected, Vowel.new.most_repeated_vowels(input)
  end

  def test_same_number_of_vowels
    input = 'a bird up, not he'
    expected = 'a'
    assert_equal expected, Vowel.new.most_repeated_vowels(input)
  end

  def test_uppercase_and_downcase_vowels
    input = 'THE QUICK BROWN FOX JUMPS over the lazy dog'
    expected = 'o'
    assert_equal expected, Vowel.new.most_repeated_vowels(input)
  end

  def test_vowels_with_tilde_and_uppercase
    input = 'AQUÍ habrá una TELEVISIÓN de México y ahí está él a gusto'
    expected = 'a'
    assert_equal expected, Vowel.new.most_repeated_vowels(input)
  end
end
