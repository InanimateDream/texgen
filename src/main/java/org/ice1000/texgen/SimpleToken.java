package org.ice1000.texgen;

import org.jetbrains.annotations.NotNull;

public class SimpleToken implements Token {
  private final @NotNull CharSequence content;
  private final @NotNull Attribute attribute;

  public SimpleToken(@NotNull CharSequence content, @NotNull Attribute attribute) {
    this.content = content;
    this.attribute = attribute;
  }

  @Override
  public @NotNull Attribute getAttribute() {
    return attribute;
  }

  @Override
  public @NotNull CharSequence getContent() {
    return content;
  }
}
