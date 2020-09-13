package org.ice1000.texgen.code;

import org.ice1000.texgen.tex.InlineComponent;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class IdentifierToken extends DefaultToken {

  public IdentifierToken(@NotNull CharSequence content, @NotNull Optional<InlineComponent> customTeX) {
    super(content, customTeX);
  }
}
