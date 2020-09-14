package org.ice1000.texgen.gen;

import org.ice1000.texgen.code.Token;
import org.ice1000.texgen.tex.InlineComponent;
import org.ice1000.texgen.tex.PlainText;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class TeXConfig {
  public @NotNull Function<Token, InlineComponent> basicConvertor = tk ->
    tk.getCustomTeX().orElse(new PlainText(tk.getContent()));
}
