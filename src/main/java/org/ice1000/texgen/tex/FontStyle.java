package org.ice1000.texgen.tex;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public enum FontStyle implements TeXStyle {
  Normal, Upright, Slanted, Roman, TypeWriter, SansSerif, Boldface, Italic, SmallCaps;

  @Contract(pure = true)
  private @NotNull String format() {
    switch (this) {
      case Normal:
        return "\\textnormal{%s}";
      case Upright:
        return "\\textup{%s}";
      case Slanted:
        return "\\textsl{%s}";
      case Roman:
        return "\\textrm{%s}";
      case TypeWriter:
        return "\\texttt{%s}";
      case SansSerif:
        return "\\textsf{%s}";
      case Boldface:
        return "\\textbf{%s}";
      case Italic:
        return "\\textit{%s}";
      case SmallCaps:
        return "\\textsc{%s}";
      default:
        return "%s";
    }
  }

  @Contract(pure = true)
  private @NotNull ComponentCreator creator() {
    return comp -> String.format(format(), comp.toCode());
  }

  @Override
  public @NotNull InlineComponent inline(@NotNull InlineComponent comp) {
    return creator().visitInlineComponent(comp);
  }

  @Override
  public @NotNull BlockComponent block(@NotNull BlockComponent comp) {
    return creator().visitBlockComponent(comp);
  }
}
