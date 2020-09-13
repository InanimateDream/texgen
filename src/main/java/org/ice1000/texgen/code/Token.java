package org.ice1000.texgen.code;

import org.ice1000.texgen.tex.InlineComponent;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public interface Token {
  @Contract(pure = true)
  @NotNull CharSequence getContent();

  @Contract(pure = true)
  @NotNull Optional<InlineComponent> getCustomTeX();
}
