<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="../layout/taglib.jsp" %>


<form:form commandName="user" cssClass="form-horizontal">
    
    <c:if test="${param.success eq true}">
        <div class="alert alert-success">Registration successfull!</div>
    </c:if>
    
    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Name:</label>
        <div class="col-sm-10">
            <form:input path="name" cssClass="form-control"></form:input>
        </div>
    </div>
    <div class="form-group">
        <label for="email" class="col-sm-2 control-label">Email:</label>
        <div class="col-sm-10">
            <form:input path="email" cssClass="form-control"></form:input>
        </div>
    </div>
    <div class="form-group">
        <label for="password" class="col-sm-2 control-label">Password:</label>
        <div class="col-sm-10">
        <form:password path="password" cssClass="form-control"></form:password>
        </div>
    </div>
 <div class="form-group">
    <div class="col-sm-2">
      <input type="submit" value="Save" class="btn btn-large btn-primary">
    </div>
  </div>
</form:form>