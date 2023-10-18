// Enunciado: Este es un reto especial por Halloween.
//  * Deberemos crear un programa al que le indiquemos si queremos realizar "Truco o Trato" y
//  * un listado (array) de personas con las siguientes propiedades:
//  * - Nombre de la niña o niño
//  * - Edad
//  * - Altura en centímetros
//  *
//  * Si las personas han pedido truco, el programa retornará sustos (aleatorios)
//  * siguiendo estos criterios:
//  * - Un susto por cada 2 letras del nombre por persona
//  * - Dos sustos por cada edad que sea un número par
//  * - Tres sustos por cada 100 cm de altura entre todas las personas
//  * - Sustos: 🎃 👻 💀 🕷 🕸 🦇
//  *
//  * Si las personas han pedido trato, el programa retornará dulces (aleatorios)
//  * siguiendo estos criterios:
//  * - Un dulce por cada letra de nombre
//  * - Un dulce por cada 3 años cumplidos hasta un máximo de 10 años por persona
//  * - Dos dulces por cada 50 cm de altura hasta un máximo de 150 cm por persona
//  * - Dulces: 🍰 🍬 🍡 🍭 🍪 🍫 🧁 🍩

type Persona = {
  nombre: string;
  edad: number;
  altura: number;
};

type Choice = "truco" | "trato";
type Susto = "🎃" | "👻" | "💀" | "🕷" | "🕸" | "🦇";
type Dulce = "🍰" | "🍬" | "🍡" | "🍭" | "🍪" | "🍫" | "🧁" | "🍩";

const personas: Persona[] = [
  {
    nombre: "Lucas",
    edad: 11,
    altura: 150,
  },
  {
    nombre: "Azul",
    edad: 7,
    altura: 110,
  },
  {
    nombre: "Camila",
    edad: 9,
    altura: 133,
  },
  {
    nombre: "Mateo",
    edad: 4,
    altura: 90,
  },
];

const getDulcesAleatorios = (cantidad: number) => {
  const dulces: Dulce[] = ["🍰", "🍬", "🍡", "🍭", "🍪", "🍫", "🧁", "🍩"];
  const dulcesAleatorios: Dulce[] = [];

  for (let i = 0; i < Math.floor(cantidad); i++) {
    dulcesAleatorios.push(dulces[Math.floor(Math.random() * dulces.length)]);
  }

  return dulcesAleatorios;
};

const getSustosAleatorios = (cantidad: number): Susto[] => {
  const sustos: Susto[] = ["🎃", "👻", "💀", "🕷", "🕸", "🦇"];
  const sustosAleatorios: Susto[] = [];

  for (let i = 0; i < Math.floor(cantidad); i++) {
    sustosAleatorios.push(sustos[Math.floor(Math.random() * sustos.length)]);
  }

  return sustosAleatorios;
};

const getSustosDe = (persona: Persona): Susto[] => {
  let cantidadSustos = 0;

  cantidadSustos += Math.floor(persona.nombre.length / 2);
  if (!(persona.edad % 2)) cantidadSustos += 2;

  return getSustosAleatorios(cantidadSustos);
};

const getDulcesDe = (persona: Persona): Dulce[] => {
  let cantidadDulces = 0;

  cantidadDulces += persona.nombre.length;

  cantidadDulces += persona.edad < 10 ? Math.floor(persona.edad / 3) : 3;

  cantidadDulces +=
    persona.altura <= 150 ? Math.floor(persona.altura / 50) * 2 : 6;

  return getDulcesAleatorios(cantidadDulces);
};

type ReduceSusto = {
  porPersona: Susto[];
  acumuladoAltura: number;
};

const trucoTrato = (eleccion: Choice, personas: Persona[]) => {
  if (eleccion === "truco") {
    const datosSustos: ReduceSusto = personas.reduce<ReduceSusto>(
      (sustos, persona) => {
        sustos.porPersona.push(...getSustosDe(persona));
        sustos.acumuladoAltura += persona.altura;

        return sustos;
      },
      { porPersona: [], acumuladoAltura: 0 }
    );

    return datosSustos["porPersona"].concat(
      getSustosAleatorios(datosSustos["acumuladoAltura"] / 100)
    );
  } else if (eleccion === "trato") {
    return personas.reduce<Dulce[]>((dulces, persona) => {
      dulces.push(...getDulcesDe(persona));

      return dulces;
    }, []);
  }

  return 'Opcion invalida, porfavor utiliza "trato" o "truco"';
};

console.log("Truco: " + trucoTrato("truco", personas));
console.log("Trato: " + trucoTrato("trato", personas));
