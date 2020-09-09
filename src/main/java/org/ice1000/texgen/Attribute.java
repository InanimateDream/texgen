package org.ice1000.texgen;

public class Attribute {
  public static final Attribute DEFAULT = new Attribute(false, false, false, false, false);

  public Attribute(boolean isSansSerif, boolean isTrueType, boolean isBold, boolean isItalic, boolean isDoubleStrike) {
    this.isSansSerif = isSansSerif;
    this.isTrueType = isTrueType;
    this.isBold = isBold;
    this.isItalic = isItalic;
    this.isDoubleStrike = isDoubleStrike;
  }

  /** \textsf */
  public final boolean isSansSerif;
  /** \texttt */
  public final boolean isTrueType;
  /** \textbf */
  public final boolean isBold;
  /** \textit */
  public final boolean isItalic;
  /** \mathbb */
  public final boolean isDoubleStrike;
}
