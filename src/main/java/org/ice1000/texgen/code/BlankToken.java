package org.ice1000.texgen.code;

import org.ice1000.texgen.tex.InlineComponent;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class BlankToken extends DefaultToken {

  public BlankToken(@NotNull CharSequence content, @NotNull Optional<InlineComponent> customTeX) {
    super(content, customTeX);
  }
}
