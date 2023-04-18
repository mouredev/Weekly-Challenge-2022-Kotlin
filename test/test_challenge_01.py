"""
Pruebas del Reto 01 : Anagramas
"""

import unittest

from python_soluciones.challenge_01 import anagrama

class TestChallenge01(unittest.TestCase):
    """Test de función anagrama"""
    def test_same_string(self):
        """Prueba si son el mismo texto"""
        self.assertFalse(anagrama("texto_igual", "texto_igual"))

    def test_void_string(self):
        """Prueba si algún string es vacío"""
        self.assertFalse(anagrama("", "texto_igual"))
        self.assertFalse(anagrama("texto_igual", ""))
        self.assertFalse(anagrama("", ""))


if __name__ == '__main__':
    unittest.main()
