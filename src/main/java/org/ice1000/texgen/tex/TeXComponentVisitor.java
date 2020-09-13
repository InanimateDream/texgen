package org.ice1000.texgen.tex;

import org.jetbrains.annotations.NotNull;

public interface TeXComponentVisitor<T> {
  @NotNull T visitInlineComponent(@NotNull InlineComponent inl);
  @NotNull T visitBlockComponent(@NotNull BlockComponent inr);
}
