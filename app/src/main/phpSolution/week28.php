<?php

//Reto 28 de la máquina expendedora

//Datos de prueba de productos
class Producto {
    public $nombre;
    public $precio;
    public $codigo;

    public function __construct($nombre, $precio, $codigo){
        $this->nombre = $nombre;
        $this->precio = $precio;
        $this->codigo = $codigo;
    }
}

$productos = [
    new Producto('nombre1',155,'P1'),
    new Producto('nombre2',60,'P2'),
    new Producto('nombre3',100,'P3'),
    new Producto('nombre4',215,'P4'),
];

//Variables de entrada del problema
$arrayMonedas = ['5' => 0, '10' => 0, '50' => 0, '100' => 0, '200' => 0];
$codigoProducto = '';

$respuesta = procesarPedido($arrayMonedas, $codigoProducto,$productos);

if(!$respuesta['resultado']){
    echo 'Ha ocurrido un error. '.$respuesta['mensaje'].PHP_EOL;
}else{
    echo 'Todo ha ido correctamente.'.PHP_EOL.'Producto: '.$respuesta['mensaje'].PHP_EOL;
}

devolverDinero($respuesta['monedas']);

function procesarPedido($arrayMonedas, $codigoProducto, $productos){

    if (!monedasValidas($arrayMonedas)){
        return ['mensaje' => 'Ha introducido monedas no válidas','monedas' => $arrayMonedas, 'resultado' => false];
    }

    $producto = buscaProducto($codigoProducto,$productos);

    if (is_null($producto)){
        return ['mensaje' => 'No existe el producto','monedas' => $arrayMonedas, 'resultado' => false];
    }

    $totalDinero = totalDinero($arrayMonedas);

    echo 'Importe introducido: '.$totalDinero.PHP_EOL;

    if(!esSuficiente($totalDinero,$producto)){
         return ['mensaje' => 'Cantidad insuficiente','monedas' => $arrayMonedas, 'resultado' => false];
    }

    $vuelta = calcularVuelta($producto->precio,$totalDinero);

    return ['mensaje' => $producto->nombre, 'monedas' =>$vuelta, 'resultado' => true];
}

function totalDinero($arrayMonedas){
   
    $total = 0;
    foreach($arrayMonedas as $key => $value){
        $total += $key*$value;
    }
    return $total;
}

function buscaProducto($codigoProducto,$productos){ 
    
    $producto = array_filter($productos, function($value) use ($codigoProducto){
        return $codigoProducto == $value->codigo;
    });

    if(empty($producto)){
        return null;
    }else{
        return array_shift($producto);
    }
}

function esSuficiente($cantidad,$producto){
    
    $precioProducto = $producto->precio;
    
    if($cantidad >= $precioProducto){
        return true;
    }else{
        return false;
    }
}

function calcularVuelta($precio,$total){
    $arrayMonedas = ['5' => 0, '10' => 0, '50' => 0, '100' => 0, '200' => 0];
    $diferencia = $total-$precio;

    echo 'Importe de la vuelta: '.$diferencia.PHP_EOL;

    $tiposMonedas = array_keys($arrayMonedas);
    rsort($tiposMonedas);

    foreach($tiposMonedas as $tipo){
        while($diferencia >= $tipo){
            $diferencia -= $tipo;
            $arrayMonedas[$tipo]++; 
        }
    }
    return $arrayMonedas;
}

function monedasValidas($arrayMonedas){
    $tipoMonedas = array_keys($arrayMonedas);
    $arrayFiltrados = array_filter($tipoMonedas, function($value){
        return !in_array($value,['5','10','50','100','200']);
    });

    if(empty($arrayFiltrados)){
        return true;
    }
    return false;
}

function devolverDinero($arrayMonedas){
    $devolucion = false;
    foreach($arrayMonedas as $key=>$value){
        if($value > 0){
            $devolucion = true;
            $plural = '';
            if($value > 1){
                $plural = 's';
            }
            echo 'Devolviendo '.$value.' moneda'.$plural.' de '.$key.PHP_EOL;
        }
    }
    if(!$devolucion){
        echo 'Importe exacto';
    }
}


