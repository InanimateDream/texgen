package org.ice1000.texgen.code;

public class LayoutPolicy {
  public final boolean box;
  public final boolean operator;
  public final boolean delimiter;
  public final boolean indentator;
  public final boolean whitespace;
  public final boolean newline;

  public static final LayoutPolicy BOX = new LayoutPolicy(true, false, false, false, false, false);
  public static final LayoutPolicy OPERATOR = new LayoutPolicy(false, true, false, false, false, false);
  public static final LayoutPolicy DELIMITER = new LayoutPolicy(false, false, true, false, false, false);

  public LayoutPolicy(
    boolean box,
    boolean operator,
    boolean delimiter,
    boolean indentator,
    boolean whitespace,
    boolean newline
  ) {
    this.box = box;
    this.operator = operator;
    this.delimiter = delimiter;
    this.indentator = indentator;
    this.whitespace = whitespace;
    this.newline = newline;
  }
}
