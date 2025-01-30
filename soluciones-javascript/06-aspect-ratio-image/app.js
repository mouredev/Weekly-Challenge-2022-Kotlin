/*
 * Crea un programa que se encargue de calcular el aspect ratio de una
 * imagen a partir de una url.
 * - Url de ejemplo:
 *   https://es.vitejs.dev/og-image-announcing-vite3.png
 * - Por ratio hacemos referencia por ejemplo a los "16:9" de una
 *   imagen de 1920*1080px.
 */


const calcularAspectRatio = async (url) => {

    const img = new Image();

    img.src = url;
    
    img.onload = () => {
        const width = img.width;
        const height = img.height;
        
        // Maximo comun divisor
        const mcd = ( a, b ) => b === 0 ? a : mcd( b, a % b );
        
        console.log(mcd(width, height));
        
        const ratioMCD = mcd(width, height); 
        
        console.log(`La resolución de la imagen es ${width}x${height}`);
        console.log(`La relación de aspecto es: ${ width / ratioMCD }:${ height / ratioMCD }`);
        
        
    }
    
    img.onerror = () => {
        console.error('No se pudo cargar la imagen');
    }
    
    return img;

}

const url = "https://cdn.unotv.com/images/2024/03/mazapan-perrito-influencer-143900-1024x576.jpeg"
calcularAspectRatio(url);