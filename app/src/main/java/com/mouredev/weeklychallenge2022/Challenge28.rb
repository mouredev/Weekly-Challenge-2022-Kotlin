#
# Reto #28
# MÁQUINA EXPENDEDORA
# Fecha publicación enunciado: 11/07/22
# Fecha publicación resolución: 18/07/22
# Dificultad: MEDIA
#
# Enunciado: Simula el funcionamiento de una máquina expendedora creando una operación
# que reciba dinero (array de monedas) y un número que indique la selección del producto.
# - El programa retornará el nombre del producto y un array con el dinero de vuelta (con el menor
#   número de monedas).
# - Si el dinero es insuficiente o el número de producto no existe, deberá indicarse con un mensaje
#   y retornar todas las monedas.
# - Si no hay dinero de vuelta, el array se retornará vacío.
# - Para que resulte más simple, trabajaremos en céntimos con monedas de 5, 10, 50, 100 y 200.
# - Debemos controlar que las monedas enviadas estén dentro de las soportadas.
#
# Información adicional:
# - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" 
#   para preguntas, dudas o prestar ayuda a la comunidad.
# - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
# - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
# - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
#

class Main
  def initialize(options = {})
    @pay = options['payment']
    @id = options['product_id']
  end

  def execute
    vending_machine = VendingMachine.new(@pay, @id)
    vending_machine.sale
  end
end

class VendingMachine
  PRODUCTS = { 'A01' => { 'name' => 'Galletas Oreo', 'price' => 70 },
                'A02' => { 'name' => 'Patatas Lay ', 'price' => 120 },
                'A03' => { 'name' => 'Mani salado Lay', 'price' => 40 },
                'A04' => { 'name' => 'Refresco Chicha morada', 'price' => 100 }
              }
  CHANGE = [200, 100, 50, 10, 5]
  MESSAGES = { 'err' => { '404' => 'Producto no disponible',
                        '400' => 'Producto no existente',
                        '402' => 'Pago incompleto' } }

  def initialize(pay, id)
    @payment = pay
    @product_id = id
  end

  def sale
    response = {}
    clean_payment = check_payment(@payment)
    dirty_payment = correct_change(@payment)
    if PRODUCTS.keys.include? @product_id
      product_price = PRODUCTS[@product_id]['price']
      if product_price <= clean_payment.sum
        response['msg'] = PRODUCTS[@product_id]['name']
        response['change'] = return_change(clean_payment.sum - product_price)
      else
        response['msg'] = MESSAGES['err']['402']
        response['change'] = clean_payment
      end
    else
      response['msg'] = MESSAGES['err']['400']
      response['change'] = clean_payment
    end
    response['change'] += dirty_payment
    response
  end

  private

  def check_payment user_payment
    (user_payment - correct_change(user_payment))
  end

  def correct_change user_payment
    user_payment - CHANGE
  end

  def return_change money_change
    change = []
    rest = money_change
    unless money_change <= 0
      CHANGE.each do |c|
        if c <= rest
          quotient = rest / c
          rest = rest % c
          quotient.times { |_| change << c }
        end
        break if rest == 0
      end
    end
    change
  end
end
