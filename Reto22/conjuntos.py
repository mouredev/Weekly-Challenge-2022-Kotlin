
def main():
    array1 = [1,2,3]
    array2 = [1,2]

    #print(getResult(array1,array2))
    print(getResult(array1,array2,False))    
    

def getResult(myArray1 = [],myArray2=[],commons = True):
    resultArray = []
    if len(myArray1) == 0 and len(myArray2) == 0:
        resultArray = ['Arrays vacíos']
    else:
        if commons:
            returnType ='Los Elementos comunes son'
            resultArray = getDuplicates(myArray1,myArray2)
        else:
            returnType ='Los Elementos No comunes son'
            resultArray = getDuplicates(myArray1,myArray2)
            
            mergedArrays = myArray1+myArray2
            resultArray = [elem for elem in mergedArrays if elem not in resultArray]

    return f"{returnType}: {' '.join([str(elem) for elem in resultArray])}"
    
def getDuplicates(firstArray,secondArray):
    duplicatesArray = []
    for array1Elem in firstArray:
                for array2Elem in secondArray:
                    if array1Elem == array2Elem:
                       duplicatesArray.append(array2Elem)
    return duplicatesArray
        

if __name__ == '__main__':
    main()

