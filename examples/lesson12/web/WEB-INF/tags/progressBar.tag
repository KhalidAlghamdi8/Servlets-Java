<%@tag description="ProgressBar" pageEncoding="UTF-8" body-content="empty"%>
<%@attribute name="value" required="true" rtexprvalue="true" type="com.examples.lesson12.model.QuizResult"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="message"%>
<table style="border-collapse:collapse; border-spacing: 0px; padding: 0px; height: 5px;">
  <tr style="padding: 0px; border: 0px;">
    <c:forEach begin="0" end="${value.questionsToAsk-1}" var="qNum" >
      <c:set var="bg" value="#FFFFFF"/>
      <c:if test="${qNum<value.quizQuestions}">
        <c:set var="bg" value="#FF0000"/>
      </c:if>
      <c:if test="${qNum<value.quizPoints}">
        <c:set var="bg" value="#00FF00"/>
      </c:if>
      <td style="background-color: ${bg};border: 1px solid #777777; width:${value.cellWidth}px;"></td>
    </c:forEach>
  </tr>
</table>
