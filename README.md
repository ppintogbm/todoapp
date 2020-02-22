# TodoApp with Liberty

Pequeña aplicación para hacer pruebas de WLP en Openshift
----------

Para construir la aplicación, basta con la ejecución del siguiente comando:

`oc new-app https://github.com/ppintogbm/todoapp.git`

Una vez iniciada la aplicación, se debe exponer la misma creando una ruta para ella, ya sea con la interfaz web o con el siguiente comando:

`oc expose svc/todoapp`