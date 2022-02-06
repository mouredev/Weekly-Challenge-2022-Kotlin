#  Reto #5
#  ASPECT RATIO DE UNA IMAGEN
#  Fecha publicación enunciados: 01/02/22
#  Fecha publicación resolución: 07/02/22
#  Dificultad: DIFÍCIL
#
#  Enunciado: Crea un programa que se encargue de calcular y el aspect ratio de una imagen a partir de una url.
#  - Url de ejemplo: https://raw.githubusercontent.com/mouredev/mouredev/master/mouredev_github_profile.png
#  - Por ratio hacemos referencia por ejemplo a los "16:9" de una imagen de 1920*1080px.
#  Información adicional:
#  - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar
#    ayuda la comunidad.
#  - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
#  - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
#  - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.



#       ********************** ALGORITHM **********************
#       To calculate an aspect ratio as W:H, divide your width and
#       your height by their greatest common factor (GCF),
#       and write it as W:H, where W is units of width divided by
#       the GCF and H is units of height divided by the GCF.

import PIL
import urllib.request

# open image
url="https://raw.githubusercontent.com/mouredev/mouredev/master/mouredev_github_profile.png"

# download image in the same working directory
def downloadImage(url):
    filename="image"+".png"
    urllib.request.urlretrieve(url,filename)     

# open image
def openImage(image_downloaded):    
    image = PIL.Image.open("image.png")
    width, heigth = image.size
    return width, heigth

# greatest common factor (GCF or GCD or HCF)
def calculation_GCF(width, height):
    # Conversion to int
    width_int=int(width)
    heigth_int=int(height)     
    #   ------------ ALGORITHM -----------
    #   1. Find all factors of both numbers
    factors_width= [i for i in range(1,width_int+1) if width_int%i==0]
    factors_heigth= [i for i in range(1,heigth_int+1) if heigth_int%i==0]
    print("[factors_width] = ", factors_width)
    print("[factors_heigth] =", factors_heigth)
    #   2. then find the ones that are common to both    
    list_similar=[]
    for item in factors_width:
        if item in factors_heigth:
            list_similar.append(item)
    print("Similar" , list_similar)      
    #   3. then choose the greatest.
    max_list=max(list_similar)
    print("GCF=", max_list)
    return [width_int, heigth_int, max_list]
    
def aspect_ratio(width_int,heigth_int,max_list):
    first=int(width_int/max_list)
    second=int(heigth_int/max_list)   
    
    print("\n ******************************** RUN **********************************")
    print("The ASPECT RATIO of the image of width", width, "px and heigth", heigth, "px is:    ",first,":",second)
    
    
# ---------------------------------- run ---------------------------------- #
image_downloaded=downloadImage(url)
openImage(image_downloaded)
width, heigth = openImage(image_downloaded)
aspect_ratio(*calculation_GCF(width,heigth))      

# -------------------------------------- test ----------------------------------
# width=640
# heigth=480 
# calculation_GCF(width, heigth)  
# aspect_ratio(*calculation_GCF(width,heigth))      

