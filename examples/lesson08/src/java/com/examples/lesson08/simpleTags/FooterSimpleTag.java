package com.examples.lesson08.simpleTags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class FooterSimpleTag extends SimpleTagSupport {

  @Override
  public void doTag() throws JspException {
    JspWriter out = getJspContext().getOut();
    try {
      out.println("<ul>");
      for (int i = 0; i < 5; i++) {
        out.println("<li>");
        getJspContext().setAttribute("iteration", i);
        JspFragment f = getJspBody();
        if (f != null) {
          f.invoke(out);
        }
        out.println("</li>");
      }
      out.println("</ul>");
    } catch (java.io.IOException ex) {
      throw new JspException("Error in FooterSimpleTag tag", ex);
    }
  }
}
