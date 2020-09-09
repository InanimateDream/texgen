package org.ice1000.texgen;

import org.jetbrains.annotations.NotNull;

public class SimpleToken implements Token {
  private final @NotNull CharSequence content;

  public SimpleToken(@NotNull CharSequence content) {
    this.content = content;
  }

  @Override
  public @NotNull CharSequence getContent() {
    return content;
  }
}
