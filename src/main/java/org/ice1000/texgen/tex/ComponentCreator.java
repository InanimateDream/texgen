package org.ice1000.texgen.tex;

import org.jetbrains.annotations.NotNull;

public interface ComponentCreator extends TeXComponentVisitor<TeXComponent> {
  @NotNull CharSequence toCode(@NotNull TeXComponent comp);

  @Override
  default @NotNull InlineComponent visitInlineComponent(@NotNull InlineComponent inl) {
    return () -> toCode(inl);
  }

  @Override
  default @NotNull BlockComponent visitBlockComponent(@NotNull BlockComponent inr) {
    return () -> toCode(inr);
  }
}
