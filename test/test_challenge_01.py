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

    def test_no_anagrama(self):
        """Textos que no son anagramas"""
        self.assertFalse(anagrama("abcde", "aaa"))
        self.assertFalse(anagrama("abcdeae", "edcba"))
        self.assertFalse(anagrama("ab", "abc"))
        self.assertFalse(anagrama("aaa", "acb"))

    def test_si_anagrama(self):
        """Textos que sí son anagramas"""
        self.assertTrue(anagrama("abcde", "edcba"))
        self.assertTrue(anagrama("abcdeae", "eedcbaa"))


if __name__ == "__main__":
    unittest.main()
