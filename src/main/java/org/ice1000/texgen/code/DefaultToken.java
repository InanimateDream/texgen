package org.ice1000.texgen.code;

import org.ice1000.texgen.tex.InlineComponent;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class DefaultToken implements Token {
  private final @NotNull CharSequence content;
  private final @NotNull Optional<InlineComponent> customTeX;

  public DefaultToken(@NotNull CharSequence content, @NotNull Optional<InlineComponent> customTeX) {
    this.content = content;
    this.customTeX = customTeX;
  }

  @Override
  @Contract(pure = true)
  public @NotNull CharSequence getContent() {
    return content;
  }

  @Override
  @Contract(pure = true)
  public @NotNull Optional<InlineComponent> getCustomTeX() {
    return customTeX;
  }
}
