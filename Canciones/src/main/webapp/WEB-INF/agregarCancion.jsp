<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agregar Cancion</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <h1>Agregar Canción</h1>
    <form:form action="/canciones/procesa/agregar" method="POST" modelAttribute="cancion">
        <form:label path="titulo">Titulo:</form:label>
        <form:input type="text" path="titulo"/>
        <form:errors path="titulo"></form:errors>

        <form:label path="artista">Artista:</form:label>
        <form:input type="text" path="artista"/>
        <form:errors path="artista"></form:errors>

        <form:label path="album">Album:</form:label>
        <form:input type="text" path="album"/>
        <form:errors path="album"></form:errors>

        <form:label path="genero">Genero:</form:label>
        <form:input type="text" path="genero"/>
        <form:errors path="genero"></form:errors>

        <form:label path="idioma">Idioma:</form:label>
        <form:input type="text" path="idioma"/>
        <form:errors path="idioma"></form:errors>

        <input type="submit" value="Crear Canción">
    </form:form>
    <a href="/canciones"> &#8592; Volver a lista de canciones</a>
</body>
</html>