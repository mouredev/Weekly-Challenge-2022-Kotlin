'''
 * Enunciado: Dado un array de números enteros positivos, donde cada uno
 * representa unidades de bloques apilados, debemos calcular cuantas unidades
 * de agua quedarán atrapadas entre ellos.
 *
 * - Ejemplo: Dado el array [4, 0, 3, 6, 1, 3].
 *
 *         ⏹
 *         ⏹
 *   ⏹💧💧⏹
 *   ⏹💧⏹⏹💧⏹
 *   ⏹💧⏹⏹💧⏹
 *   ⏹💧⏹⏹⏹⏹
 *
 *   Representando bloque con ⏹︎ y agua con 💧, quedarán atrapadas 7 unidades
 *   de agua. Suponemos que existe un suelo impermeable en la parte inferior
 *   que retiene el agua.
 '''
class Wall:
	def __init__(self, height, position):
		self.height = height
		self.position = position
class Tank:
	def __init__(self, walls_height):
		walls_number = len(walls_height)
		water_in = 0
		if walls_number > 2:
			y = max(walls_height)
			walls = [Wall(height, position) for position, height in enumerate(walls_height)]
			while y > 0:
				pos = [wall.position for wall in walls if wall.height >= y]
				if len(pos) > 1:
					water_in += sum([pos[i]-pos[i-1]-1 for i in range(1, len(pos))])
				y -= 1
		self.water_in = water_in
# Test cases
walls_heights = ((), (3, 4), (2, 1, 2), (2, 2, 3), (3, 2, 2), (4, 0, 3, 6), (4, 0, 3, 6, 1, 3))
#Test
for walls_height in walls_heights:
	print(f'Tanque {walls_height}')
	print(Tank(walls_height).water_in)