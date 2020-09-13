package org.ice1000.texgen.tex;

import org.jetbrains.annotations.NotNull;

public interface TeXStyle {

  @NotNull BlockComponent block(@NotNull BlockComponent comp);
  @NotNull InlineComponent inline(@NotNull InlineComponent comp);
}
