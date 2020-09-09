package org.ice1000.texgen;

import org.jetbrains.annotations.NotNull;

public class NewlineToken implements Token {
  public static final @NotNull NewlineToken INSTANCE = new NewlineToken();

  private NewlineToken() {}

  @Override
  public @NotNull Attribute getAttribute() {
    return Attribute.DEFAULT;
  }

  @Override
  public @NotNull CharSequence getContent() {
    return "\n";
  }
}
