package org.ice1000.texgen;

import org.jetbrains.annotations.NotNull;

public class Attribute {
  public static final Attribute DEFAULT = new Attribute("black", false, false, false, false, false);

  public Attribute(
    @NotNull String colorName,
    boolean isSansSerif,
    boolean isTrueType,
    boolean isBold,
    boolean isItalic,
    boolean isDoubleStrike
  ) {
    this.colorName = colorName;
    this.isSansSerif = isSansSerif;
    this.isTrueType = isTrueType;
    this.isBold = isBold;
    this.isItalic = isItalic;
    this.isDoubleStrike = isDoubleStrike;
  }

  public final @NotNull String colorName;
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
