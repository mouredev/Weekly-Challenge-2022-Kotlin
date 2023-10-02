 # Crea un programa que dibuje un cuadrado o un triángulo con asteriscos "*".
 # - Indicaremos el tamaño del lado y si la figura a dibujar es una u otra.
 # - EXTRA: ¿Eres capaz de dibujar más figuras?
 # Hora de inicio: 7:26
 # Hora de cierre: 19:53
 # Tiempo transcurrido: 5:00

 def draw_polygon(height,object)
 objectDraw=""

 if object=="square"
    
    for index in 1..height do
        objectDraw<<"*"*height
        objectDraw<<"\n"
    end
 end

 if object=="triangle"
    
    for index in 1..height do
        objectDraw<<" "*( (height-index)/2 )
        objectDraw<<"*"*index
        objectDraw<<" "*((height-index)/2)
        objectDraw<<"\n"
    end
 end

 if object=="diamond"
    
    for index in 1..height do
        objectDraw<<" "*( (height-index)/2 )
        objectDraw<<"*"*index
        objectDraw<<" "*((height-index)/2)
        objectDraw<<"\n"
    end

    for index in height.downto(1) 
        objectDraw<<" "*( (height-index)/2 )
        objectDraw<<"*"*index
        objectDraw<<" "*( (height-index)/2 )
        objectDraw<<"\n"
    end
 end

 return objectDraw
 end

puts draw_polygon(8, "square")
puts draw_polygon(8, "triangle")
puts draw_polygon(8, "diamond")