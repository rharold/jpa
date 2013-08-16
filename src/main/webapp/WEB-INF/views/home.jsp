<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page session="false" %>
<html>
<head>
    <script type='text/javascript' src='//code.jquery.com/jquery-2.0.2.js'></script>
    <script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js" />"></script>    
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" type="text/css"/> 
    
	<title>Home</title>
</head>
<body>
<h1>
	Symptom List  
</h1>

<table class="table" style="width: 500pt;">
  <tr>
    <th><spring:message code="symptom.table.procref"/></th>  
    <th><spring:message code="symptom.table.subtype"/></th>
    <th><spring:message code="symptom.table.spa"/></th>  
  </tr>
  <c:forEach items="${symptoms}" var="symptom"> 
  
  <tr>
    <td>${symptom.procref}</td>
    <td>${symptom.subtype}</td>
    <td>${symptom.spaVersion}</td>
    
    <td><div><form:form style="float: left;" action="delete/${symptom.id}" method="POST"><button type="submit" class="btn">Delete</button></form:form> <button style="margin-left: 10pt" onclick="edit('${symptom.id}','${symptom.procref}','${symptom.subtype}', '${symptom.spaVersion}')" class="btn">Edit</button></div></td>
     
  </tr>
  </c:forEach> 
</table>

<a id="add-button" href="#myModal" role="button" class="btn" data-toggle="modal">Add</a>
 
<!-- Modal -->
<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
    <h3 id="myModalLabel">Symptom Details</h3>
  </div>
  <div class="modal-body">
    <form:form id="symptom-form" action="create" method="POST">
        <fieldset>
		    <label>procref</label>
		    <input id="id" type="hidden" name="id">
		    <input id="procref" name="procref" type="text" placeholder="Type something...">
		    <label>spa version</label>
		    <input id="spaVersion" name="spaVersion" type="text" placeholder="Type something...">
		    <label>sub type</label>
		    <input id="subtype" name="subtype" type="text" placeholder="Type something...">
		    <br>		    
		    <button type="submit" class="btn">Submit</button>
		  </fieldset>
    </form:form> 
  </div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
  </div>
</div>


</body>
</html>

<script>
    function edit(id, procref, subtype, spaVersion) {
    	$("#id").val(id);
    	$("#procref").val(procref);
    	$("#spaVersion").val(subtype);
    	$("#subtype").val(spaVersion);
    	
    	$("#symptom-form").attr("action","edit");
    	
    	$("#add-button").click();
    }
</script>

