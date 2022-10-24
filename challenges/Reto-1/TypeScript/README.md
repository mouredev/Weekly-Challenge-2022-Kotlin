# Notas

En la función `transformWord`, se utiliza `replaceAll(' ', '')`, esta característica funciona porque en `tsconfig.json` se define:

```
"compilerOptions": {
    "lib": [
      "ES2021.String"
    ]
}
```

para poder utilizar esa nueva funcionalidad, en caso de no utilizarla, o en versiones anteriores de JS, utilizar `.replace(/ /g, '')`
