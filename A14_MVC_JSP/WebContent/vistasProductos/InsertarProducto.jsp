<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/Controlador_Productos" method="post">
<label for="CodProd">CodProd</label>
<input type="text"  name="CodProd"><br>

<label for="seccion">Seccion</label>
      <select name="secciones" id="seccion">
        <option value="ferreteria">Ferretería</option>
        <option value="confeccion">Confección</option>
        <option value="deportes">Deportes</option>
      </select>
      
<br>
<label for="articulo">Nombre artículo:</label>
<input type="text"  name="articulo"><br>

<label for="precio">Precio:</label>
<input type="text"  name="precio"><br>

<label for="fecha">Fecha:</label>
<input type="date"  name="fecha"><br>

<label for="importada">Importado:</label>
<input type="radio" name="importado" value="si">Sí
<input type="radio" name="importado" value="no">No<br>
   
<label for="pais">País:</label>
<input type="text"  name="pais"><br>

<input type="submit" name="guarda" value="Insertar" />
<input type="reset" name="buttom" value="Restablecer" />
</form>
</body>
</html>