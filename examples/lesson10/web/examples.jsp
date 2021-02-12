<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h2>Asynchronous Servlets</h2>

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
        Hello async
        <a href="helloAsync.jsp">/helloAsync.jsp</a>
      </td>
      <td><a href="sources/helloAsync.jsp.html">/helloAsync.jsp</a></td>
      <td>The JSP page that calls the asynchronous servlet using JavaScript</td>
    </tr>
    <tr>
      <td>
        Hello async (continous)
        <a href="helloContinousAsync.jsp">/helloContinousAsync.jsp</a>
      </td>
      <td><a href="sources/helloContinousAsync.jsp.html">/helloContinousAsync.jsp</a></td>
      <td>The JSP page that calls the asynchronous servlet using JavaScript continously</td>
    </tr>
    <tr>
      <td rowspan="3">&nbsp;</td>
      <td><a href="sources/HelloAsyncServlet.java.html">com.examples.lesson10.servlets.HelloAsyncServlet</a></td>
      <td>The asynchronous servlet.</td>
    </tr>
    <tr>
      <td><a href="sources/HelloAsyncListener.java.html">com.examples.lesson10.servlets.listeners.HelloAsyncListener</a></td>
      <td>A simple async listener.</td>
    </tr>
    <tr>
      <td><a href="sources/HelloAsyncWorker.java.html">com.examples.lesson10.servlets.workers.HelloAsyncWorker</a></td>
      <td>The runnable worker that prints to the response.</td>
    </tr>

    <tr>
      <td rowspan="4">
        Random numbers (long polling)
        <a href="randomNumberAsync.jsp">/randomNumberAsync.jsp</a>
      </td>
      <td><a href="sources/randomNumberAsync.jsp.html">/randomNumberAsync.jsp</a></td>
      <td>The JSP page that calls the asynchronous servlet using JavaScript</td>
    </tr>
    <tr>
      <td><a href="sources/RandomNumberServlet.java.html">com.examples.lesson10.servlets.RandomNumberServlet</a></td>
      <td>The asynchronous servlet.</td>
    </tr>
    <tr>
      <td><a href="sources/RandomNumberListener.java.html">com.examples.lesson10.servlets.listeners.RandomNumberListener</a></td>
      <td>A simple async listener.</td>
    </tr>

    <tr>
      <td><a href="sources/RandomNumberWorker.java.html">com.examples.lesson10.servlets.workers.RandomNumberWorker</a></td>
      <td>The runnable class that implements the counting logic and sends the stream of data to the page.</td>
    </tr>

    <tr>
      <td rowspan="3">
        Response streaming 
        <a href="countAsync.jsp">/countAsync.jsp</a>
      </td>
      <td><a href="sources/countAsync.jsp.html">/countAsync.jsp</a></td>
      <td>The JSP page that calls the asynchronous servlet using JavaScript</td>
    </tr>
    <tr>
      <td><a href="sources/CountServlet.java.html">com.examples.lesson10.servlets.CountServlet</a></td>
      <td>The asynchronous servlet.</td>
    </tr>
    <tr>
      <td><a href="sources/CountToTenAsyncWorker.java.html">com.examples.lesson10.servlets.workers.CountToTenAsyncWorker</a></td>
      <td>The runnable class implements the counting logic and sends the stream of data to the page.</td>
    </tr>
  </tbody>
</table>
<p>Asynchronous servlets enable you to handle the request and response on a separate thread than the calling servlet.
  It is a good idea to allow the task to be interrupted if the request is cancelled this is done using Listeners.</p>
<h2>File Upload</h2>
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
      <td><a href="uploadForm.html">/uploadForm.html</a></td>
      <td><a href="sources/uploadForm.html.html">/uploadForm.html</a></td>
      <td>The HTML dorm that asks for an  image.</td>
    </tr>
    <tr>
      <td><a href="ImageStorageServlet">/FileServlet</a></td>
      <td><a href="sources/ImageStorageServlet.java.html">com.examples.lesson10.servlets.ImageStorageServlet</a></td>
      <td>The servlet that handles the upload.</td>
    </tr>
  </tbody>
</table>

