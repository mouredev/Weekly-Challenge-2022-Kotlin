/*
 * Crea una función que sea capaz de transformar Español al lenguaje básico
 * del universo Star Wars: el "Aurebesh".
 * - Puedes dejar sin transformar los caracteres que no existan en "Aurebesh".
 * - También tiene que ser capaz de traducir en sentido contrario.
 *
 * ¿Lo has conseguido? Nómbrame en twitter.com/mouredev y escríbeme algo en Aurebesh.
 *
 * ¡Que la fuerza os acompañe!
 */

const aurebeshAlphabet = {
    a: 'aurek', b: 'besh', c: 'cresh', d: 'dorn',  e: 'enth',
    f: 'forn',  g: 'grek', h: 'herf',  i: 'isk',   j: 'jenth',
    k: 'krill', l: 'leth', m: 'mern',  n: 'nern',  o: 'osk',
    p: 'peth',  q: 'qek',  r: 'resh',  s: 'senth', t: 'trill',
    u: 'usk',   v: 'vev',  w: 'wesk',  x: 'xesh',  y: 'yirt', z: 'zerek'
}

const reverseAurebeshMap = Object.fromEntries(
    Object.entries(aurebeshAlphabet).map(([key, value]) => [value, key])
);

const translateToAurebesh = ( text ) => {
    return text.toLowerCase().split('').map( char => aurebeshAlphabet[char] || char).join(' ');
}

const translateFromAurebesh = ( text ) => {
    return text.split(' ').map( word => reverseAurebeshMap[word] || word).join('');
}

console.log(translateToAurebesh("Hola")); // "herf osk leth aurek"
console.log(translateFromAurebesh("herf osk leth aurek")); // "hola"