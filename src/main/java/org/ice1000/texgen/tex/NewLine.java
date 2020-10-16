package org.ice1000.texgen.tex;

import org.jetbrains.annotations.NotNull;

public class NewLine {
  public static @NotNull InlineComponent PLAIN = () -> "\\\\";
}
