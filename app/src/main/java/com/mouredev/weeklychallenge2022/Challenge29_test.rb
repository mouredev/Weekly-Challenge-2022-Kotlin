# Challenge29 - Ordering list
#
# Execute
# ruby Challenge29_test.rb
#
# Requirements
# ruby v 2.7.3
#

require_relative './Challenge29.rb'

test = { correct: { input: [{ list: [4,6,1,6,2,86,-2], order: 'ASC'},
                            { list: [4,6,1,6,2,86,-2], order: 'DESC'},
                            { list: ['A', 'Z', 'P', -4, 5, 10], order: 'ASC' }],
                    output: [{ list: [-2,1,2,4,6,6,86], msg: 'Ok' },
                            { list: [86,6,6,4,2,1,-2], msg: 'Ok' },
                            { list: [-4,5,10], msg: 'Ok' },
                            { list: [], msg: 'Lista sin números'}] },
        incorrect: { input: [{ list: [], order: 'ASC' },
                            { list: [1,6,78,2], order: 'DSC' },
                            { list: ['H', 'C', 'q', 'k'], order: 'DESC' },
                            { list: ['1', 'A', '10', 'B'], order: 'ASC' }],
                    output: [{ list: [], msg: 'Lista sin números' },
                            { list: [], msg: 'Comando no apropiado' },
                            { list: [], msg: 'Lista sin números' },
                            { list: [], msg: 'Lista sin números' }] } }

puts "Pruebas correctas"
puts "Lista orden ascendente"
# list1 = test[:correct][:input][0][:list]
# order1 = test[:correct][:input][0][:order]
# puts "list1: #{list1} order1: #{order1}"
puts "input: #{test[:correct][:input][0]}"
puts "output: #{test[:correct][:output][0]}"
list_sort = Main.new(test[:correct][:input][0])
puts list_sort.execute

puts "\nLista orden descendente"
# list2 = test[:correct][:input][1][:list]
# order2 = test[:correct][:input][1][:order]
# puts "list2: #{list2} order2: #{order2}"
puts "input: #{test[:correct][:input][1]}"
puts "output: #{test[:correct][:output][1]}"
list_sort = Main.new(test[:correct][:input][1])
puts list_sort.execute

puts "\nLista mezclada caracteres y números"
# list3 = test[:correct][:input][2][:list]
# order3 = test[:correct][:input][2][:order]
# puts "list3: #{list3} order3: #{order3}"
puts "input: #{test[:correct][:input][2]}"
puts "output: #{test[:correct][:output][2]}"
list_sort = Main.new(test[:correct][:input][2])
puts list_sort.execute

puts "\nPruebas incorrectas"
puts "Lista vacia"
# list1 = test[:incorrect][:input][0][:list]
# order1 = test[:incorrect][:input][0][:order]
# puts "list1: #{list1} order1: #{order1}"
puts "input: #{test[:incorrect][:input][0]}"
puts "output: #{test[:incorrect][:output][0]}"
list_sort = Main.new(test[:incorrect][:input][0])
puts list_sort.execute

puts "\nOrden no definido"
# list2 = test[:incorrect][:input][1][:list]
# order2 = test[:incorrect][:input][1][:order]
# puts "list2: #{list2} order2: #{order2}"
puts "input: #{test[:incorrect][:input][1]}"
puts "output: #{test[:incorrect][:output][1]}"
list_sort = Main.new(test[:incorrect][:input][1])
puts list_sort.execute

puts "\nLista solo con caracteres"
# list3 = test[:incorrect][:input][2][:list]
# order3 = test[:incorrect][:input][2][:order]
# puts "list3: #{list3} order3: #{order3}"
puts "input: #{test[:incorrect][:input][2]}"
puts "output: #{test[:incorrect][:output][2]}"
list_sort = Main.new(test[:incorrect][:input][2])
puts list_sort.execute

puts "\nLista solo con caracteres"
# list4 = test[:incorrect][:input][3][:list]
# order4 = test[:incorrect][:input][3][:order]
# puts "list4: #{list4} order4: #{order4}"
puts "input: #{test[:incorrect][:input][3]}"
puts "output: #{test[:incorrect][:output][3]}"
list_sort = Main.new(test[:incorrect][:input][3])
puts list_sort.execute
