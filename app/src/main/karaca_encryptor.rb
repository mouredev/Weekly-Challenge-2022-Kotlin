class KaracaEncryptor
  REPLACERS = {
    'a' => '0',
    'e' => '1',
    'i' => '2',
    'o' => '2',
    'u' => '3'
  }.freeze

  TEXT_TO_APPEND = 'aca'.freeze

  # KaracaEncryptor.encrypt('apple') returns "1lpp0aca"
  def self.encrypt(word)
    reversed_word = word.strip.downcase.reverse

    REPLACERS.each do |vowel, replacer|
      reversed_word.gsub!(vowel, replacer)
    end

    reversed_word.concat(TEXT_TO_APPEND)
  end
end
