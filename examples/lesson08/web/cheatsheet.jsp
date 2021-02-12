<%@ page pageEncoding="UTF-8" %>
<h2>JSTL & EL <br>Cheat sheet</h2>
<h3>EL</h3>
<p>
  Expression Language allows you to output values as strings in a page or provide custom tags
  with object values.<br>
  <b>usage:</b><br>
  <b>&#36;{</b>EXPRESSION<b>}</b><br>
</p>
<p>NOTE: You cannot nest Expressions: 
  <b>&#36;{&#36;{</b>OBJECT_A<b>}</b>+<b>&#36;{</b>OBJECT_B<b>}}</b> is illegal.<br>
  Instead use:
  <b>&#36;{</b>OBJECT_A+OBJECT_B<b>}</b></p>
<h4>Expression Operators</h4>
<table style="font-size: 10pt;">
  <tr>
    <td style="font-weight: bold;">. , []</td>
    <td>access the contents of the property or map value inside an object.</td>
  </tr>
  <tr>
    <td style="font-weight: bold;">+, -, *, / div, % mod</td>
    <td>Basic arithmetic operations.</td>
  </tr>
  <tr>
    <td style="font-weight: bold;">&& and, || or, ! not</td>
    <td>Logical operators</td>
  </tr>
  <tr>
    <td style="font-weight: bold;">== eq, != ne, < lt, > gt, <= le, >= ge</td>
    <td>Comparisson (boolean, integer, String, integer or floating point)</td>
  </tr>
  <tr>
    <td style="font-weight: bold;">empty</td>
    <td>Determine if a value is null or empty (collections, strings)</td>
  </tr>
  <tr>
    <td style="font-weight: bold;">CONDITION ? EVAL_IF_TRUE : EVAL_IF_FALSE</td>
    <td>Conditional operator</td>
  </tr>
</table>
<h4>EL Functions</h4>
Taglibs may contain functions, functions are used in EL using the syntax:<br>
&#36;{prefix:functionName(params)}

<h3>JSTL</h3>
<h4>Core</h4>
Taglib directive:<br>
&lt;%@ taglib prefix=&quot;fmt&quot; uri=&quot;http://java.sun.com/jsp/jstl/fmt&quot; %&gt;

<table>
  <thead>
    <tr>
      <th> Tag </th>
      <th> Description </th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td width="15%"><b>catch</b></td>
      <td>
        Catches any Throwable that occurs in its body and optionally
        exposes it.
      </td>
    </tr>
    <tr>
      <td width="15%"><b>choose</b></td>
      <td>
        Simple conditional tag that establishes a context for
        mutually exclusive conditional operations, marked by
        &lt;when&gt; and &lt;otherwise&gt;
      </td>
    </tr>
    <tr>
      <td width="15%"><b>if</b></td>
      <td>
        Simple conditional tag, which evalutes its body if the
        supplied condition is true and optionally exposes a Boolean
        scripting variable representing the evaluation of this condition
      </td>
    </tr>
    <tr>
      <td width="15%"><b>import</b></td>
      <td>
        Retrieves an absolute or relative URL and exposes its contents
        to either the page, a String in 'var', or a Reader in 'varReader'.
      </td>
    </tr>

    <tr>
      <td width="15%"><b>forEach</b></td>
      <td>
        The basic iteration tag, accepting many different
        collection types and supporting subsetting and other
        functionality
      </td>
    </tr>
    <tr>
      <td width="15%"><b>forTokens</b></td>
      <td>Iterates over tokens, separated by the supplied delimeters</td>
    </tr>
    <tr>
      <td width="15%"><b>out</b></td>
      <td>Like &lt;%= ... &gt;, but for expressions.</td>
    </tr>
    <tr>
      <td width="15%"><b>otherwise</b></td>
      <td>
        Subtag of &lt;choose&gt; that follows &lt;when&gt; tags
        and runs only if all of the prior conditions evaluated to
        'false'
      </td>
    </tr>
    <tr>
      <td width="15%"><b>param</b></td>
      <td>Adds a parameter to a containing 'import' tag's URL.</td>
    </tr>
    <tr>
      <td width="15%"><b>redirect</b></td>
      <td> Redirects to a new URL. </td>
    </tr>
    <tr>
      <td width="15%"><b>remove</b></td>
      <td>Removes a scoped variable (from a particular scope, if specified).</td>
    </tr>
    <tr>
      <td width="15%"><b>set</b></td>
      <td>Sets the result of an expression evaluation in a 'scope'</td>
    </tr>
    <tr>
      <td width="15%"><b>url</b></td>
      <td>Creates a URL with optional query parameters.</td>
    </tr>
    <tr>
      <td width="15%"><b>when</b></td>
      <td>
        Subtag of &lt;choose&gt; that includes its body if its
        condition evalutes to 'true'
      </td>
    </tr>
  </tbody>
</table>

<h4>Formatting</h4>
&lt;%@ taglib prefix=&quot;fmt&quot; uri=&quot;http://java.sun.com/jsp/jstl/fmt&quot; %&gt;

<table>
  <thead>
    <tr>
      <th> Tag </th>
      <th> Description </th>
    </tr>
  </thead>
  <tbody>
    </tr>
    <tr>
      <td width="15%"><b>requestEncoding</b></td>
      <td>Sets the request character encoding</td>
    </tr>
    <tr>
      <td width="15%"><b>setLocale</b></td>
      <td>Stores the given locale in the locale configuration variable</td>
    </tr>
    <tr>
      <td width="15%"><b>timeZone</b></td>
      <td>
        Specifies the time zone for any time formatting or parsing actions
        nested in its body
      </td>
    </tr>
    <tr>
      <td width="15%"><b>setTimeZone</b></td>
      <td>Stores the given time zone in the time zone configuration variable</td>
    </tr>
    <tr>
      <td width="15%"><b>bundle</b></td>
      <td>Loads a resource bundle to be used by its tag body</td>
    </tr>
    <tr>
      <td width="15%"><b>setBundle</b></td>
      <td>
        Loads a resource bundle and stores it in the named scoped variable or
        the bundle configuration variable
      </td>
    </tr>
    <tr>
      <td width="15%"><b>message</b></td>
      <td>Maps key to localized message and performs parametric replacement</td>
    </tr>
    <tr>
      <td width="15%"><b>param</b></td>
      <td>
        Supplies an argument for parametric replacement to a containing
        &lt;message&gt; tag
      </td>
    </tr>
    <tr>
      <td width="15%"><b>formatNumber</b></td>
      <td>Formats a numeric value as a number, currency, or percentage</td>
    </tr>
    <tr>
      <td width="15%"><b>parseNumber</b></td>
      <td>Parses the string representation of a number, currency, or percentage</td>
    </tr>
    <tr>
      <td width="15%"><b>formatDate</b></td>
      <td>Formats a date and/or time using the supplied styles and pattern</td>
    </tr>
    <tr>
      <td width="15%"><b>parseDate</b></td>
      <td>Parses the string representation of a date and/or time</td>
    </tr>
  </tbody>
</table>

<h4>Xml</h4>
&lt;%@ taglib prefix=&quot;x&quot; uri=&quot;http://java.sun.com/jsp/jstl/xml&quot; %&gt;
<table>
  <thead>
    <tr>
      <th> Tag </th>
      <th> Description </th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td width="15%"><b>choose</b></td>
      <td>
        Simple conditional tag that establishes a context for
        mutually exclusive conditional operations, marked by
        &lt;when&gt; and &lt;otherwise&gt;
      </td>
    </tr>
    <tr>
      <td width="15%"><b>out</b></td>
      <td>Like &lt;%= ... &gt;, but for XPath expressions.</td>
    </tr>
    <tr>
      <td width="15%"><b>if</b></td>
      <td>
        XML conditional tag, which evalutes its body if the
        supplied XPath expression evalutes to 'true' as a boolean
      </td>
    </tr>
    <tr>
      <td width="15%"><b>forEach</b></td>
      <td>XML iteration tag.</td>
    </tr>
    <tr>
      <td width="15%"><b>otherwise</b></td>
      <td>
        Subtag of &lt;choose&gt; that follows &lt;when&gt; tags
        and runs only if all of the prior conditions evaluated to
        'false'
      </td>
    </tr>
    <tr>
      <td width="15%"><b>param</b></td>
      <td>Adds a parameter to a containing 'transform' tag's Transformer</td>
    </tr>
    <tr>
      <td width="15%"><b>parse</b></td>
      <td>Parses XML content from 'source' attribute or 'body'</td>
    </tr>
    <tr>
      <td width="15%"><b>set</b></td>
      <td>Saves the result of an XPath expression evaluation in a 'scope'</td>
    </tr>
    <tr>
      <td width="15%"><b>transform</b></td>
      <td>
        Conducts a transformation given a source XML document
        and an XSLT stylesheet
      </td>
    </tr>
    <tr>
      <td width="15%"><b>when</b></td>
      <td>
        Subtag of &lt;choose&gt; that includes its body if its
        expression evalutes to 'true'
      </td>
    </tr>
  </tbody>
</table>


<h4>Sql</h4>
&lt;%@ taglib prefix=&quot;sql&quot; uri=&quot;http://java.sun.com/jsp/jstl/sql&quot; %&gt;


<table>
  <thead>
    <tr>
      <th> Tag </th>
      <th> Description </th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td width="15%"><b>transaction</b></td>
      <td>
        Provides nested database action elements with a shared Connection,
        set up to execute all statements as one transaction.
      </td>
    </tr>
    <tr>
      <td width="15%"><b>query</b></td>
      <td>
        Executes the SQL query defined in its body or through the
        sql attribute.
      </td>
    </tr>
    <tr>
      <td width="15%"><b>update</b></td>
      <td>
        Executes the SQL update defined in its body or through the
        sql attribute.
      </td>
    </tr>
    <tr>
      <td width="15%"><b>param</b></td>
      <td>Sets a parameter in an SQL statement to the specified value.</td>
    </tr>
    <tr>
      <td width="15%"><b>dateParam</b></td>
      <td>Sets a parameter in an SQL statement to the specified java.util.Date value.</td>
    </tr>
    <tr>
      <td width="15%"><b>setDataSource</b></td>
      <td>Creates a simple DataSource suitable only for prototyping.</td>
    </tr>
  </tbody>
</table>
It is recommended to handle database access in servlets.

<h4>Functions</h4>
&lt;%@ taglib prefix=&quot;fn&quot; uri=&quot;http://java.sun.com/jsp/jstl/functions&quot; %&gt;

<table>
  <thead>
    <tr>
      <th>Function </th>
      <th>Description</th>
    </tr>
  </thead>
  <tbody>
   <tr>
      <td align="right" width="15%"><code>boolean <b>contains</b>( String, String)</code></td>
      <td>Tests if an input string contains the specified substring.</td>
    </tr>
    <tr>
      <td align="right" width="15%"><code>boolean <b>containsIgnoreCase</b>( String, String)</code></td>
      <td>Tests if an input string contains the specified substring in a case insensitive way.</td>
    </tr>
    <tr>
      <td align="right" width="15%"><code>boolean <b>endsWith</b>( String, String)</code></td>
      <td>Tests if an input string ends with the specified suffix.</td>
    </tr>
    <tr>
      <td align="right" width="15%"><code>String <b>escapeXml</b>( String)</code></td>
      <td>Escapes characters that could be interpreted as XML markup.</td>
    </tr>
    <tr>
      <td align="right" width="15%"><code>int <b>indexOf</b>( String, String)</code></td>
      <td>Returns the index withing a string of the first occurrence of a specified substring.</td>
    </tr>
    <tr>
      <td align="right" width="15%"><code>String <b>join</b>( String[], String)</code></td>
      <td>Joins all elements of an array into a string.</td>
    </tr>
    <tr>
      <td align="right" width="15%"><code>int <b>length</b>( Object)</code></td>
      <td>Returns the number of items in a collection, or the number of characters in a string.</td>
    </tr>
    <tr>
      <td align="right" width="15%"><code>String <b>replace</b>( String, String, String)</code></td>
      <td>
        Returns a string resulting from replacing in an input string all occurrences
        of a "before" string into an "after" substring.
      </td>
    </tr>
    <tr>
      <td align="right" width="15%"><code>String[] <b>split</b>( String, String)</code></td>
      <td>Splits a string into an array of substrings.</td>
    </tr>
    <tr>
      <td align="right" width="15%"><code>boolean <b>startsWith</b>( String, String)</code></td>
      <td>Tests if an input string starts with the specified prefix.</td>
    </tr>
    <tr>
      <td align="right" width="15%"><code>String <b>substring</b>( String, int, int)</code></td>
      <td>Returns a subset of a string.</td>
    </tr>
    <tr>
      <td align="right" width="15%"><code>String <b>substringAfter</b>( String, String)</code></td>
      <td>Returns a subset of a string following a specific substring.</td>
    </tr>
    <tr>
      <td align="right" width="15%"><code>String <b>substringBefore</b>( String, String)</code></td>
      <td>Returns a subset of a string before a specific substring.</td>
    </tr>
    <tr>
      <td align="right" width="15%"><code>String <b>toLowerCase</b>( String)</code></td>
      <td>Converts all of the characters of a string to lower case.</td>
    </tr>
    <tr>
      <td align="right" width="15%"><code>String <b>toUpperCase</b>( String)</code></td>
      <td>Converts all of the characters of a string to upper case.</td>
    </tr>
    <tr>
      <td align="right" width="15%"><code>String <b>trim</b>( String)</code></td>
      <td>Removes white spaces from both ends of a string.</td>
    </tr>
  </tbody>
</table>
