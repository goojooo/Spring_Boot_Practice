<%@page isELIgnored="false" %>

<h1 style="color:green; text-align:center">
    welcome spring boot mvc
</h1>

<br>

<b>model attributes are :: 
<%= request.getAttribute("sysDate") %>
<%= request.getAttribute("age") %>
</b>

<br>

<b>
model attributes are :: 
${requestScope.sysDate}, 
${requestScope.age}
</b>

<br>

<b>
model attributes are :: 
${sysDate}, 
${age}
</b>

<br>