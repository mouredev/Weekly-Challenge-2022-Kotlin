# frozen_string_literal: true

gem 'minitest', '~> 5.4'
require 'minitest/autorun'
require 'minitest/pride'
require_relative './Challenge49'

# class for testing
class HandleDetectorTest < Minitest::Test
  def test_twitter_id_handle
    # skip
    input = 'this is my Twitter handles @gerbosan and another handle is: @test0n3.'
    expected = ['@gerbosan', '@test0n3']
    assert_equal expected, Text.new.handle_detector(input)
  end

  def test_id_handle
    # skip
    input = 'this is my Twitter handles @gerbosan and my Mastodon handle too: @gerbosan@ruby.social.'
    expected = ['@gerbosan', '@gerbosan@ruby.social']
    assert_equal expected, Text.new.handle_detector(input)
  end

  def test_tag_handle
    # skip
    input = 'the tags I usually use are #ruby, #rails, #rubyonrails and #development.'
    expected = ['#ruby', '#rails', '#rubyonrails', '#development']
    assert_equal expected, Text.new.handle_detector(input)
  end

  def test_www_handle
    # skip
    input = 'the webpages I visit frequently are www.linkedin.com, www.gmail.com, www.wikipedia.com'
    expected = ['www.linkedin.com', 'www.gmail.com', 'www.wikipedia.com']
    assert_equal expected, Text.new.handle_detector(input)
  end

  def test_http_handle
    # skip
    input = 'here some addresses I like http://www.twitter.com, http://www.codeable.la, http://en.wikipedia.org, http://github.com'
    expected = ['http://www.twitter.com', 'http://www.codeable.la', 'http://en.wikipedia.org', 'http://github.com']
    assert_equal expected, Text.new.handle_detector(input)
  end

  def test_https_handle
    # skip
    input = 'some addresses are https://en.wikipedia.org, https://github.com'
    expected = ['https://en.wikipedia.org', 'https://github.com']
    assert_equal expected, Text.new.handle_detector(input)
  end

  def test_mixed_handles
    # skip
    input = 'a mix of handles to check @gerbosan, #ruby, @gerbosan@ruby.social, www.hotmail.com, #rails,
              https://gob.pe, wrong inputs @@gerbosan, ##handles, ww3.st.ec, 215.128.103.9'
    expected = ['@gerbosan', '#ruby', '@gerbosan@ruby.social', 'www.hotmail.com', '#rails', 'https://gob.pe']
    assert_equal expected, Text.new.handle_detector(input)
  end

  def test_empty_test
    # skip
    input = ''
    expected = []
    assert_equal expected, Text.new.handle_detector(input)
  end

  def test_text_without_handles
    # skip
    input = 'here we add some text, but without handles.'
    expected = []
    assert_equal expected, Text.new.handle_detector(input)
  end
end
