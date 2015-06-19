<%--
  Copyright (C) 2015 Oleg Chirukhin
  Licensed under the Apache License 2.0,
  see LICENSE-2.0.txt, LICENSE (it's a copy of LICENSE-2.0.txt) and NOTICE for additional information.
  Precise date is 30.01.15, time is 7:30.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">


        <div class="body">
            <h1>Manage users!</h1>

            <c:url var="addAction" value="/users/add" ></c:url>

            <form:form action="${addAction}" commandName="user" modelAttribute="user">
                <table>
                    <c:if test="${!empty user.name}">
                        <tr>
                            <td>
                                <form:label path="id">
                                    <spring:message text="ID"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="id" readonly="true" size="8"  disabled="true" />
                                <form:hidden path="id" />
                            </td>
                        </tr>
                    </c:if>
                    <tr>
                        <td>
                            <form:label path="name">
                                <spring:message text="Name"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="name" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <c:if test="${!empty user.name}">
                                <input type="submit"
                                       value="<spring:message text="Edit User"/>" />
                            </c:if>
                            <c:if test="${empty user.name}">
                                <input type="submit"
                                       value="<spring:message text="Add User"/>" />
                            </c:if>
                        </td>
                    </tr>
                </table>
            </form:form>

            <c:if test="${!empty users}">
                <table>
                    <tr>
                        <th width="80">User ID</th>
                        <th width="120">User Name</th>
                        <th width="60">Edit</th>
                        <th width="60">Delete</th>
                    </tr>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td><a href="<c:url value='/edit/${user.id}' />">Edit</a></td>
                            <td><a href="<c:url value='/remove/${user.id}' />">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>

        </div>


    </tiles:putAttribute>
</tiles:insertDefinition>