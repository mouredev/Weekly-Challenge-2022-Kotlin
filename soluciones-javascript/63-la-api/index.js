/*
 * Llamar a una API es una de las tareas más comunes en programación.
 *
 * Implementa una llamada HTTP a una API (la que tú quieras) y muestra su
 * resultado a través de la terminal. Por ejemplo: Pokémon, Marvel...
 *
 * Aquí tienes un listado de posibles APIs:
 * https://github.com/public-apis/public-apis
 */

const llamadoPokeApi = async(endpoint = "pokemon") => {
    try {
        const response = await fetch(`https://pokeapi.co/api/v2/${endpoint}`);

        if(!response.ok){
            throw new Error(`Response Status: ${response.status}`);
        }

        const json = await response.json();
        console.log(json.results.map(pokemon => pokemon.name));

    } catch (error) {
        console.error("Error en la API:", error)
    }
}

llamadoPokeApi();