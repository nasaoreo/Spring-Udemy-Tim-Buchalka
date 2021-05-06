<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="academy.learningprogramming.util.Mappings" %>

        <html>

        <head>
            <title>View Item</title>
        </head>

        <body>
            <div align="center">
                <c:url var="itemsLink" value="${Mappings.ITEMS}" />
                <a href="${itemsLink}">Back</a>

                <table border="1" cellpadding="5">
                    <caption>
                        <h2>View Item</h2>
                    </caption>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Deadline</th>
                        <th>Details</th>
                    </tr>
                    <tr>
                        <td>
                           <c:out value="${todoItem.id}" />
                        </td>
                        <td>
                           <c:out value="${todoItem.title}" />
                        </td>
                        <td>
                           <c:out value="${todoItem.deadline}" />
                        </td>
                        <td>
                           <c:out value="${todoItem.details}" />
                        </td>
                    <tr />
                </table>
            </div>
        </body>

        </html>
