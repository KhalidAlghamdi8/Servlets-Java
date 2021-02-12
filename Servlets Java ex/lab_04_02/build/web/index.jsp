<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Vote Page</title>
  </head>
  <body>
    <h1>Current Polls</h1>
    <form action="PollServlet" method="POST">
      <h2>Whats your favorite color?</h2>
      <input type="radio" name="option" value="red">red<br>
      <input type="radio" name="option" value="blue">blue<br>
      <input type="radio" name="option" value="green">green<br>
      <input type="hidden" name="pollName" value="Colors">
      <input type="submit" value="submit">
    </form>

    <form action="PollServlet" method="POST">
      <h2>Whats your gender?</h2>
      <input type="radio" name="option" value="male">male<br>
      <input type="radio" name="option" value="female">female<br>
      <input type="hidden" name="pollName" value="Gender">
      <input type="submit" value="submit">
    </form>

    <form action="PollServlet" method="POST">
      <h2>Dogs or cats?</h2>
      <input type="radio" name="option" value="dogs">dogs<br>
      <input type="radio" name="option" value="cats">cats<br>
      <input type="radio" name="option" value="birds">birds<br>
      <input type="hidden" name="pollName" value="Pets">
      <input type="submit" value="submit">
    </form>


  </body>
</html>
