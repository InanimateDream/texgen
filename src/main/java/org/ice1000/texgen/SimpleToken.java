package org.ice1000.texgen;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * @see NewlineToken
 * @see Token#from
 */
public class SimpleToken implements Token {
  private final @NotNull CharSequence content;
  private final @NotNull Attribute attribute;

  public SimpleToken(@NotNull CharSequence content, @NotNull Attribute attribute) {
    this.content = content;
    this.attribute = attribute;
  }

  @Override
  @Contract(pure = true)
  public @NotNull Attribute getAttribute() {
    return attribute;
  }

  @Override
  @Contract(pure = true)
  public @NotNull CharSequence getContent() {
    return content;
  }
}
