# frozen_string_literal: true

gem 'minitest', '~> 5.4'
require 'minitest/autorun'
require 'minitest/pride'
require_relative './Challenge50'

# class for testing
class KaracaTest < Minitest::Test
  def test_encryption
    # skip
    input = { input: 'apple', func: 'encryption' }
    expected = '1lpp0aca'
    assert_equal expected, Karaca.new(input).start
  end

  def test_decryption
    # skip
    input = { input: '0n0n0baca', func: 'decryption' }
    expected = 'banana'
    assert_equal expected, Karaca.new(input).start
  end

  def test_encryption_sentence
    # skip
    input = { input: 'this is a long sentence', func: 'encryption' }
    expected = 's2htaca s2aca 0aca gn3laca 1cn1tn1saca'
    assert_equal expected, Karaca.new(input).start
  end

  def test_decryption_sentence
    # skip
    input = { input: 't0htaca s0waca 0aca gn3laca 1cn1tn1saca', func: 'decryption' }
    expected = 'that was a long sentence'
    assert_equal expected, Karaca.new(input).start
  end

  def test_decryption_not_encrypted
    # skip
    input = { input: 'this is a long sentence', func: 'decryption' }
    expected = 'not encrypted input'
    assert_equal expected, Karaca.new(input).start
  end

  def test_decryption_not_encrypted_by_one
    # skip
    input = { input: 't0htaca s0waca 0 gn3laca 1cn1tn1saca', func: 'decryption' }
    expected = 'not encrypted input'
    assert_equal expected, Karaca.new(input).start
  end
end
