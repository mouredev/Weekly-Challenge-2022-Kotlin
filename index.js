addEventListener('DOMContentLoaded', () => {
    document.querySelector('#formulario').addEventListener('submit', calcularArrays);
});



function teclasPermitidas(e) {   
    var codigo = (e.which) ? e.which : e.keyCode;

    if (codigo >= 48 && codigo <= 57) { // Permite solo numeros
        return true;
    } else if (codigo === 44) { // Permite la ,
        return true;
    } else if (codigo === 127) { // Permite Borrar, es la tecla DEL
        return true;
    } else if (codigo === 13) { // Permite dar Enter
        return true;
    } else { // No permite escribir otra tecla
        return false;
    }
}

function calcularArrays(e) {
    e.preventDefault();

    let captura = document.querySelector('.captura').value;
    captura = captura.split(',');

    let numerosEnteros = JSON.parse(`[${captura}]`);
    numerosEnteros.sort((a, b) => a - b);

    let resultado = [];
    const numeroMayor = numerosEnteros[numerosEnteros.length - 1];
    const numeroMenor = numerosEnteros[0];


    for (let i = numeroMenor; i <= numeroMayor; i++) {

        if (!numerosEnteros.includes(i)) {
            resultado.push(i);
            const salida = document.querySelector('.resultado');
            salida.innerHTML = "<p> " + resultado + "</p>";
            const registro = document.querySelector('.registro')
            registro.innerHTML = "<p>" + numerosEnteros + "</p>";
            document.querySelector('.captura').focus();
            document.querySelector('.captura').value = "";
        }
    }

}
