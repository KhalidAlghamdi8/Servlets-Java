package com.examples.lesson08.classicTags;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class ClassicTag extends BodyTagSupport {

  private String title;
  // A counter to repeat the body 5 times
  private int iteration = 0;

  public ClassicTag() {
    super();
  }

  /**
   * This method is called when the JSP engine encounters the start tag, after
   * the attributes are processed. Scripting variables (if any) have their
   * values set here.
   *
   * @return EVAL_BODY_BUFFERED if the JSP engine should evaluate the tag body,
   * otherwise return SKIP_BODY. This method is automatically generated. Do not
   * modify this method. Instead, modify the methods that this method calls.
   */
  @Override
  public int doStartTag() throws JspException {

    // Print something at the start of the tag. (only once)
    try {
      pageContext.getOut().println("<ul>");
    } catch (IOException e) {
      throw new JspException(e);
    }

    // This is usually set in the afterbody method BUT without setting it at the
    // start of the tag the first time the body is displayed it WONT have this
    // variable set. This is because the afterBody tag happens AFTER the
    // body is evaluated.
    pageContext.setAttribute("iteration", iteration);

    // tell the tag to evaluate the body.
    return EVAL_BODY_BUFFERED;
    // or tell it to not do the body with:
    // return SKIP_BODY;
  }

  /**
   * This method is called after the JSP engine finished processing the tag.
   *
   * @return EVAL_PAGE if the JSP engine should continue evaluating the JSP
   * page, otherwise return SKIP_PAGE. This method is automatically generated.
   * Do not modify this method. Instead, modify the methods that this method
   * calls.
   */
  @Override
  public int doEndTag() throws JspException {
    // Print something at the end of the tag. (only once)
    try {
      pageContext.getOut().println("</ul>");
    } catch (IOException e) {
      throw new JspException(e);
    }
    return EVAL_PAGE;
    // If you want to stop page processing after the tag is processed return 
    // this instead:
    // return SKIP_PAGE;
  }

  /**
   * This method is called after the JSP engine processes the body content of
   * the tag.
   *
   * @return EVAL_BODY_AGAIN if the JSP engine should evaluate the tag body
   * again, otherwise return SKIP_BODY. This method is automatically generated.
   * Do not modify this method. Instead, modify the methods that this method
   * calls.
   */
  @Override
  public int doAfterBody() throws JspException {
    //For the same reason you have to set the iteration variable in the doStartTag
    //method you have to increase all values here since this method executes
    //ONCE the body has been evaluated.
    iteration++;
    try {
      // This code is generated for tags whose bodyContent is "JSP"
      BodyContent bodyCont = getBodyContent();
      JspWriter out = bodyCont.getEnclosingWriter();

      // TODO: insert code to write html before writing the body content.
      out.println("<li>");
      out.print("<b>" + title + "</b> ");
      // write the body content (after processing by the JSP engine) on the output Writer
      bodyContent.writeOut(out);
      pageContext.setAttribute("iteration", iteration);
      // TODO: insert code to write html after writing the body content.
      out.println("</li>");

      // clear the body content for the next time through.
      bodyContent.clearBody();

    } catch (Exception ex) {
      throw new JspException("Error in ClassicTag tag", ex);
    }
    //repeat the body 5 times!
    if (iteration < 5) {
      return EVAL_BODY_AGAIN;
    } else {
      return SKIP_BODY;
    }
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
