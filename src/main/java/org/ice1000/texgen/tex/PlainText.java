package org.ice1000.texgen.tex;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class PlainText implements InlineComponent {
  private final @NotNull CharSequence content;

  public PlainText(@NotNull CharSequence content) {
    this.content = content;
  }

  @Override
  @Contract(pure = true)
  public @NotNull CharSequence toCode() {
    return content;
  }
}
