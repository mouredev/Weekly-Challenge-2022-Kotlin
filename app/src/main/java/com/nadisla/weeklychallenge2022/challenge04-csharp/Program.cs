/*
* Reto #4
* ÁREA DE UN POLÍGONO
* Dificultad: FÁCIL
*
* Enunciado: Crea UNA ÚNICA FUNCIÓN (importante que sólo sea una) que sea capaz de calcular y retornar el área de un polígono.
* - La función recibirá por parámetro sólo UN polígono a la vez.
* - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
* - Imprime el cálculo del área de un polígono de cada tipo.
*

* Challenge #4
* AREA OF A POLYGON
* Difficulty: EASY
*
* Statement: Creates A SINGLE FUNCTION (important that it is only one) that is capable of calculating and returning the area of a polygon.
* - The function will receive only ONE polygon per parameter at a time.
* - The supported polygons will be Triangle, Square and Rectangle.
* - Prints the calculation of the area of a polygon of each type.
*/
Dictionary<string, Dictionary<string, double>> triangle = new Dictionary<string, Dictionary<string, double>>()
{
    {
        "Triangle", new Dictionary<string, double>()
        {
            {"Base", 5.0},
            {"Height", 5.0}
        }
    }
};
Dictionary<string, Dictionary<string, double>> square = new Dictionary<string, Dictionary<string, double>>()
{
    {
        "Square", new Dictionary<string, double>()
        {
            {"Side", 10.0}
        }
    }
};
Dictionary<string, Dictionary<string, double>> rectangle = new Dictionary<string, Dictionary<string, double>>()
{
    {
        "Rectangle", new Dictionary<string, double>()
        {
            {"Length", 26.3}, 
            {"Width", 15.0}
        }
    }
};
void PolygonArea(Dictionary<string, Dictionary<string, double>> polygon)
{
    string polygonType = polygon.Keys.FirstOrDefault()!.ToLower().Trim(), originalType = polygon.Keys.FirstOrDefault()!;
    List<string> acceptedPolygonTypes = new List<string>(){"triangle", "square", "rectangle"};
    bool isTriangle = polygonType == acceptedPolygonTypes[0], isSquare = polygonType == acceptedPolygonTypes[1];
    double area = 0;

    if (!acceptedPolygonTypes.Contains(polygonType)) Console.WriteLine("Sorry, the accepted polygon types are Triangle, Square and Rectangle.");
    else if (isTriangle)
    {
        double triangleBase = polygon[originalType]["Base"];
        double triangleHeight = polygon[originalType]["Height"];
        area = (triangleBase * triangleHeight) / 2;
        Console.WriteLine($"The triangle area is {area}");
    }
    else if (isSquare)
    {
        double side = polygon[originalType]["Side"];
        area = Math.Pow(side, 2);
        Console.WriteLine($"The square area is {area}");
    }
    else
    {
        double length = polygon[originalType]["Length"];
        double width = polygon[originalType]["Width"];
        area = length * width;
        Console.WriteLine($"The rectangle area is {area}");
    }
}
PolygonArea(triangle);
PolygonArea(square);
PolygonArea(rectangle);