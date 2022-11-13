#include <iostream>
using namespace std;

int waterAmount( int ( &blocks )[ 6 ], int );
void calculateWater( int ( &waters )[ 6 ], int ( &blocks )[ 6 ] );
int getMaxNumber( int ( &blocks )[ 6 ] );
void arrayResult( int ( &blocks )[ 6 ], int ( &waters )[ 6 ],
                  int ( &result )[ 6 ][ 6 ] );
void printResult( int ( &result )[ 6 ][ 6 ] );
/*cpp doesn't seem to allow arrays with non-constant values ​​in most cases.
That's why I don't use it
int lenghtArray  = 6;
*/
string blockIcon = "⏹ ";
string waterIcon = "💧";
string voidIcon  = "  ";              // 💭
int block = 0, water = 1, hole = -1;  // Just to make sense of each value

int main( ) {
  int blocks[ 6 ] = { 4, 0, 3, 6, 1, 3 };
  int waters[ 6 ] = { 0, 0, 0, 0, 0, 0 };
  int height      = getMaxNumber( blocks );
  int result[ 6 ][ 6 ];
  calculateWater( waters, blocks );
  arrayResult( blocks, waters, result );
  printResult( result );
}

void calculateWater( int ( &waters )[ 6 ], int ( &blocks )[ 6 ] ) {
  int level = 1;
  int water = waterAmount( blocks, level );
  while( water > 0 ) {   // I store the water in the holes
    bool isVoid = true;  // While there is not column, no refill nothing
    for( int i = 0; i < 6 && water != 0; i++ ) {
      if( blocks[ i ] >= level && isVoid )
        isVoid = ! isVoid;                     // A column is found
      if( blocks[ i ] < level && ! isVoid ) {  // There is a hole and can refill
        waters[ i ] = waters[ i ] + 1;
        if( blocks[ i + 1 ] >= level ) water--;
      }
    }
    level++;
    water = waterAmount( blocks, level );
  }
}

int waterAmount( int ( &blocks )[ 6 ], int level ) {
  int ocurrences = 0;
  for( int i = 0; i < 6; i++ ) {
    if( blocks[ i ] >= level ) ocurrences++;
  }
  return ocurrences - 1;
  //-1 because is the quantity of holes between the columns
}

int getMaxNumber( int ( &blocks )[ 6 ] ) {
  int maxNumber = 0;
  for( int i = 0; i < 6; i++ ) {
    if( blocks[ i ] > maxNumber ) maxNumber = blocks[ i ];
  }
  return maxNumber;
}

void arrayResult( int ( &blocks )[ 6 ], int ( &waters )[ 6 ],
                  int ( &result )[ 6 ][ 6 ] ) {
  int height = 5;                                 // Start from 0
  for( int column = 5; column >= 0; column-- ) {  // From below to above
    for( int row = 0; row < 6; row++ ) {          // Left to right
      if( blocks[ row ] > height - column ) result[ column ][ row ] = block;
      else if( blocks[ row ] + waters[ row ] > height - column )
        result[ column ][ row ] = water;
      else
        result[ column ][ row ] = hole;
    }
  }
}

void printResult( int ( &result )[ 6 ][ 6 ] ) {
  for( int i = 0; i < 6; i++ ) {
    for( int j = 0; j < 6; j++ ) {
      if( result[ i ][ j ] == hole ) cout << voidIcon;
      else if( result[ i ][ j ] == block )
        cout << blockIcon;
      else
        cout << waterIcon;
    }
    cout << endl;
  }
}

/*
  other proven cases
   int blocks[ 6 ] = { 6, 0, 0, 0, 0, 6 };
   int blocks[ 6 ] = { 6, 0, 0, 0, 0, 0 };
   int blocks[ 6 ] = { 0, 0, 3, 0, 2, 0 };
   int blocks[ 6 ] = { 0, 1, 0, 1, 0, 5 };
   int blocks[ 6 ] = { 1, 0, 1, 0, 5, 0 };
*/