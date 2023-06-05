# prueba_tecnica
Esta es un proyecto destinado a ser la prueba tecnica de desarrollador java

Leer el Help.md para poder ver como usar los endpoints de la aplicacion


# Explicacion sobre los Endpoints 

## Enpoints de usuarios

### Agregar un usaurio

Metodo: POST
Url: /users

Objeto a mandar 

{
    "name": "el nombre del usuario",
    "username": "el usuario",
    "password": "la contraseña",
}

### Eliminar un usaurio
Metodo: DELETE
Url: /users/{id}
donde dice id, hay que mandar el id del usuario



## Endpoints de roles

### Agregar un rol
Metodo: POST
Url: /users

Objeto a mandar 

{
    "role_name": "el nombre del role",
}

### Asignar un rol
Metodo: POST
Url: /addRole

Objeto a mandar 

{
    "user": {
        "id": <int><id del usuario> 
    },
    "role": {
        "id": <int><id del usuario> 
    }
}
