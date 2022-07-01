public class Challenge26 {

    public static void main(String args[]){
        System.out.println(buildGeometry(Geometry.SQUARE,7, ' '));
        System.out.println(buildGeometry(Geometry.SQUARE,5, '+'));
        System.out.println(buildGeometry(Geometry.TRIANGLE,7, ' '));
        System.out.println(buildGeometry(Geometry.TRIANGLE,9, 'o'));
    }

    private static String buildGeometry(Geometry geometry, int sideLength, char charPoint) {
        if(charPoint == ' '){
            charPoint = '*';
        }

        StringBuilder res = new StringBuilder();

        if (sideLength < 1) {
            throw new RuntimeException("The length has to be greater than 1");
        }

        for (int i = 1; i <= sideLength; i++) {
            if (geometry.equals(Geometry.SQUARE)) {
                if(i==1 || i==sideLength){
                    res.append(new String(new char[sideLength]).replace('\0', charPoint)).append('\n');
                }else{
                    res.append(charPoint).append(new String(new char[sideLength-2]).replace('\0', ' ')).append(charPoint).append('\n');
                }
            } else if(geometry.equals(Geometry.TRIANGLE)){
                int sideLengthAdapted = (sideLength*2)-1;

                if(i==1){
                    StringBuilder line = new StringBuilder(String.valueOf(new char[sideLengthAdapted]).replace('\0', ' '));
                    line.setCharAt(sideLengthAdapted/2, charPoint);
                    res.append(line).append('\n');
                }else if(i==sideLength){
                    StringBuilder line = new StringBuilder(String.valueOf(new char[sideLengthAdapted]).replace('\0', ' '));

                    for(int j=1 ; j<=line.toString().length(); j++){
                        if(j%2 != 0){
                            line.setCharAt(j-1, charPoint);
                        }
                    }

                    res.append(line).append('\n');
                }else{
                    StringBuilder line = new StringBuilder(String.valueOf(new char[sideLengthAdapted]).replace('\0', ' '));
                    line.setCharAt(sideLengthAdapted/2 + (i-1), charPoint);
                    line.setCharAt(sideLengthAdapted/2 - (i-1), charPoint);

                    res.append(line).append('\n');
                }
            } else {
                throw new RuntimeException("Geometry " + geometry + " is not defined.");
            }
        }

        return res.toString();
    }

    public enum Geometry{
        TRIANGLE, SQUARE
    }

}
