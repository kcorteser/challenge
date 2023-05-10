package com.kcorteser.challenge.constants;

public final class Globals {

    private Globals(){}

    public static final String TEXT_JSON = "text/json";
    public static final String APPLICATION_JSON = "application/json";
    public static final String JSON = "json";
    public static final String STATUS = "status";
    public static final String REQUEST_FILTER_URI = "/filter";
    public static final String MESSAGE_ERROR_JSON = "Valores de peticion incompletos.";
    public static final String MESSAGE_ERROR_EMPTY = "Sin resultados esperados.";
    public static final String MESSAGE_ERROR_EXCEPTION = "Ocurrio un error inesperado.";


    public static final String MESSAGE_TYPE_ERROR = "error";

    public static final String REQUEST_FILTER_DESCRIPTION = """
            <div class='alert alert-info'><h3><u><span class='label label-default'> Filtrado de datos por tipo y fecha </span></u></h3>
            Método que trae un listado por filtro y fecha. Recibe un json string con los siguientes parámetros:
            <ul class='list-group'> 
            <li class='list-group-item list-group-item-warning'><b><u>type:</u></b>Tipo. </li>
            <li class='list-group-item list-group-item-warning'><b><u>date:</u></b>fecha. </li>
            </ul>"
            <u>Ejemplo:</u></br>"
            <span class="label label-danger">Lista de transacciones</span>"
            <pre>{
                "<b>type</b>" : <em>"civil",</em>
                "<b>date</b>" : <em>"2023-01-01"</em>
            }</pre>"
            En caso de enviar los parámetros correctamente, deberá recibir un json con el resultado del proceso
            """;
}
