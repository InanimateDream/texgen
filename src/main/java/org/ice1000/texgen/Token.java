package org.ice1000.texgen;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface Token {
  @Contract(pure = true)
  @NotNull Attribute getAttribute();

  @Contract(pure = true)
  @NotNull CharSequence getContent();

  List<String> NEWLINES = List.of("\n", "\r\n", "\r");
  static Token from(@NotNull CharSequence sequence, @NotNull Attribute attribute) {
    var s = sequence.toString();
    if (NEWLINES.contains(s)) {
      return NewlineToken.INSTANCE;
    // } else if (s.isBlank()) {
    } else {
      return new SimpleToken(s, attribute);
    }
  }
}
