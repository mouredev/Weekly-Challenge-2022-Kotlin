require_relative './Challenge28.rb'

INPUTS = { 'correct' => [ { 'input' => { 'payment' => [50,10,10],
                                      'product_id' => 'A01' },
                          'output' => { 'msg' => 'Galletas Oreo',
                                      'change' => [] }
                        },
                        { 'input' => { 'payment' => [200],
                                      'product_id' => 'A02' },
                          'output' => { 'msg' => 'Patatas Lay',
                                      'change' => [50,10,10,10] }
                          },
                        { 'input' => { 'payment' => [100,50,10,1,1,1,1,1,1,1,1,1,1,1],
                                      'product_id' => 'A02' },
                          'output' => { 'msg' => 'Patatas Lay',
                                      'change' => [10,10,10,10,1,1,1,1,1,1,1,1,1,1,1] }
                }
                      ],
            'incorrect' => [ { 'input' => { 'payment' => [10,10,10],
                                        'product_id' => 'A03' },
                            'output' => { 'msg' => 'Pago incompleto',
                                        'change' => [10,10,10] }
                          },
                          { 'input' => { 'payment' => [10,10,10,10],
                                        'product_id' => 'A07' },
                            'output' => { 'msg' => 'Producto no existente',
                                        'change' => [10,10,10,10] }
                          },
                          { 'input' => { 'payment' => [1,1,1,1,1,1,1,1,1,1,10,10,5,5],
                                        'product_id' => 'A03' },
                            'output' => { 'msg' => 'Pago incompleto',
                                        'change' => [1,1,1,1,1,1,1,1,1,1,10,10,5,5] }
                          }
                        ]
}

puts "PAGOS CORRECTO"
puts 'Primera prueba: pago sin cambio'
test1 = INPUTS['correct'][0]['input']
puts "INPUTS: #{INPUTS['correct'][0]['input']}"
puts "OUTPUTS: #{INPUTS['correct'][0]['output']}"
vending_machine = Main.new(test1)
puts "result: #{vending_machine.execute}"

puts "\n\nSegunda prueba: pago con cambio"
test2 = INPUTS['correct'][1]['input']
puts "INPUTS: #{INPUTS['correct'][1]['input']}"
puts "OUTPUTS: #{INPUTS['correct'][1]['output']}"
vending_machine = Main.new(test2)
puts "result: #{vending_machine.execute}"

puts "\n\nTercera prueba: pago con cambio, monedas no aceptadas"
test3 = INPUTS['correct'][2]['input']
puts "INPUTS: #{INPUTS['correct'][2]['input']}"
puts "OUTPUTS: #{INPUTS['correct'][2]['output']}"
vending_machine = Main.new(test3)
puts "result: #{vending_machine.execute}"

puts "\n\nPAGOS INCORRECTOS"
puts 'Cuarta prueba: pago incompleto'
test4 = INPUTS['incorrect'][0]['input']
puts "INPUTS: #{INPUTS['incorrect'][0]['input']}"
puts "OUTPUTS: #{INPUTS['incorrect'][0]['output']}"
vending_machine = Main.new(test4)
puts "result: #{vending_machine.execute}"

puts "\n\nQuinta prueba: producto no existente"
test5 = INPUTS['incorrect'][1]['input']
puts "INPUTS: #{INPUTS['incorrect'][1]['input']}"
puts "OUTPUTS: #{INPUTS['incorrect'][1]['output']}"
vending_machine = Main.new(test5)
puts "result: #{vending_machine.execute}"

puts "\n\nSexta prueba: pago incompleto con monedas no disponibles"
test6 = INPUTS['incorrect'][2]['input']
puts "INPUTS: #{INPUTS['incorrect'][2]['input']}"
puts "OUTPUTS: #{INPUTS['incorrect'][2]['output']}"
vending_machine = Main.new(test6)
puts "result: #{vending_machine.execute}"
