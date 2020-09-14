package org.ice1000.texgen.code;

import org.ice1000.texgen.tex.InlineComponent;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class Token {
  private final @NotNull String tokenType;
  private final @NotNull LayoutPolicy layoutPolicy;
  private final @NotNull CharSequence content;
  private final @NotNull Optional<InlineComponent> customTeX;

  public Token(
    @NotNull String tokenType,
    @NotNull LayoutPolicy layoutPolicy,
    @NotNull CharSequence content,
    @NotNull Optional<InlineComponent> customTeX
  ) {
    this.tokenType = tokenType;
    this.layoutPolicy = layoutPolicy;
    this.content = content;
    this.customTeX = customTeX;
  }

  @Contract(pure = true)
  public @NotNull String getTokenType() {
    return tokenType;
  }

  @Contract(pure = true)
  public @NotNull LayoutPolicy getLayoutPolicy() {
    return layoutPolicy;
  }

  @Contract(pure = true)
  public @NotNull CharSequence getContent() {
    return content;
  }

  @Contract(pure = true)
  public @NotNull Optional<InlineComponent> getCustomTeX() {
    return customTeX;
  }
}
