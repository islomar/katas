# Esqueleto para Python

## Preparación del entorno

Es necesario:
* Git
* Python >= 2.7
* Pip: https://pip.pypa.io/en/stable/installing/ 
* Virtualenv (recomendado)
* Tu editor favorito (vim)


### Creación de un virtualenv (recomendado, no es imprescindible)

Instalación de virtualenv: http://rukbottoland.com/blog/tutorial-de-python-virtualenv/

Para crear el virtualenv hay dos opciones:

1. Usar directamente virtualenv:

  ```
  virtualenv <nombreDelVirtualEnv>
  source <nombreDelVirtualEnv>/bin/activate
  ```
2. Usar virtualenvwrapper (mkvirtualenv):

  ```
  mkvirtualenv <nombreDelVirtualEnv>
  ```

  Si ya lo hemos creado usando `mkvirtualenv` con anterioridad, lo podemos activar de nuevo con:

  ```
  workon <nombreDelVirtualEnv>
  ```

### Instalar las dependencias
Ejecutar `sudo pip install -r requirements-dev.txt`


## Ejectuar los tests
Para verificar que todo está correctamente instalado y funcionando, ejecutar los tests:

`mamba --format=documentation mymodule_spec.py`
