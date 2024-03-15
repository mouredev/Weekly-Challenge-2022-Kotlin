def isAnagram(word1, anagram):
  word_anagram = ""
  for index in range(len(word1),0,-1):
    word_anagram += word1[index-1]
  
  if word_anagram == anagram:
    return True
  else:
    return False

print(isAnagram("zorra", "arroz"))
print(isAnagram("zorra", "zorra"))
print(isAnagram("valora", "arolav"))