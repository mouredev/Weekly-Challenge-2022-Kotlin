
readFile = (input) => {
    let file = input.files[0];

    let reader = new FileReader();
    // const name = file.name.split("").reverse().join("");
    const name = file.name;
    const validaFormato = name.indexOf(".txt");
    if (validaFormato !== -1) {
        reader.readAsText(file);

        reader.onload = function() {
            let lines = reader.result.split('\r\n');
            validarContenido(lines);
        };

        reader.onerror = function() {
            alert(reader.error);
        };
    } else {
        alert("Formato de archivo no valido");
    }
}

validarContenido = (lines) => {
    let contenidoValido = true
    let lineaError = 0
    lines.map((line, index) => {
        if (index % 2 === 0) {
            if(isNaN(parseFloat(line))) {
                contenidoValido = false;
                lineaError = index + 1;
                alert('Secuencia inválida en la línea ' + lineaError);
            }  
        } else if (index % 2 !== 0) {
            if(isNaN(parseFloat(line)) === false) {
                contenidoValido = false;
                lineaError = index + 1;
                alert('Secuencia inválida en la línea ' + lineaError);
            }
        }
    });
    if (contenidoValido) {
        operarContenido(lines);
    }
}

operarContenido = (lines) => {
    let valorActual = 0;
    let operator = null;
    lines.map((line, index) => {
        if (index === 0) {
            valorActual = parseFloat(line);
        } else {
            if (index % 2 !== 0) {
                operator = line;
            } else {
                valorNuevo = parseFloat(line);
                valorActual = eval(`${valorActual} ${operator} ${valorNuevo}`);
            }
        }
    });
    alert("El resultado es: " + valorActual);
}