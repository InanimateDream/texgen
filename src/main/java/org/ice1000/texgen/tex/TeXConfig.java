package org.ice1000.texgen.tex;

import org.ice1000.texgen.code.Token;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class TeXConfig {
  public @NotNull Function<Token, InlineComponent> basicConvertor = tk -> new PlainText(tk.getContent());
}
