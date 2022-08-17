def anagram(word1, word2):
    word1_sorted = "".join(sorted(word1))
    word2_sorted = "".join(sorted(word2))
    if word1 == word2:
        print("No es un anagrama")
    elif word1_sorted == word2_sorted:
        print("Es un anagrama")
        
# anagram("hola","hola") -> No es un anagrama
# anagram("roma", "amor") -> Es un anagrama
