package org.ice1000.texgen;

import org.jetbrains.annotations.NotNull;

public interface Token {
  @NotNull Attribute getAttribute();
  @NotNull CharSequence getContent();
}
