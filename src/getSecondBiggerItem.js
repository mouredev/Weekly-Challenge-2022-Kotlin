const getSecondBiggerItem = (list) => {
  if (list.length < 2) return null

  list.sort()

  return list[list.length -2]
}

export default getSecondBiggerItem
