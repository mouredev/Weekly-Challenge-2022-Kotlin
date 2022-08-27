#!/usr/bin/env ruby

def lost_numbers(input_array)

  # input array validations
  if !input_array.all? { |i| i.is_a?(Integer) }
    raise(ArgumentError, "not an integer in array")
  end
  raise(ArgumentError, "repeated elements in array") if input_array != input_array.uniq
  raise(ArgumentError, "unordered array") if input_array != input_array.sort
  return [] if input_array.length < 2

  all_numbers_array = (input_array[0]..input_array[-1]).to_a
  return all_numbers_array - input_array
end