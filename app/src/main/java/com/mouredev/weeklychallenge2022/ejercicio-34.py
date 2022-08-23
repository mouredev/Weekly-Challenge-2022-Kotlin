def numeros_perdidos(entry):
    length = len(entry) - 1
    model = [item + 1 for item in range(entry[0] - 1, entry.pop(length))]
    model_length = len(model)
    result = []
    sorted_list = sorted(entry)
    if entry != sorted_list:
        raise Exception("List must be SORTED AND without repetitions")

    for i in model[:model_length - 1]:
        vary = entry.count(model[i])
        if vary > 1:
            raise Exception("List must be sorted AND WITHOUT REPETIONS")
        elif model[i-1] not in entry:
            result.append(model[i-1])
        elif model[i-1] in entry:
            pass

    return result


numeros_perdidos([1, 4, 12, 23])
