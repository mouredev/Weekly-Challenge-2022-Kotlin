/*
 * Reto #49
 * EL DETECTOR DE HANDLES
 * Fecha publicación enunciado: 05/11/22
 * Fecha publicación resolución: 12/12/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que sea capaz de detectar y retornar todos los handles de un texto usando solamente Expresiones Regulares.
 * Debes crear una expresión regular para cada caso:
 * - Handle usuario: Los que comienzan por "@"
 * - Handle hashtag: Los que comienzan por "#"
 * - Handle web: Los que comienzan por "www.", "http://", "https://" y finalizan con un dominio (.com, .es...)
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */


function catchHandles(text:string){
    //regular expressions
    const userRegex= new RegExp("^@");
    const hashtagRegex=new RegExp("^#");
    const webRegex=new RegExp("^(https?|http|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]"); 
    
    let handles=[];

    let users:string[]=[];
    let hashtags:string[]=[];
    let webs:string[]=[];

    //split the text
    const newText=text.split(" ");
   
    for(let i=0;i<newText.length;i++){
        
        let substring:string=newText[i];
    
        if(userRegex.test(substring)){
            users.push(substring);
        }
        else if(hashtagRegex.test(substring)){
            hashtags.push(substring);
        }
        else if(webRegex.test(substring)){
            webs.push(substring);
        }
    
    }
    //add values to array
    handles.push(users);
    handles.push(hashtags);
    handles.push(webs);

    //return values
    return handles;

}

function main(){
    const text="Hello @moonbit and @edd you win the #Hackathon2022 of the https://www.freecodecamp.org plattform. Visit the advent calendar on https://adviento.dev";
    
    let handles=catchHandles(text);

    let users:string="";
    let hashtags:string="";
    let webs:string="";

    //print users
    for(let i in handles[0]){
        users+="\n"+handles[0][i];
    }
    console.log("Users founded: "+users);

    //print hashtags
    for(let i in handles[1]){
        hashtags+="\n"+handles[1][i];
    }
    console.log("Hashtags founded: "+hashtags);

    //print webs
    for(let i in handles[2]){
        webs+="\n"+handles[2][i];
    } 
    console.log("Webs founded: "+webs)
}

//run
console.clear();
main();
