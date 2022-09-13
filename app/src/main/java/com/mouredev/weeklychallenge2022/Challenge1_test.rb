require_relative './Challenge1.rb'

TEST = { input: { correct: [{ word1: 'amor', word2: 'roma'},
                            { word1: 'mother-in-law', word2: 'hitler woman'},
                            { word1: 'debit card', word2: 'bad credit' }],
                  incorrect: [{ word1: 'some word', word2: 'another word'},
                              { word1: '', word2: '' },
                              { word1: ' ', word2: ' ' }]},
          output: { correct: [{ msg: true },
                              { msg: true },
                              { msg: true }],
                    incorrect: [{ msg: false },
                                { msg: false },
                                { msg: false }]}}

puts "Prueba Anagrama"
puts "Correctos\n"
puts "test1"
puts "input: #{TEST[:input][:correct][0]}"
puts "output: #{TEST[:output][:correct][0]}"
anagram = Main.new(TEST[:input][:correct][0])
puts anagram.execute

puts "\ntest2"
puts "input: #{TEST[:input][:correct][1]}"
puts "output: #{TEST[:output][:correct][1]}"
anagram = Main.new(TEST[:input][:correct][1])
puts anagram.execute

puts "\ntest3"
puts "input: #{TEST[:input][:correct][2]}"
puts "output: #{TEST[:output][:correct][2]}"
anagram = Main.new(TEST[:input][:correct][2])
puts anagram.execute

puts "\nIncorrectos"
puts "test4"
puts "input: #{TEST[:input][:incorrect][0]}"
puts "output: #{TEST[:output][:incorrect][0]}"
anagram = Main.new(TEST[:input][:incorrect][0])
puts anagram.execute

puts "\ntest5"
puts "input: #{TEST[:input][:incorrect][1]}"
puts "output: #{TEST[:output][:incorrect][1]}"
anagram = Main.new(TEST[:input][:incorrect][1])
puts anagram.execute

puts "\ntest6"
puts "input: #{TEST[:input][:incorrect][2]}"
puts "output: #{TEST[:output][:incorrect][2]}"
anagram = Main.new(TEST[:input][:incorrect][2])
puts anagram.execute
