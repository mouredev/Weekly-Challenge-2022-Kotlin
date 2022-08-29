#!/usr/bin/env python3

def theLostNumbers(inputList):
	#Validity Check
	if type(inputList) != list:
		print("Datos de ingreso no es un Array")
		return "Datos de ingreso no es un Array"
	if all(type(elem) is int for elem in inputList) == False:
		print("Datos de ingreso no son numéricos")
		return "Datos de ingreso no son numéricos"

	#Sorting the list just in case
	inputList.sort()
	fullList = list(range(inputList[0],inputList[-1]+1))
	
	#A wild missingNo appeared!...  ;)
	missingNo = list(set(fullList).difference(set(inputList))) 
	print(missingNo)
	return missingNo




theLostNumbers([0,1,8,10,10,14])

if __name__ == '__main__':
    main()