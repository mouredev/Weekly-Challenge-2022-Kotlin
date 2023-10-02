 # Simula el funcionamiento de una máquina expendedora creando una operación
 # que reciba dinero (array de monedas) y un número que indique la selección
 # del producto.
 # - El programa retornará el nombre del producto y un array con el dinero
 #   de vuelta (con el menor número de monedas).
 # - Si el dinero es insuficiente o el número de producto no existe,
 #   deberá indicarse con un mensaje y retornar todas las monedas.
 # - Si no hay dinero de vuelta, el array se retornará vacío.
 # - Para que resulte más simple, trabajaremos en céntimos con monedas
 #   de 5, 10, 50, 100 y 200.
 # - Debemos controlar que las monedas enviadas estén dentro de las soportadas.
 #

$available_coins =[ 5,10,50,100,200 ] 
 def machine(arrayCoins,productId)
arrayCoins.sort


if arrayCoins.any? { |coin| !$available_coins .include? coin }
  puts "Coin unknown" 
  exit
end

case productId
when 1
   costProduct=10
    sumProduct(arrayCoins,costProduct,productId)

when 2
   costProduct=150
    sumProduct(arrayCoins,costProduct,productId)

when 3
   costProduct=60
    sumProduct(arrayCoins,costProduct,productId)
else
  coinsToReturn = arrayCoins 
  puts "This product dont found"
end

 end

 def sumProduct(arrayCoins,costProduct,productId)
   message=""
   sumPrice=0
   coinsToReturn=[]

   arrayCoins.each_with_index do |element, index|
      sumPrice += element
      if sumPrice > costProduct
        remaining = sumPrice-costProduct 
         greater_than_thresold = $available_coins.select { |num| num <= sumPrice-costProduct }.max
        coinsToReturn.fill(greater_than_thresold,coinsToReturn.size,remaining/greater_than_thresold) 

      end

     message = costProduct>sumPrice ?
    "Your bucket is insufficient, here your coins #{arrayCoins}":
    "Your product is #{productId} and your return are these coins #{coinsToReturn}"
   end

   puts message
 end

 
machine([10,50],1) # 50
machine([100,50,10],2) # 10
machine([200],2) # 50
machine([50,50],3) # 10,10,10,10