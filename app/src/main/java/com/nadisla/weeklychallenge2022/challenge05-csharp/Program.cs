/*
* Reto #5
* ASPECT RATIO DE UNA IMAGEN
* Dificultad: DIFÍCIL
*
* Enunciado: Crea un programa que se encargue de calcular el aspect ratio de una imagen a partir de una url.
* Url de ejemplo: https://wallpaperaccess.com/full/109676.jpg
* Por ratio hacemos referencia por ejemplo a los "16:9" de una imagen de 1920*1080px.

* Challenge #5
* ASPECT RATIO OF AN IMAGE
* Difficulty: DIFFICULT
*
* Statement: Create a program that is responsible for calculating the aspect ratio of an image from a url.
* Example URL: https://wallpaperaccess.com/full/109676.jpg
* By ratio we refer for example to the "16:9" of a 1920*1080px image.
*/
using System.Drawing;
class Program
{
    static async Task Main(string[] args)
    {
        await GetAspectRatio("https://wallpaperaccess.com/full/109676.jpg");
    }

    static async Task GetAspectRatio(string imageUrl)
    {
        HttpClient client = new HttpClient();
        HttpResponseMessage data = await client.GetAsync(imageUrl);
        try
        {
            Stream content = await data.Content.ReadAsStreamAsync();
            Image image = Image.FromStream(content);
            int width = image.Width, height = image.Height, greatestCommonDivisor = GreatestCommonDivisor(width, height);
            string aspectRatio = $"{width / greatestCommonDivisor}:{height / greatestCommonDivisor}";
            Console.WriteLine($"The Aspect Ratio is: {aspectRatio}");
        }
        catch (Exception ex)
        {
            Console.WriteLine(ex.Message.ToString());
        }
    }

    static int GreatestCommonDivisor(int num1, int num2)
    {
        List<int> num1Divisors = new List<int>(), num2Divisors = new List<int>();
        int greatestCommonDivisor = 0;
        for (int div = 1; div <= num1; div++)
        {
            if (num1 % div == 0) num1Divisors.Add(div);
        }
        for (int div = 1; div <= num2; div++)
        {
            if (num2 % div == 0) num2Divisors.Add(div);
        }
        greatestCommonDivisor = num1Divisors.OrderBy(n => n).ToList().Intersect(num2Divisors).Max();
        return greatestCommonDivisor;
    }
}