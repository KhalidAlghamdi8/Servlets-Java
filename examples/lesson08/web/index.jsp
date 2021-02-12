<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="templateHeader.jsp">
  <jsp:param name="title" value="Lesson 08"/>
</jsp:include>
<script src="res/jquery.js" type="text/javascript"></script>
<a onclick="$('#cheatSheet').toggle();" href="#" style="text-align: right; display: block; width: 100%; background-color: #ddddff">Hide/Show&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
<table style="width: 100%">
  <tr>
    <td style="text-align: left; vertical-align: top">
      <h1>Lesson 08 - JSP Custom Tags - Examples</h1>
      <h2>Expression Language</h2>
      <p>You may use the Expression Language (EL) to display or provide values. Use Custom Tags to include
        logic that you would normally code using Java.</p>

      <h2>Java Standard Tag Libraries</h2>

      <table>
        <thead>
          <tr>
            <th>Example</th>
            <th>Source Code</th>
            <th>Description</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td rowspan="5"><a href="ShopListServlet">/ShopListServlet</a></td>
            <td><a href="sources/ShopListServlet.java.html">com.examples.lesson08.servlets.ShopListServlet</a></td>
            <td>The servlet that receives the request and processes it.</td>
          </tr>
          <tr>
            <td><a href="sources/shopListView.jsp.html">/shopListView.jsp</a></td>
            <td>The JSP view for the shopping list.</td>
          </tr>
          <tr>
            <td><a href="sources/ShopItem.java.html">com.examples.lesson08.ShopItem</a></td>
            <td>A model object that represents an item in the list.</td>
          </tr>
          <tr>
            <td><a href="sources/ShopList.java.html">com.examples.lesson08.model.ShopList</a></td>
            <td>A model object that contains the shopping list.</td>
          </tr>
          <tr>
            <td><a href="sources/ShoppingListSessionSetupListener.java.html">com.examples.lesson08.listeners. ShoppingListSessionSetupListener</a></td>
            <td>A session listener that sets up the ShopList object inside the session.</td>
          </tr>
        </tbody>
      </table>

      <h2>JSP Templating</h2>
      <p>You can use include directives or jsp:include or c:import tags to create templates.</p>
      <table>
        <thead>
          <tr>
            <th>Example</th>
            <th>Source Code</th>
            <th>Description</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td rowspan="3"><a href="shopListTemplated.jsp">/shopListTemplated.jsp</a></td>
            <td><a href="sources/shopListTemplated.jsp.html">/shopListTemplated.jsp</a></td>
            <td>The list of items using templates for the header and the footer of the page.</td>
          </tr>
          <tr>
            <td><a href="sources/templateHeader.jsp.html">/templateHeader.jsp</a></td>
            <td>The header of the page.</td>
          </tr>
          <tr>
            <td><a href="sources/templateFooter.jsp.html">/templateFooter.jsp</a></td>
            <td>The footer of the page.</td>
          </tr>
        </tbody>
      </table>

      <p>jsp:include includes the content of a resource in the same application in the current page while c:import
        can include resources outside the application.</p>
      <p>Another example of templating is this page: <a href="sources/index.jsp.html">/index.jsp</a></p>
      <p>Also using templates there is the <a href="cheatsheetView.jsp">cheatsheetView.jsp</a> 
        source code for <a href="sources/cheatsheetView.jsp.html">/cheatsheetView.jsp</a></p>
      <h2>JSP formatting and localization</h2>
      <table>
        <thead>
          <tr>
            <th>Example</th>
            <th>Source Code</th>
            <th>Description</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td rowspan="3">
              <ul>
                <li><a href="shopListFormatted.jsp?lang=en">/shopListFormatted.jsp?lang=en</a></li>
                <li><a href="shopListFormatted.jsp?lang=es">/shopListFormatted.jsp?lang=es</a></li>
              </ul>
            </td>
            <td><a href="sources/shopListFormatted.jsp.html">/shopListFormatted.jsp</a></td>
            <td>The list of items using internationalization with fmt tags.</td>
          </tr>
          <tr>
            <td><a href="sources/shoplist_en.properties.html">com.examples.lesson08.i18n.shoplist_en.properties</a></td>
            <td>The english messages.</td>
          </tr>
          <tr>
            <td><a href="sources/shoplist_es.properties.html">com.examples.lesson08.i18n.shoplist_es.properties</a></td>
            <td>The spanish messages.</td>
          </tr>
        </tbody>
      </table>

      <h2>JSP Expression Language functions</h2>

      <table>
        <thead>
          <tr>
            <th>Example</th>
            <th>Source Code</th>
            <th>Description</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>
              <ul>
                <li><a href="elfunctions.jsp">/elfunctions.jsp</a></li>
              </ul>
            </td>
            <td><a href="sources/elfunctions.jsp.html">/elfunctions.jsp</a></td>
            <td>EL functions demo.</td>
          </tr>
        </tbody>
      </table>

      <h2>Developing custom JSP tags.</h2>
      <p>In the following examples Custom JSP tags are demonstrated using the templating example.
        Instead of using JSP:include this example uses custom JSP tags.
      <h3>Custom Tag Files </h3>
      <table>
        <thead>
          <tr>
            <th>Example</th>
            <th>Source Code</th>
            <th>Description</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td rowspan="3">
              <a href="shopListTagFiles.jsp">/shopListTagFiles.jsp</a>
            </td>
            <td><a href="sources/shopListTagFiles.jsp.html">/shopListTagFiles.jsp</a></td>
            <td>The list of items using custom tags for templating.</td>
          </tr>
          <tr>
            <td><a href="sources/templateHeader.tag.html">/WEB-INF/tags/templateHeader.tag</a></td>
            <td>The tag for the header.</td>
          </tr>
          <tr>
            <td><a href="sources/templateFooter.tag.html">/WEB-INF/tags/templateFooter.tag</a></td>
            <td>The tag for the footer.</td>
          </tr>
        </tbody>
      </table>

      <h3>SimpleTagSupport</h3>
      <table>
        <thead>
          <tr>
            <th>Example</th>
            <th>Source Code</th>
            <th>Description</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td rowspan="4">
              <a href="simpleTagsTest.jsp">/simpleTagsTest.jsp</a>
            </td>
            <td><a href="sources/simpleTagsTest.jsp.html">/simpleTagsTest.jsp</a></td>
            <td>The JSP for testing the simple tags.</td>
          </tr>
          <tr>
            <td><a href="sources/simpleTags.tld.html">/WEB-INF/tlds/simpleTags.tld</a></td>
            <td>The tld file for the tags.</td>
          </tr>
          <tr>
            <td><a href="sources/HeaderSimpleTag.java.html">com.examples.lesson08.simpleTags.HeaderSimpleTag</a></td>
            <td>The implementation of the Header tag class.</td>
          </tr>
          <tr>
            <td><a href="sources/FooterSimpleTag.java.html">com.examples.lesson08.simpleTags.FooterSimpleTag</a></td>
            <td>The implementation of the Footer tag class.</td>
          </tr>
        </tbody>
      </table>


      <h2>Developing custom JSP Expression Language functions</h2>
      <table>
        <thead>
          <tr>
            <th>Example</th>
            <th>Source Code</th>
            <th>Description</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td rowspan="3">
              <a href="customEl.jsp">/customEl.jsp</a>
            </td>
            <td><a href="sources/customEl.jsp.html">/customEl.jsp</a></td>
            <td>The JSP for testing the custom EL functions.</td>
          </tr>
          <tr>
            <td><a href="sources/elFunctions.tld.html">/WEB-INF/tlds/elFunctions.tld</a></td>
            <td>The tld file for the custom functions.</td>
          </tr>
          <tr>
            <td><a href="sources/Functions.java.html">com.examples.lesson08.elfunctions.Functions</a></td>
            <td>The implementation of the EL functions.</td>
          </tr>
        </tbody>
      </table>


      <h4>TagSupport</h4>
      <p>There is another way to create tags but it is very verbose and not very intuitive.<br>
        Here its an example of how to create a complete tag.
      </p>
      <table>
        <thead>
          <tr>
            <th>Example</th>
            <th>Source Code</th>
            <th>Description</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td rowspan="3">
              <a href="classicTagsTest.jsp">/classicTagsTest.jsp</a>
            </td>
            <td><a href="sources/classicTagsTest.jsp.html">/classicTagsTest.jsp</a></td>
            <td>The JSP for testing the custom tag.</td>
          </tr>
          <tr>
            <td><a href="sources/classicTags.tld.html">/WEB-INF/tlds/classicTags.tld</a></td>
            <td>The tld file for the custom tag.</td>
          </tr>
          <tr>
            <td><a href="sources/ClassicTag.java.html">com.examples.lesson08.classicTags.ClassicTag</a></td>
            <td>The implementation of the tag.</td>
          </tr>
        </tbody>
      </table>

      <p>Unless you are working with legacy application favor creating SimpleTagSupport tags over BodyTagSupport tags.</p>

    </td>
    <td style="text-align: left; vertical-align: top; width: 400px; font-size: 68%;" id="cheatSheet">
      <jsp:include page="cheatsheet.jsp"/>
    </td>
  </tr>
</table>

<h1>Lesson 08 - Quizzes</h1>
<jsp:include page="quiz/quizzes.jsp"/>
<jsp:include page="templateFooter.jsp">
  <jsp:param name="footerNote" value="Made with JSP"/>
</jsp:include>