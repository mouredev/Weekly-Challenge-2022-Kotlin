require './lost_numbers.rb'

RSpec.describe 'lost numbers' do

  it 'checks whether an empty array is returned when input array length is less than 2' do
    # Arrange
    input_array = [1]

    # Act
    ouput_array = lost_numbers(input_array)

    # Assert
    expect(ouput_array).to eq([])
  end

  it 'checks whether an exception is returned when there aren''t only integers in input array' do
    input_array = [1, 2, "three"]

    expect {
      lost_numbers(input_array)
    }.to raise_error(ArgumentError, "not an integer in array")
  end

  it 'checks whether an exception is returned when input array is not ordered' do
    input_array = [2, 1]

    expect {
      lost_numbers(input_array)
    }.to raise_error(ArgumentError, "unordered array")
  end

  it 'checks whether it returns the missing numbers from a correct input array' do
    input_array = [-7, 1, 5]

    missing_numbers = lost_numbers(input_array)

    expect(missing_numbers).to eq([-6, -5, -4, -3, -2, -1, 0, 2, 3, 4])
  end

  it 'checks whether an empty array is returned when input array is empty' do
    input_array = []

    ouput_array = lost_numbers(input_array)

    expect(ouput_array).to eq([])
  end

  it 'checks whether an empty array is returned when input array is composed by consecutive numbers' do
    input_array = [1, 2, 3, 4, 5]

    ouput_array = lost_numbers(input_array)

    expect(ouput_array).to eq([])
  end

  it 'checks whether an exception is returned when input array has repeated elements' do
    input_array = [1, 2, 2, 5]

    expect {
      lost_numbers(input_array)
    }.to raise_error(ArgumentError, "repeated elements in array")
  end

end