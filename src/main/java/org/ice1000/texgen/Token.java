package org.ice1000.texgen;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface Token {
  @Contract(pure = true)
  @NotNull Attribute getAttribute();

  @Contract(pure = true)
  @NotNull CharSequence getContent();

  static Token from(@NotNull CharSequence sequence, @NotNull Attribute attribute) {
    var s = sequence.toString();
    switch (s) {
      case "\n":
      case "\r\n":
      case "\r":
        return NewlineToken.INSTANCE;
      default:
        break;
    }
    return new SimpleToken(s, attribute);
  }
}
